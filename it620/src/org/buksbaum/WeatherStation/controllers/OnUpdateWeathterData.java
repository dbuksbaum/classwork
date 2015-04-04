package org.buksbaum.WeatherStation.controllers;

import org.buksbaum.WeatherStation.model.WeatherData;

/**
 * Created by david on 4/3/2015.
 *
 * Notification that our collection of weather data elements was updated . In this application it is currently
 * only triggered through the result of the Collect Weather Data dialog, but this separation allows us to
 * trigger this from any where, thus allowing for future versions to trigger an update from something other
 * than the dialog or of different types of updates (delete?). It may require parameters to identify the type
 * of update
 *
 * This is a functional interface to declare a Lambda signature used by Java 8 to avoid anonymous inner classes or
 * extraneous new class types just to capture an event.
 */
@FunctionalInterface
public interface OnUpdateWeathterData
{
  /**
   * Notification that an update to the data happened.
   */
  public abstract void OnUpdateWeathterData();
}
