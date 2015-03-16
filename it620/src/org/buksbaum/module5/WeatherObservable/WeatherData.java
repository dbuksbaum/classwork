package org.buksbaum.module5.WeatherObservable;

import java.util.Observable;

/**
 * Created by david on 3/7/2015.
 * WeatherData class to store weather data
 */
public class WeatherData extends Observable
{
  private float temperature;
  private float humidity;
  private float pressure;
  private float windSpeed;

  public WeatherData() { }

  public void measurementsChanged() {
    setChanged();
    notifyObservers();
  }

  /**
   * Enhanced to support windspeed variable
   * @param temperature
   * @param humidity
   * @param pressure
   * @param windSpeed
   */
  public void setMeasurements(float temperature, float humidity, float pressure, float windSpeed)
  {
    this.temperature = temperature;
    this.humidity = humidity;
    this.pressure = pressure;
    this.windSpeed = windSpeed;

    measurementsChanged();
  }

  public float getTemperature() {
    return temperature;
  }

  public float getHumidity() {
    return humidity;
  }

  public float getPressure() {
    return pressure;
  }

  public float getWindSpeed() { return windSpeed; }
}
