package org.buksbaum.module4;

/**
 * Created by david on 3/2/2015.
 */
public class TestSingle
{
  public static void main(String[] args)
  {
    Single test = Single.getInstance();
    System.out.println(test.getInt());
    Single test1 = Single.getInstance();
  }
}
