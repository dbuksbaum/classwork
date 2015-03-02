package org.buksbaum.module4.strategy;

/**
 * Created by david on 3/2/2015.
 */
public class RocketDuckSimulator
{
  public static void main(String[] args)
  {
    Duck rocketDuck = new RocketDuck();
    rocketDuck.display();
    rocketDuck.performQuack();
    rocketDuck.performFly();
  }
}
