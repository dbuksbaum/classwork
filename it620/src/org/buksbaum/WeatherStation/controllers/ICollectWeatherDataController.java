package org.buksbaum.WeatherStation.controllers;

import org.buksbaum.WeatherStation.model.WeatherData;

/**
 * Created by david on 4/3/2015.
 *
 * Interface defining the required capabilities of the controller used to for the collection
 * of Weather Data.
 *
 */
public interface ICollectWeatherDataController
{
  /**
   * Show the collect weather data dialog
   * @return true if the user supplied data, false if they did not
   */
  public Boolean showDialog();

  /**
   * Gets the weather data collected in the last show dialog action
   * @return the weather data
   */
  public WeatherData getEnteredWeatherData();
}
