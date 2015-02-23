package org.buksbaum.module3;

import java.math.BigDecimal;
import java.math.MathContext;

/**
 * Created by david on 2/16/2015.
 *
 * Class to calculate the wind chill using the forumla
 * presented in Exercise 2.17 (page 73) from the National
 * Weather Service (NWS)
 *
 * Forumla Temp[wind chill] =
 *  35.74 + (0.6215 * Temp[outside F degrees]) -
 *  (35.75 * (air velocity ^ 0.16)) +
 *  (0.4275 * (Temp[outside F degrees] * (air velocity ^ 0.16))
 *
 * Math will be verified using: NWS Windchill Chart
 * see: http://www.nws.noaa.gov/om/winter/windchill.shtml
 */
public class WindChill
{
  double constant1 = 35.74;
  double constant2 = 0.6215;
  double constant3 = 35.75;
  double constant4 = 0.16;
  double constant5 = 0.4275;

  public double Calculate(double tempOutside, double airVelocity)
  {
    double airVelocityRaised = Math.pow(airVelocity,constant4);
    double result = constant1 +
            (constant2 * tempOutside) -
            (constant3 * airVelocityRaised) +
            (constant5 * (tempOutside * airVelocityRaised));

    //  TODO: verify that 6 is the right precision for all contexts. Might need to change this math
    return new BigDecimal(result, new MathContext(6)).doubleValue();
  }
}
