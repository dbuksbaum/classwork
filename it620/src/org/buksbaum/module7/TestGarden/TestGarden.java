package org.buksbaum.module7.TestGarden;

/**
 * Created by david on 3/22/2015.
 */
// Let's keep it simple; a console based test app.
public class TestGarden {
  public static void main(String[] args) {
    Garden gtest;
    Plant ptest;
    GardenMaker gm = new GardenMaker();
    gtest = gm.getGarden("");
    ptest = gtest.getCenter();
    System.out.println(ptest.getName());
    ptest = gtest.getBorder();
    System.out.println(ptest.getName());
    ptest = gtest.getShade();
    System.out.println(ptest.getName());
    //let's get another Garden type
    gtest = gm.getGarden("Annual");
    ptest = gtest.getCenter();
    System.out.println(ptest.getName());
    ptest = gtest.getBorder();
    System.out.println(ptest.getName());
    ptest = gtest.getShade();
    System.out.println(ptest.getName());
    //last Garden type
    gtest = gm.getGarden("Perennial");
    ptest = gtest.getCenter();
    System.out.println(ptest.getName());
    ptest = gtest.getBorder();
    System.out.println(ptest.getName());
    ptest = gtest.getShade();
    System.out.println(ptest.getName());
  }
}
