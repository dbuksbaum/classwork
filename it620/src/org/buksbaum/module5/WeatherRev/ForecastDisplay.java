package org.buksbaum.module5.WeatherRev;

/**
 * Created by david on 3/7/2015.
 */
public class ForecastDisplay implements Observer, DisplayElement {
  private double currentPressure = 29.92f;
  private double lastPressure;
  private WeatherData weatherData;

  public ForecastDisplay(WeatherData weatherData) {
    this.weatherData = weatherData;
    weatherData.registerObserver(this);
  }

  public void update(RawData rw) {
    lastPressure = currentPressure;
    currentPressure = rw.getPressure();

    display();
  }

  public void display() {
    System.out.print("Forecast: ");
    if (currentPressure > lastPressure) {
      System.out.println("Improving weather on the way!");
    } else if (currentPressure == lastPressure) {
      System.out.println("More of the same");
    } else if (currentPressure < lastPressure) {
      System.out.println("Watch out for cooler, rainy weather");
    }
  }
}
