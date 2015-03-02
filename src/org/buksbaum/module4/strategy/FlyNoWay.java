package org.buksbaum.module4.strategy;

/**
 * Created by david on 3/2/2015.
 */
public class FlyNoWay implements FlyBehavior {
  public void fly() {
    System.out.println("I can't fly");
  }
}
