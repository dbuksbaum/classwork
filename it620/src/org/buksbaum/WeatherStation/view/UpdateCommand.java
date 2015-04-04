package org.buksbaum.WeatherStation.view;

/**
 * Created by david on 4/3/2015.
 *
 * Notification that the update command was triggered. In this application it is only triggered by
 * the Update Button, but this separation allows us to trigger this from any where, thus allowing
 * for future versions to trigger an update from something other than the button - perhaps a key stroke.
 *
 * This is a functional interface to declare a Lambda signature used by Java 8 to avoid anonymous inner classes or
 * extraneous new class types just to capture an event.
 */
@FunctionalInterface
public interface UpdateCommand
{
  /**
   * Notification that the update command was triggered.
   */
  public void update();
}
