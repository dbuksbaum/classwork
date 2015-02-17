package org.buksbaum.module2;

/**
 * Created by david on 2/16/2015.
 * Copied from the OO Fundamentals Review and Introduction to Advanced Concepts document.
 * DTB: Modified to meet the Module 2 task:
 *  Modify the Pair program to show that changing the x object using the incrementMembers()
 *  method will automatically change the z object as z is a shallow clone of x.
 */
public class Pair implements Cloneable
{
  private int a, b;

  /** Class constructor method
   * @param initA Initial value for the first field
   * @param initB Initial value for the second field
   */
  public Pair( int initA, int initB )
  {
    a = initA;
    b = initB;
  }

  public void incrementMembers()
  {
    a++;
    b++;
  }

  /** Convert object to String representation
   * @return The value of the array as a String
   */
  public String toString()
  {
    return "( " + a + ", " + b + " )";
  }

  /** The test method for the class
   * @param args Not used
   * @exception CloneNotSupportedException
   *            If clone not supported by
   *            inherited clone method
   */
  public static void main( String[] args )
          throws CloneNotSupportedException
  {
    System.out.println( "Cloning example" );
    Pair x = new Pair( 5, 6 );
    System.out.println( x );

    //Deep clone example
    Pair y = (Pair) x.clone();
    System.out.println( y );

    // now let's change x, but y should remain untouched
    x.incrementMembers();

    //Display changed x
    System.out.println( x );

    //Check to see if y has been changed
    System.out.println( y );

    //Shallow clone example
    Pair z = x;
    System.out.println(z);

    //  prove we are equal before changing
    System.out.println("X.a == Z.a is " + (x.a == z.a));
    System.out.println("X.b == Z.b is " + (x.b == z.b));

    //  now store current values for more proof
    int oldXA = x.a;
    int oldXB = x.b;
    int oldZA = z.a;
    int oldZB = z.b;

    //  now change x
    System.out.println("Incrementing X.");
    x.incrementMembers();

    //  prove we changed
    System.out.println("X.a > oldXA is " + (x.a > oldXA));
    System.out.println("X.b > oldXB is " + (x.b > oldXB));
    System.out.println("Z.a > oldZA is " + (x.a > oldZA));
    System.out.println("Z.b > oldZB is " + (x.b > oldZB));

    //  prove we are still equal after changing
    System.out.println("X.a == Z.a is " + (x.a == z.a));
    System.out.println("X.b == Z.b is " + (x.b == z.b));

    System.out.println("X values should equal Z values before and after change, but the values should have been increased from their original values.");
  }
}
