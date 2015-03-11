package org.buksbaum.module5.WeatherObservable;

/**
 * Created by david on 3/7/2015.
 * Test program to display the Wind Chill. Copied from
 * the WeatherStationHeatIndex.java class
 */
public class WeatherStationWindChill {

  public static void main(String[] args) {
    WeatherData weatherData = new WeatherData();
    CurrentConditionsDisplay currentConditions = new CurrentConditionsDisplay(weatherData);
    StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherData);
    ForecastDisplay forecastDisplay = new ForecastDisplay(weatherData);
    HeatIndexDisplay heatIndexDisplay = new HeatIndexDisplay(weatherData);
    //  register the Wind Chill Display
    WindChillDisplay windChillDisplay = new WindChillDisplay(weatherData);

    //  values copied from the assignment
    weatherData.setMeasurements(10, 40, 30.5f, 20);
    weatherData.setMeasurements(0, 30, 30.7f, 10);
    weatherData.setMeasurements(-10, 20, 29.8f, 15);
  }
}
