package org.buksbaum.module4;

/**
 * Created by david on 3/2/2015.
 */
public class Single
{
  private static Single unique;
  private static int a = 1;
  private Single() {}
  public static Single getInstance()
  {
    if (unique == null) {
      unique = new Single();
    }
    return unique;
  }
  public int getInt()
  {
    return a;
  }
}
