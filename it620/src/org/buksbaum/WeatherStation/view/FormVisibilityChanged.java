package org.buksbaum.WeatherStation.view;

/**
 * Created by david on 4/3/2015.
 *
 * Notification that the form visibility has changed.
 *
 * This is a functional interface to declare a Lambda signature used by Java 8 to avoid anonymous inner classes or
 * extraneous new class types just to capture an event.
 */
@FunctionalInterface
public interface FormVisibilityChanged
{
  /**
   * The form visibility has changed. It is either visible or not.
   * @param isVisible true if the form is visible, false if it is not visible
   */
  public void formVisibilityChanged(Boolean isVisible);
}

