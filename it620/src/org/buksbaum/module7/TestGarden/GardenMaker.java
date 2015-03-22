package org.buksbaum.module7.TestGarden;

/**
 * Created by david on 3/22/2015.
 */
public class GardenMaker {
  // Abstract Factory that returns one of three gardens
  private Garden gd;

  public Garden getGarden(String gtype) {
    gd = new VegieGarden(); // default type
    if(gtype.equals("Perennial"))
      gd = new PerennialGarden();
    if(gtype.equals("Annual"))
      gd = new AnnualGarden();
    return gd;
  }
}
