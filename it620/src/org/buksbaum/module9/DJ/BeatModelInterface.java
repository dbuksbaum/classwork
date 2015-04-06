package org.buksbaum.module9.DJ;

/**
 * Created by david on 4/5/2015.
 */
public interface BeatModelInterface {
  void initialize();

  void on();

  void off();

  void setBPM(int bpm);

  int getBPM();

  void registerObserver(BeatObserver o);

  void removeObserver(BeatObserver o);

  void registerObserver(BPMObserver o);

  void removeObserver(BPMObserver o);
}
