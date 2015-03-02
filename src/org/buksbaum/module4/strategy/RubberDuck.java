package org.buksbaum.module4.strategy;

/**
 * Created by david on 3/2/2015.
 */
public class RubberDuck extends Duck {

  public RubberDuck() {
    flyBehavior = new FlyNoWay();
    quackBehavior = new Squeak();
  }

  public void display() {
    System.out.println("I'm a rubber duckie");
  }
}
