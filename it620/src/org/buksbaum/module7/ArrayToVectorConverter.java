package org.buksbaum.module7;

import java.util.Arrays;
import java.util.List;
import java.util.Vector;

// created by D. J. Norris 9/2012

/**
 * Created by david on 3/21/2015.
 */
// Convert an Array to a Vector
public class ArrayToVectorConverter {
  public Vector Convert(String[] str) {
    List strList = Arrays.asList(str);
    Vector strVector = new Vector(strList);
    return strVector;
  }
}

