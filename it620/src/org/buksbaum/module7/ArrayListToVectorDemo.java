package org.buksbaum.module7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;

// created by D. J. Norris 9/2012

/**
 * Created by david on 3/21/2015.
 */
public class ArrayListToVectorDemo {

  public ArrayListToVectorDemo(){} // default ctor

  public static void main(String args[]){
    // Create an ArrayList with only Strings
    ArrayList<String> months = new ArrayList<String>();
    months.add("January");
    months.add("February");
    months.add("March");
    months.add("April");
    months.add("May");
    months.add("June");
    //  DTB: Added code for Question # 2, Programming Assignment 7.2
    months.add("July");
    months.add("August");
    months.add("September");
    months.add("October");
    months.add("November");
    months.add("December");

    // Use the toArray() method to convert from an ArrayList
    // to a String Array. An Object array is returned
    Object[] objMonths = months.toArray();
    // Need to convert from Object array to String array
    String[] strMonths = Arrays.copyOf(objMonths, objMonths.length, String[].class);
    System.out.println("String array");
    for(int i=0; i < strMonths.length; i++){
      System.out.println(strMonths[i]);
    }
    // Instantiate an adapter class object
    // Converts String array to Vector needed for DisplayVector class
    ArrayToVectorConverter vec = new ArrayToVectorConverter();
    Vector strVec = vec.Convert(strMonths);
    DisplayVector displayVec = new DisplayVector();
    displayVec.Display(strVec);
    System.out.println("done");
  }
}



