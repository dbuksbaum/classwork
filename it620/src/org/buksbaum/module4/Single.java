package org.buksbaum.module4;

/**
 * Created by david on 3/2/2015.
 * Single class from Single.zip
 */
public class Single
{
  private static Single unique;
  private static int a = 1;

  /**
   * Constructor is private to prevent new instantiation outside the class
   */
  private Single() {}

  /**
   * Get the singleton instance
   * @return the one and only instance of Single
   */
  public static Single getInstance()
  {
    if (unique == null) {
      unique = new Single();
    }
    return unique;
  }

  /**
   * Return the integer value stored inside this singleton
   * @return the stored integer
   */
  public int getInt()
  {
    return a;
  }
}
