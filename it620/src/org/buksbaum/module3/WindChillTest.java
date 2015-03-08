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
    double airVelocityRaised = Math.pow((double) 6, WindChill.constant4);
    double result = WindChill.constant1 +
            (WindChill.constant2 * 5.3) -
            (WindChill.constant3 * airVelocityRaised) +
            (WindChill.constant5 * (5.3 * airVelocityRaised));

    //  TODO: verify that 6 is the right precision for all contexts. Might need to change this math
    //return new BigDecimal(result, new MathContext(6)).doubleValue();
    double wc1 = result;
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
    double airVelocityRaised = Math.pow((double) 6, WindChill.constant4);
    double result = WindChill.constant1 +
            (WindChill.constant2 * 5.3) -
            (WindChill.constant3 * airVelocityRaised) +
            (WindChill.constant5 * (5.3 * airVelocityRaised));

    //  TODO: verify that 6 is the right precision for all contexts. Might need to change this math
    //return new BigDecimal(result, new MathContext(6)).doubleValue();
    long wc1 = Math.round(result);
    //  test equals
    assertEquals(-6, wc1);
  }
}
