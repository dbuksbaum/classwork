package org.buksbaum.module5.WeatherRev;

/**
 * Created by david on 3/7/2015.
 */
public class StatisticsDisplay implements Observer, DisplayElement {
  private double maxTemp = 0.0f;
  private double minTemp = 200;
  private double tempSum= 0.0f;
  private int numReadings;
  private WeatherData weatherData;

  public StatisticsDisplay(WeatherData weatherData) {
    this.weatherData = weatherData;
    weatherData.registerObserver(this);
  }

  public void update(RawData rw) {
    double temp = rw.getTemperature();
    tempSum += temp;
    numReadings++;

    if (temp > maxTemp) {
      maxTemp = temp;
    }

    if (temp < minTemp) {
      minTemp = temp;
    }

    display();
  }

  public void display() {
    System.out.println("Avg/Max/Min temperature = " + (tempSum / numReadings)
                               + "/" + maxTemp + "/" + minTemp);
  }
}
