package org.buksbaum.module5.WeatherRev;

/**
 * Created by david on 3/7/2015.
 */
public class CurrentConditionsDisplay implements Observer, DisplayElement {
  private double temperature;
  private double humidity;
  private Subject weatherData;

  public CurrentConditionsDisplay(Subject weatherData) {
    this.weatherData = weatherData;
    weatherData.registerObserver(this);
  }

  public void update(RawData rw) {
    this.temperature = rw.getTemperature();
    this.humidity = rw.getHumidity();
    display();
  }

  public void display() {
    System.out.println("Current conditions: " + temperature
                               + "F degrees and " + humidity + "% humidity");
  }
}
