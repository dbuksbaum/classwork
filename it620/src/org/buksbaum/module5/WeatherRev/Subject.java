package org.buksbaum.module5.WeatherRev;

/**
 * Created by david on 3/7/2015.
 */
public interface Subject {
  public void registerObserver(Observer o);
  public void removeObserver(Observer o);
  public void notifyObservers();
}
