package org.buksbaum.module4.strategy;

/**
 * Created by david on 3/2/2015.
 */
public class MuteQuack implements QuackBehavior {
  public void quack() {
    System.out.println("<< Silence >>");
  }
}
