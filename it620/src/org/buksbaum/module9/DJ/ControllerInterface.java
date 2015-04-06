package org.buksbaum.module9.DJ;

/**
 * Created by david on 4/5/2015.
 */
public interface ControllerInterface {
  void start();
  void stop();
  void increaseBPM();
  void decreaseBPM();
  void setBPM(int bpm);
}
