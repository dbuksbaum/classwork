package org.buksbaum.module4.strategy;

/**
 * Created by david on 3/2/2015.
 */
public class FlyRocketPowered implements FlyBehavior {
  public void fly() {
    System.out.println("I'm flying with a rocket");
  }
}
