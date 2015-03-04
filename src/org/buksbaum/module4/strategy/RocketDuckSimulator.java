package org.buksbaum.module4.strategy;

/**
 * Created by david on 3/2/2015.
 * A high powered rocket duck simulator. Stand back or get burned by the thrusters!
 */
public class RocketDuckSimulator
{
  /**
   * Main entry point for testing the rocket duck
   * @param args command line arguments - not used
   */
  public static void main(String[] args)
  {
    //  create my duck
    Duck rocketDuck = new RocketDuck();
    //  we are just ducky, so display it
    rocketDuck.display();
    //  quack. I say quack!
    rocketDuck.performQuack();
    //  now fly. be free!
    rocketDuck.performFly();
  }
}
