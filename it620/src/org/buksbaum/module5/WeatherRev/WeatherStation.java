package org.buksbaum.module5.WeatherRev;

/**
 * Created by david on 3/7/2015.
 */
public class WeatherStation
{
  public static void main(String[] args)
  {
    WeatherData weatherData = new WeatherData();

    CurrentConditionsDisplay currentDisplay =
            new CurrentConditionsDisplay(weatherData);
    StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherData);
    ForecastDisplay forecastDisplay = new ForecastDisplay(weatherData);

    weatherData.setMeasurements(80, 65, 30.4f, 10);
    weatherData.setMeasurements(82, 70, 29.2f, 15);
    weatherData.setMeasurements(78, 90, 29.2f, 20);
  }
}

