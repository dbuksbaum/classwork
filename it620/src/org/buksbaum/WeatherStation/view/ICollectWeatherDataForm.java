package org.buksbaum.WeatherStation.view;

/**
 * Created by david on 4/3/2015.
 */
public interface ICollectWeatherDataForm
{
  double getTemperature();
  double getPressure();
  int getHumidity();
  int getWindSpeed();

  public Boolean showDialog();
}
