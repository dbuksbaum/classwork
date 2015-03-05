package org.buksbaum.module4.strategy;

/**
 * Created by david on 3/2/2015.
 */
public class ModelDuck extends Duck {
  public ModelDuck() {
    flyBehavior = new FlyNoWay();
    quackBehavior = new Quack();
  }

  public void display() {
    System.out.println("I'm a model duck");
  }
}
