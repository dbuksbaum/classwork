package org.buksbaum.module5.WeatherRev;

import java.util.ArrayList;

/**
 * Created by david on 3/7/2015.
 */
public class WeatherData implements Subject {
  private ArrayList observers;
  private float temperature;
  private float humidity;
  private float pressure;
  RawData rw = new RawData();

  public WeatherData() {
    observers = new ArrayList();
  }

  public void registerObserver(Observer o) {
    observers.add(o);
  }

  public void removeObserver(Observer o) {
    int i = observers.indexOf(o);
    if (i >= 0) {
      observers.remove(i);
    }
  }

  public void notifyObservers() {
    for (int i = 0; i < observers.size(); i++) {
      Observer observer = (Observer)observers.get(i);
      observer.update(rw);
    }
  }

  public void measurementsChanged() {
    notifyObservers();
  }

  public void setMeasurements(double temperature, double humidity, double pressure, double wind) {
    rw.setValues(temperature, humidity, pressure, wind);
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
}
