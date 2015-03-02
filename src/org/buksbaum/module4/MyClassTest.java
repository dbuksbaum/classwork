package org.buksbaum.module4;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by david on 3/2/2015.
 */
public class MyClassTest
{
  /**
   * Test method for {@link junit.test.MyClass#multiply(int, int)}.
   */
  @Test
  public void testMultiply()
  {
    MyClass tester = new MyClass();
    assertEquals("Result",40, tester.multiply(10, 4));
    //fail("Not yet implemented");
  }

}
