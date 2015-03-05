package org.buksbaum.module3;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by david on 2/16/2015.
 * Test class for Wind Chill class
 */
public class WindChillTest
{
  /**
   * Test that the Wind Chill class can be created correctly
   */
  @Test
  public void TestClassConstruction()
  { //  create wind chill
    WindChill windChill = new WindChill();
    //  make sure it is alive!!!!
    assertNotNull(windChill);
  }

  /**
   * Test the WindChill class formula logic will match the output in the book
   */
  @Test
  public void TestWindchillMathMatchesTextBook()
  { //  create wind chill
    WindChill windChill = new WindChill();
    //  make sure it is alive!!!!
    assertNotNull(windChill);

    //  NWS(5.3, 6) ==> -5.56707
    double wc1 = windChill.Calculate(5.3, 6);
    //  test equal to 5 digits rounded
    assertEquals(-5.56707, wc1, 0.00009);
  }

  /**
   * Test the WindChill class formula logic will match the output from the NWS for
   * the same values
   */
  @Test
  public void TestWindchillMathMatchesNWS()
  { //  create wind chill
    WindChill windChill = new WindChill();
    //  make sure it is alive!!!!
    assertNotNull(windChill);

    //  NWS(5.3, 6) ==> -5.56707
    long wc1 = windChill.CalculateNWS(5.3, 6);
    //  test equals
    assertEquals(-6, wc1);
  }
}
