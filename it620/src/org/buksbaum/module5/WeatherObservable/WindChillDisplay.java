package org.buksbaum.module5.WeatherObservable;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by david on 3/7/2015.
 * DisplayElement to display the WindChill calculated using the NWS
 * formula used in Module 3.
 */
public class WindChillDisplay implements Observer, DisplayElement
{
  //  constant values from the NWS formula. I hate magic numbers so used
  //  constants instead of embedding the number. I would have preferred to
  //  have the real names of these values to name them.
  final static double constant1 = 35.74;
  final static double constant2 = 0.6215;
  final static double constant3 = 35.75;
  final static double constant4 = 0.16;
  final static double constant5 = 0.4275;

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

      // windchill logic from Module 3 WindChill.java class
      double airVelocityRaised = Math.pow((double) windSpeed, constant4);
      double result = constant1 +
              (constant2 * (double) tempOutside) -
              (constant3 * airVelocityRaised) +
              (constant5 * ((double) tempOutside * airVelocityRaised));

      //  rounding the results to match NWS results
      windChill = (float) Math.round(result);

      display();
    }
  }


  public void display() {
    System.out.println("Wind Chill is " + windChill);
  }
}
