package org.buksbaum.module3;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by david on 2/16/2015.
 */
public class WindChillTest
{
  @Test
  public void TestClassConstruction()
  { //  create wind chill
    WindChill windChill = new WindChill();
    //  make sure it is alive!!!!
    assertNotNull(windChill);
  }

  @Test
  public void TestWindchillMathMatchesTextBook()
  { //  create wind chill
    WindChill windChill = new WindChill();
    //  make sure it is alive!!!!
    assertNotNull(windChill);

    //  NWS(5.3, 6) ==> -5.56707
    double wc1 = windChill.Calculate(5.3, 6);
    assertEquals(-5.56707, wc1, 0.000009);
  }
  @Test
  public void TestWindchillMathMatchesNWS()
  { //  create wind chill
    WindChill windChill = new WindChill();
    //  make sure it is alive!!!!
    assertNotNull(windChill);

    //  NWS(5.3, 6) ==> -5.56707
    long wc1 = windChill.CalculateNWS(5.3, 6);
    assertEquals(-6, wc1);
  }
}
