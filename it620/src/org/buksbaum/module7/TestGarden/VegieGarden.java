package org.buksbaum.module7.TestGarden;

/**
 * Created by david on 3/22/2015.
 */
public class VegieGarden extends Garden {
  public Plant getShade() {
    return new Plant("Broccoli");
  }
  public Plant getCenter() {
    return new Plant("Corn");
  }
  public Plant getBorder() {
    return new Plant("Peas");
  }
}
