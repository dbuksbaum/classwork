package org.buksbaum.WeatherStation.model;

/**
 * Created by david on 4/3/2015.
 */
public class TemperatureStatistics
{
  private double maximumTemperature;
  private double minimumTemperature;
  private double averageTemperature;

  public TemperatureStatistics(double maximumTemperature, double minimumTemperature, double averageTemperature)
  {
    this.maximumTemperature = maximumTemperature;
    this.minimumTemperature = minimumTemperature;
    this.averageTemperature = averageTemperature;
  }

  public double getMaximumTemperature()
  {
    return maximumTemperature;
  }

  public void setMaximumTemperature(double maximumTemperature)
  {
    this.maximumTemperature = maximumTemperature;
  }

  public double getMinimumTemperature()
  {
    return minimumTemperature;
  }

  public void setMinimumTemperature(double minimumTemperature)
  {
    this.minimumTemperature = minimumTemperature;
  }

  public double getAverageTemperature()
  {
    return averageTemperature;
  }

  public void setAverageTemperature(double averageTemperature)
  {
    this.averageTemperature = averageTemperature;
  }
}
