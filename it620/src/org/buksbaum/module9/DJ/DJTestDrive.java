package org.buksbaum.module9.DJ;

/**
 * Created by david on 4/5/2015.
 */
public class DJTestDrive {

  public static void main (String[] args) {
    BeatModelInterface model = new BeatModel();
    ControllerInterface controller = new BeatController(model);
  }
}



