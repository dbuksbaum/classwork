package org.buksbaum.module6.starbuzz;

/**
 * Created by david on 3/16/2015.
 */
public abstract class Beverage {
  String description = "Unknown Beverage";

  public String getDescription() {
    return description;
  }

  public abstract double cost();
}
