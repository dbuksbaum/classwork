package org.buksbaum.module3;

import java.math.BigDecimal;
import java.math.MathContext;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

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
  //  constant values from the NWS formula. I hate magic numbers so used
  //  constants instead of embedding the number. I would have preferred to
  //  have the real names of these values to name them.
  final static double constant1 = 35.74;
  final static double constant2 = 0.6215;
  final static double constant3 = 35.75;
  final static double constant4 = 0.16;
  final static double constant5 = 0.4275;

  /**
   * Calculate the wind chill using the formula from the National
   * Weather Service
   * @param tempOutside The fahrenheit temperature
   * @param airVelocity The speed of the wind
   * @return The wind chill
   */
  public double Calculate(double tempOutside, double airVelocity)
  {
    double airVelocityRaised = Math.pow(airVelocity,constant4);
    double result = constant1 +
            (constant2 * tempOutside) -
            (constant3 * airVelocityRaised) +
            (constant5 * (tempOutside * airVelocityRaised));

    //  TODO: verify that 6 is the right precision for all contexts. Might need to change this math
    //return new BigDecimal(result, new MathContext(6)).doubleValue();
    return result;
  }


  /**
   * Caculate the wind chill and round to a whole number to match the tables
   * published by the Nation Weather Service
   * @param tempOutside The fahrenheit temperature
   * @param airVelocity The speed of the wind
   * @return The wind chill
   */
  public long CalculateNWS(double tempOutside, double airVelocity)
  {
    return Math.round(Calculate(tempOutside, airVelocity));
  }

  /**
   * The main method to run the wind chill test by getting the temperature and wind speed
   * and printing the wind chill
   * @param args Command line arguments - none expected
   */
  public static void main(String[] args)
  {
    //  create a windchill object
    WindChill windChill = new WindChill();

    //  create a scanner object
    Scanner input = new Scanner(System.in);

    //  create a number formatter to match the 5 digits displayed in the book
    NumberFormat formatter = new DecimalFormat("#0.00000");

    //  get the temperature
    System.out.print("Enter the temperature in Fahrenheit between -58F and 41F: ");
    double temp = 0.0;
    try
    {
      temp = input.nextDouble();
      if((temp < -58.0) || (temp > 41))
      {
        System.out.println("Invalid temperature. Please enter the temperature in Fahrenheit between -58F and 41F.");
        System.exit(-1);
      }
    }
    catch(InputMismatchException exception)
    {
      System.out.println("Invalid temperature format. Please enter the temperature in Fahrenheit between -58F and 41F.");
      System.exit(-2);
    }

    //  get the temperature
    System.out.print("Enter the wind speed (>= 2) in miles per hour: ");
    double speed = 0.0;
    try
    {
      speed = input.nextDouble();
      if(speed < 2)
      {
        System.out.println("Invalid wind speed. Please enter the wind speed (>= 2) in miles per hour.");
        System.exit(-3);
      }
    }
    catch(InputMismatchException exception)
    {
      System.out.println("Invalid wind chill format. Please enter the wind speed (>= 2) in miles per hour.");
      System.exit(-4);
    }

    //  calculate the wind chill
    double chill = windChill.Calculate(temp, speed);

    //  display the result
    System.out.println("The wind chill index is " + formatter.format(chill));
  }

}
