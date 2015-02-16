package org.buksbaum.module2;

import java.lang.reflect.*;


/**
 * Created by david on 2/16/2015.
 * Copied from the OO Fundamentals Review and Introduction to Advanced Concepts document.
 * Create and execute the ListStringMethod program as detailed in the presentation in the Module Resources folder.
 * DTB: Create and execute the ListStringMethod program as detailed in the presentation in the Module Resources folder.
 */
public class ListStringMethods
{
  /** Test method for the class
   * @param args not used
   * @exception ClassNotFoundException
   *            Thrown if the class being
   *            investigated isn't found
   */
  public static void main( String[] args )
          throws ClassNotFoundException
  {
    Method[] ma = String.class.getMethods();
    for( int i=0; i < ma.length; i++ )
    {
      System.out.println( ma[i] );
    }
  }
}
