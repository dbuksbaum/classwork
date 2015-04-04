package org.buksbaum.WeatherStation.controllers;

import org.buksbaum.WeatherStation.model.TemperatureStatistics;
import org.buksbaum.WeatherStation.model.WeatherData;
import org.buksbaum.WeatherStation.storage.IWeatherDataStore;
import org.buksbaum.WeatherStation.view.IMainForm;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by david on 4/3/2015.
 * This controller binds the form with the data model exposed through the data store.
 *
 * This controller is the root for the application and is therefore the Head Honcho, King Cheese,
 * Big Kahuna, and the entry point into anything meaningful in this application
 */
public class WeatherAppController implements IMainController
{
  //  the list of lambdas to be notified when weather data is updated. this is a lambda
  //  based implementation of the observer pattern!
  private final List<OnUpdateWeathterData> onNewWeathterDataList = new ArrayList<OnUpdateWeathterData>();
  //  a pressure value to be used in forecasts when only one value exists.
  private final float startingPressure = 29.92f;

  //  constant values from the NWS formula. I hate magic numbers so used
  //  constants instead of embedding the number. I would have preferred to
  //  have the real names of these values to name them.
  final static double wcConstant1 = 35.74;
  final static double wcConstant2 = 0.6215;
  final static double wcConstant3 = 35.75;
  final static double wcConstant4 = 0.16;
  final static double wcConstant5 = 0.4275;

  // our root window gets injected
  @Inject
  IMainForm mainForm;

  //  our model data source gets injected
  @Inject
  IWeatherDataStore weatherDataStore;

  //  our collect weather data contrller gets injected here
  @Inject
  ICollectWeatherDataController collectWeatherDataController;

  /**
   * Constructs the WeatherAppController
   */
  public WeatherAppController()
  { //  add these in the order they are to be executed when weather data changes
    onNewWeathterDataList.add(() -> updateHistoryList());
    onNewWeathterDataList.add(() -> updateCurrentConditions());
    onNewWeathterDataList.add(() -> updateForecast());
    onNewWeathterDataList.add(() -> updateStatistics());
    onNewWeathterDataList.add(() -> updateHeatIndex());
    onNewWeathterDataList.add(() -> updateWindChill());
    onNewWeathterDataList.add(() -> setStatusText("All displays updated."));
  }

  /**
   * When an object implementing interface <code>Runnable</code> is used
   * to create a thread, starting the thread causes the object's
   * <code>run</code> method to be called in that separately executing
   * thread.
   * <p>
   * The general contract of the method <code>run</code> is that it may
   * take any action whatsoever.
   *
   * @see Thread#run()
   */
  @Override
  public void run()
  {
    //  attach a handler to catch when the form is made visible.
    mainForm.setFormVisibilityEventHandler(isVisible ->
                                           {
                                             if (isVisible)
                                               setStatusText("Welcome Back.");
                                           });

    //  attach a handler to catch when the update button is pressed
    mainForm.setUpdateCommandEventHandler(() -> updateCommandHandler());

    mainForm.showTheForm();
    fireOnNewWeathterDataList();
  }

  /**
   * Helper method to notify all observers when the weather data changes. Keeping
   * it here means not having to duplicate the forEach logic in more than one place,
   * and eventually getting out of sync
   */
  private void fireOnNewWeathterDataList()
  {
    onNewWeathterDataList.forEach(onNewWeathterData -> onNewWeathterData.OnUpdateWeathterData());
  }

  /**
   * Sets the status text on the main form
   * @param text the text to be displayed
   */
  private void setStatusText(String text)
  {
    mainForm.setStatusText(text);
  }

  /**
   * Handles the event triggered when the user wants to perform an update.
   * This passed control over to the Collect Weather Data Controller to do its thing - whatever that might be since
   * we strictly observe separation of concerns here.
   */
  private void updateCommandHandler()
  { //  tell the user whats going on
    setStatusText("Showing Weather Data Dialog.");
    //  show the dialog and get the result
    if(collectWeatherDataController.showDialog())
    { //  dialog was pressed with OK
      //  tell the user something
      setStatusText("Getting New Weather Data.");
      //  get the new data
      WeatherData weatherData = collectWeatherDataController.getEnteredWeatherData();

      //  validate data here - this is where I will do a final validation before adding it to the data store
      //  the data should come from collectWeatherDataController mostly validated already

      //  store the data
      addNewWeatherDataToDataStore(weatherData);

      //  now update all visuals with current weather data
      fireOnNewWeathterDataList();
    }

    //  tell the user something - anything!
    setStatusText("Welcome Back.");
  }

  /**
   * Add new data to the underlying data store. This is the point in which the controller moves the model
   * into the repository
   * @param weatherData the weather data
   */
  private void addNewWeatherDataToDataStore(WeatherData weatherData)
  { //  tell the user something
    setStatusText("Storing New Weather Data.");
    //  now add it to the data store
    weatherDataStore.addWeatherData(weatherData);
  }

  //  event handlers

  /**
   * Update the history list on the main form. This is the controller doing something to the view
   */
  private void updateHistoryList()
  { //  tell the user
    setStatusText("Updating History Data.");
    //  get all weather data elements
    Collection<WeatherData> allWeatherData = weatherDataStore.getAllWeatherData();
    // This doesnt call toString() so I have do this manually
    //String[] weatherData = allWeatherData.toArray(new String[allWeatherData.size()]);
    //  there have to be vastly more efficient ways of doing this, but it works for this project
    //  I really really hate this brute force method and it is only needed for the history box
    WeatherData[] weatherDataArray = allWeatherData.toArray(new WeatherData[allWeatherData.size()]);
    String[] weatherDataStrings = new String[allWeatherData.size()];
    for (int i = 0; i < allWeatherData.size(); ++i)
    {
      weatherDataStrings[i] = weatherDataArray[i].toString();
    }

    //  set the history box
    mainForm.setHistoryData(weatherDataStrings);
  }

  /**
   * Updates the users view with the current conditions
   */
  private void updateCurrentConditions()
  {
    setStatusText("Updating Current Conditions.");
    WeatherData weatherData = weatherDataStore.getCurrentWeatherData();
    if(weatherData == null)
    { //  no current data
      mainForm.setCurrentConditions("No data for current conditions. Please enter data.");
    }
    else
    { //  set the current conditions
      mainForm.setCurrentConditions("Current conditions: " + weatherData.getTemperature() + "F degrees and " + weatherData.getHumidity() + "% humidity");
    }
  }
  /**
   * Updates the users view with the forecast
   */
  private void updateForecast()
  {
    setStatusText("Updating Forecast.");
    double[] lastTwoPressures = weatherDataStore.getLastTwoPressureValues();
    double lastPressure = 0.0f;
    double currentPressure = 0.0f;

    if (lastTwoPressures == null)
    { //  no values
      mainForm.setForecast("No data to create a forecast. Please enter data.");
      //  short circuit this method since we dont have enough data
      return;
    }

    if (lastTwoPressures.length == 1)
    { //  only one value
      lastPressure = startingPressure;
      currentPressure = lastTwoPressures[0];
    } else
    { //  we have enough data to do it for real
      lastPressure = lastTwoPressures[1];
      currentPressure = lastTwoPressures[0];
    }

    if (currentPressure > lastPressure)
    {
      mainForm.setForecast("Improving weather on the way!");
    }
    else if (currentPressure == lastPressure)
    {
      mainForm.setForecast("More of the same");
    } else if (currentPressure < lastPressure)
    {
      mainForm.setForecast("Watch out for cooler, rainy weather");
    }
  }
  /**
   * Updates the users view with the statistics
   */

  private void updateStatistics()
  {
    setStatusText("Updating Statistics.");

    TemperatureStatistics temperatureStatistics = weatherDataStore.getTemperatureStatistics();

    if(temperatureStatistics == null)
    { //  no current data
      mainForm.setStatistics ("Not enough data to calculate statistics. Please enter data.");
    }
    else
    {
      mainForm.setStatistics("Avg/Max/Min temperature = " +
                                     temperatureStatistics.getAverageTemperature() +
                                     "/" + temperatureStatistics.getMaximumTemperature() +
                                     "/" + temperatureStatistics.getMinimumTemperature());
    }
  }
  /**
   * Updates the users view with the heat index
   */
  private void updateHeatIndex()
  {
    setStatusText("Updating Heat Index.");
    WeatherData weatherData = weatherDataStore.getCurrentWeatherData();
    if (weatherData == null)
    { //  no current data
      mainForm.setHeatIndex("No data to generate a heat index. Please enter data.");
    }
    else
    { //  set the current heat index
      double  t = weatherData.getTemperature();
      double  rh = weatherData.getHumidity();
      double  heatIndex = (float)
              (
                      (16.923 + (0.185212 * t)) +
                              (5.37941 * rh) -
                              (0.100254 * t * rh) +
                              (0.00941695 * (t * t)) +
                              (0.00728898 * (rh * rh)) +
                              (0.000345372 * (t * t * rh)) -
                              (0.000814971 * (t * rh * rh)) +
                              (0.0000102102 * (t * t * rh * rh)) -
                              (0.000038646 * (t * t * t)) +
                              (0.0000291583 * (rh * rh * rh)) +
                              (0.00000142721 * (t * t * t * rh)) +
                              (0.000000197483 * (t * rh * rh * rh)) -
                              (0.0000000218429 * (t * t * t * rh * rh)) +
                              (0.000000000843296 * (t * t * rh * rh * rh)) -
                              (0.0000000000481975 * (t * t * t * rh * rh * rh)));
      mainForm.setHeatIndex("Heat index is " + heatIndex);
    }
  }
  /**
   * Updates the users view with the wind chill index
   */
  private void updateWindChill()
  {
    setStatusText("Updating Wind Chill Index.");

    WeatherData weatherData = weatherDataStore.getCurrentWeatherData();
    if (weatherData == null)
    { //  no current data
      mainForm.setWindChill("No data to generate a wind chill. Please enter data.");
    }
    else
    { //  set the current heat index
      double tempOutside = weatherData.getTemperature();
      double windSpeed = weatherData.getWindSpeed();

      // windchill logic from Module 3 WindChill.java class
      double airVelocityRaised = Math.pow((double) windSpeed, wcConstant4);
      double result = wcConstant1 +
              (wcConstant2 * (double) tempOutside) -
              (wcConstant3 * airVelocityRaised) +
              (wcConstant5 * ((double) tempOutside * airVelocityRaised));

      //  rounding the results to match NWS results
      double windChill = (float) Math.round(result);
      mainForm.setWindChill("Wind Chill is " + windChill);
    }
  }
}

