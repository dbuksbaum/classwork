package org.buksbaum.module5.WeatherObservable;

/**
 * Created by david on 3/7/2015.
 */
public class WeatherStation {

  public static void main(String[] args) {
    WeatherData weatherData = new WeatherData();
    CurrentConditionsDisplay currentConditions = new CurrentConditionsDisplay(weatherData);
    StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherData);
    ForecastDisplay forecastDisplay = new ForecastDisplay(weatherData);

    //  added windspeed parameter
    weatherData.setMeasurements(80, 65, 30.4f, 2);
    weatherData.setMeasurements(82, 70, 29.2f, 2);
    weatherData.setMeasurements(78, 90, 29.2f, 2);
  }
}


