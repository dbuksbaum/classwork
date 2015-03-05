package org.buksbaum.module4.strategy;

/**
 * Created by david on 3/2/2015.
 */
public class RedHeadDuck extends Duck {

  public RedHeadDuck() {
    flyBehavior = new FlyWithWings();
    quackBehavior = new Quack();
  }

  public void display() {
    System.out.println("I'm a real Red Headed duck");
  }
}
