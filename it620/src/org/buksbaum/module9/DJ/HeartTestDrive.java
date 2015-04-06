package org.buksbaum.module9.DJ;

/**
 * Created by david on 4/5/2015.
 */
public class HeartTestDrive {

  public static void main (String[] args) {
    HeartModel heartModel = new HeartModel();
    ControllerInterface model = new HeartController(heartModel);
  }
}
