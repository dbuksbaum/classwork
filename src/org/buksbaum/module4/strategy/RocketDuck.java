package org.buksbaum.module4.strategy;

/**
 * Created by david on 3/2/2015.
 */
public class RocketDuck extends Duck
{
  public RocketDuck()
  {
    quackBehavior = new WhooshQuack();
    flyBehavior = new FlyRocketPowered();
  }

  public void display()
  {
    System.out.println("I am Duck Dodgers if the 24 1/2 Century - A Rocket Duck!");
  }
}
