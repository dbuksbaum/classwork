package org.buksbaum.module6.starbuzz;

/**
 * Created by david on 3/16/2015.
 */
public class Caramel extends CondimentDecorator {
  Beverage beverage;

  public Caramel(Beverage beverage) {
    this.beverage = beverage;
  }

  public String getDescription() {
    return beverage.getDescription() + ", Caramel";
  }

  public double cost() {
    return .20 + beverage.cost();
  }
}
