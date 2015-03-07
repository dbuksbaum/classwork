package org.buksbaum.module5.WeatherObservable;

import org.buksbaum.module3.WindChill;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by david on 3/7/2015.
 */
public class WindChillDisplay implements Observer, DisplayElement
{
  float windChill = 0.0f;

  public WindChillDisplay(Observable observable)
  {
    observable.addObserver(this);
  }

  public void update(Observable observable, Object arg)
  {
    if (observable instanceof WeatherData)
    {
      WeatherData weatherData = (WeatherData)observable;
      float tempOutside = weatherData.getTemperature();
      float windSpeed = weatherData.getWindSpeed();
      WindChill wc = new WindChill();

      windChill = (float)wc.CalculateNWS(tempOutside, windSpeed);

      display();
    }
  }


  public void display() {
    System.out.println("Wind Chill is " + windChill);
  }
}
