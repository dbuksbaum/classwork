package org.buksbaum.module4;

/**
 * Created by david on 3/2/2015.
 * Test program to test single from Single.zip
 */
public class TestSingle
{
  /**
   * Main method to drive the test
   * @param args command line args - unused
   */
  public static void main(String[] args)
  {
    Single test = Single.getInstance();
    System.out.println(test.getInt());
    Single test1 = Single.getInstance();
  }
}
