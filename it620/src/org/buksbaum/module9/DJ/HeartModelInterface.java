package org.buksbaum.module9.DJ;

/**
 * Created by david on 4/5/2015.
 */
public interface HeartModelInterface {
  int getHeartRate();
  void registerObserver(BeatObserver o);
  void removeObserver(BeatObserver o);
  void registerObserver(BPMObserver o);
  void removeObserver(BPMObserver o);
}
