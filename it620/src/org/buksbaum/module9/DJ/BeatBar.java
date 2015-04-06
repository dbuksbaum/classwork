package org.buksbaum.module9.DJ;

import javax.swing.*;

/**
 * Created by david on 4/5/2015.
 */
public class BeatBar extends JProgressBar implements Runnable {
  JProgressBar progressBar;
  Thread thread;

  public BeatBar() {
    thread = new Thread(this);
    setMaximum(100);
    thread.start();
  }

  public void run() {
    for(;;) {
      int value = getValue();
      value = (int)(value * .75);
      setValue(value);
      repaint();
      try {
        Thread.sleep(50);
      } catch (Exception e) {};
    }
  }
}
