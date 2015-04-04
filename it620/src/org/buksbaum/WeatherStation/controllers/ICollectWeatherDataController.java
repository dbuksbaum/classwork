package org.buksbaum.WeatherStation.controllers;

import org.buksbaum.WeatherStation.model.WeatherData;

/**
 * Created by david on 4/3/2015.
 */
public interface ICollectWeatherDataController
{
  public Boolean showDialog();
  public WeatherData getEnteredWeatherData();
}
