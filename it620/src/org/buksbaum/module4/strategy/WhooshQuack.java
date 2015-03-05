package org.buksbaum.module4.strategy;

/**
 * Created by david on 3/2/2015.
 * A new form of quack designed for Duck Dodgers in the 24 1/2 Century
 */
public class WhooshQuack implements QuackBehavior
{
  /**
   * Driving me quackers by saying Whoosh instead of quack!
   */
  public void quack() {
    System.out.println("Whoosh");
  }
}
