package org.buksbaum.WeatherStation.view;

/**
 * Created by david on 4/3/2015.
 *
 * Interface defining the required capabilities of a form that is used to show a Collect Weather Data dialog
 * and return the results.
 */
public interface ICollectWeatherDataForm
{
  /**
   * Gets the temperature entered.
   * This value is only useful if the result of showDialog() is true.
   * @return the temperature
   */
  double getTemperature();

  /**
   * Get the pressure entered.
   * This value is only useful if the result of showDialog() is true.
   * @return the pressure
   */
  double getPressure();

  /**
   * Gets the humidity entered.
   * This value is only useful if the result of showDialog() is true.
   * @return the humidity
   */
  int getHumidity();

  /**
   * Gets the wind speed entered.
   * This value is only useful if the result of showDialog() is true.
   * @return the wind speed
   */
  int getWindSpeed();

  /**
   * Shows the collect weather data dialog and returns if the use pressed OK or CANCEL.
   * The data value getters are only meaningful if the result is OK.
   * @return true if the user pressed OK, false if the user pressed CANCEL.
   */
  public Boolean showDialog();
}
