package org.buksbaum.module9.DJ;

/**
 * Created by david on 4/5/2015.
 */
public class HeartController implements ControllerInterface {
  HeartModelInterface model;
  DJView view;

  public HeartController(HeartModelInterface model) {
    this.model = model;
    view = new DJView(this, new HeartAdapter(model));
    view.createView();
    view.createControls();
    view.disableStopMenuItem();
    view.disableStartMenuItem();
  }

  public void start() {}

  public void stop() {}

  public void increaseBPM() {}

  public void decreaseBPM() {}

  public void setBPM(int bpm) {}
}
