package org.buksbaum.WeatherStation.controllers;

import org.buksbaum.WeatherStation.model.WeatherData;
import org.buksbaum.WeatherStation.view.ICollectWeatherDataForm;

import javax.inject.Inject;
import javax.inject.Provider;

/**
 * Created by david on 4/3/2015.
 *
 * Instance of the ICollectWeatherDataController interface for the collection
 * of weather data elements
 */
public class CollectWeatherDataController implements ICollectWeatherDataController
{ //  the latest collected weather data object
  private WeatherData collectedWeatherData;

  //  inject a factory for creating our collect weather data dialog!
  @Inject
  Provider<ICollectWeatherDataForm> collectWeatherDataFormFactory;

  /**
   * Show the collect weather data dialog
   * @return true if the user supplied data, false if they did not
   */
  @Override
  public Boolean showDialog()
  { //  get our new dialog every time
    ICollectWeatherDataForm collectWeatherDataForm = collectWeatherDataFormFactory.get();
    //  show the dialog
    Boolean dialogClosedWithOk = collectWeatherDataForm.showDialog();
    //  did the user click OK
    if(dialogClosedWithOk)
    { //  they did! they did! so construct a weather data object with the resulting values!
      collectedWeatherData = new WeatherData(
              collectWeatherDataForm.getTemperature(),
              collectWeatherDataForm.getPressure(),
              collectWeatherDataForm.getHumidity(),
              collectWeatherDataForm.getWindSpeed());
    }

    //  test our called all about it
    return dialogClosedWithOk;
  }

  /**
   * Gets the weather data collected in the last show dialog action
   * @return the weather data
   */
  @Override
  public WeatherData getEnteredWeatherData()
  {
    return collectedWeatherData;
  }
}
