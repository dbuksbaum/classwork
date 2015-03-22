package org.buksbaum.module7.TestGarden;

/**
 * Created by david on 3/22/2015.
 */
public class AnnualGarden extends Garden {
  public Plant getShade() {
    return new Plant("Begonias");
  }

  public Plant getCenter() {
    return new Plant("Posies");
  }

  public Plant getBorder() {
    return new Plant("Alyssum");
  }

}
