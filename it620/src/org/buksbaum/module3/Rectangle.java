package org.buksbaum.module3;

import java.util.Scanner; // contains the Scanner class

/**
 * Created by david on 2/24/2015.
 * Rectangle calculation class from the Data IO and Object Serialization Examples_Mod3 document
 */
public class Rectangle
{
  static Scanner console = new Scanner(System.in); //creates a scanner object

  //the static modifier allows it to be directly invoked
  public static void main(String[] args)
  {
    double width, length;
    String line;

    System.out.println("Enter rectangles width then length as real numbers followed by a string");
    width = console.nextDouble();
    length = console.nextDouble();
    line = console.nextLine();
    System.out.println("The rectangle area = " + length * width);
    /* you must surround the calculation contained within the next println or it will be incorrect. */
    System.out.println("The rectangle perimeter = " + (2 * length + 2 * width));
    System.out.println(line);
  }
}
