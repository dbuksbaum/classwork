package org.buksbaum.module4.strategy;

/**
 * Created by david on 3/2/2015.
 */
public class DecoyDuck extends Duck {
  public DecoyDuck() {
    setFlyBehavior(new FlyNoWay());
    setQuackBehavior(new MuteQuack());
  }
  public void display() {
    System.out.println("I'm a duck Decoy");
  }
}
