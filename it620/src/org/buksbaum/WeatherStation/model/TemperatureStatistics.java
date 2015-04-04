package org.buksbaum.WeatherStation.model;

/**
 * Created by david on 4/3/2015.
 * Model of the statictics for temperature.
 */
public class TemperatureStatistics
{ //  fields
  private double maximumTemperature;
  private double minimumTemperature;
  private double averageTemperature;

  /**
   * Constructs a TemperatureStatistics instance with a supplied Maximum, Minimum, and Average temperature
   * @param maximumTemperature the maximum temperature
   * @param minimumTemperature the minimum temperature
   * @param averageTemperature the average temperature
   */
  public TemperatureStatistics(double maximumTemperature, double minimumTemperature, double averageTemperature)
  {
    this.maximumTemperature = maximumTemperature;
    this.minimumTemperature = minimumTemperature;
    this.averageTemperature = averageTemperature;
  }

  /**
   * Gets the maximum temperature
   * @return the maximum temperature
   */
  public double getMaximumTemperature()
  {
    return maximumTemperature;
  }

  /**
   * Sets the maximum temperature
   * @param maximumTemperature the maximum temperature
   */
  public void setMaximumTemperature(double maximumTemperature)
  {
    this.maximumTemperature = maximumTemperature;
  }

  /**
   * Gets the minimum temperature
   * @return the minimum temperature
   */
  public double getMinimumTemperature()
  {
    return minimumTemperature;
  }

  /**
   * Sets the minimum temperature
   * @param minimumTemperature the minimum temperature
   */
  public void setMinimumTemperature(double minimumTemperature)
  {
    this.minimumTemperature = minimumTemperature;
  }

  /**
   * Gets the average temperature
   * @return the average temperature
   */
  public double getAverageTemperature()
  {
    return averageTemperature;
  }

  /**
   * Sets the average temperature
   * @param averageTemperature the average temperature
   */
  public void setAverageTemperature(double averageTemperature)
  {
    this.averageTemperature = averageTemperature;
  }
}
