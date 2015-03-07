package org.buksbaum.module5.ThreadTester;

/**
 * Created by david on 3/7/2015.
 */
public class DivisionTest{
  int x = 11;
  int y = 5;
  double z;

  public void run() {
    z = (double)x /y;
    System.out.println("Answer = " + z);
    System.out.println("Pow of x to the y power = " + Math.pow(x,y));
  }
}
