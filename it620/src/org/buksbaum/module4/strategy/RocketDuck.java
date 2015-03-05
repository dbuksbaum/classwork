package org.buksbaum.module4.strategy;

/**
 * Created by david on 3/2/2015.
 * The super powered rocket duck known as Duck Dodgers in the 24 1/2 Century!
 */
public class RocketDuck extends Duck
{
  /**
   * Constructor to create a rocket duck and set the behaviours
   */
  public RocketDuck()
  {
    quackBehavior = new WhooshQuack();
    flyBehavior = new FlyRocketPowered();
  }

  /**
   * display some critical information about this rocket duck!
   */
  public void display()
  {
    System.out.println("I am Duck Dodgers if the 24 1/2 Century - A Rocket Duck!");
  }
}
