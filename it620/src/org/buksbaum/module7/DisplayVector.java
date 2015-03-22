package org.buksbaum.module7;

import java.util.Enumeration;
import java.util.Vector;

//created by D. J. Norris 9/2012

/**
 * Created by david on 3/21/2015.
 */
public class DisplayVector {

  public DisplayVector(){} // default ctor
  public void Display(Vector vector){
    Enumeration e = vector.elements();
    System.out.println("Vector");
    while (e.hasMoreElements()) {
      System.out.println(e.nextElement());
    }
  }
}
