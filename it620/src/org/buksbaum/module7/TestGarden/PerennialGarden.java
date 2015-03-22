package org.buksbaum.module7.TestGarden;

/**
 * Created by david on 3/22/2015.
 */
public class PerennialGarden extends Garden {
  public Plant getShade() {
    return new Plant("Foxglove");
  }

  public Plant getCenter() {
    return new Plant("Agave");
  }

  public Plant getBorder() {
    return new Plant("Wild Ginger");
  }
}
