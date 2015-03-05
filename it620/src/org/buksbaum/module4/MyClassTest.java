package org.buksbaum.module4;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by david on 3/2/2015.
 * Test class for MyClass from MyClass.zip
 */
public class MyClassTest
{
  /**
   * Test method for {@link MyClass#multiply(int, int)}.
   */
  @Test
  public void testMultiply()
  {
    MyClass tester = new MyClass();
    //  NOTE: The assignment sed to fix the error in MyClass, but the
    //  error was in the following line.
    //  The test compared 50 against 10*4. Either the 50 needed to be changed to 40 (my choice since
    //  the expectation is set to match the math) or the 4 needed to be changed to a 5 to change the math
    //  to match the expected.
    assertEquals("Result",40, tester.multiply(10, 4));
    //fail("Not yet implemented");
  }

}
