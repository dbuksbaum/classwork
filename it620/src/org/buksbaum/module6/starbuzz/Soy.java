package org.buksbaum.module6.starbuzz;

/**
 * Created by david on 3/16/2015.
 */
public class Soy extends CondimentDecorator {
  Beverage beverage;

  public Soy(Beverage beverage) {
    this.beverage = beverage;
  }

  public String getDescription() {
    return beverage.getDescription() + ", Soy";
  }

  public double cost() {
    return .15 + beverage.cost();
  }
}
