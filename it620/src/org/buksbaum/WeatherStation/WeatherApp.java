package org.buksbaum.WeatherStation;

import dagger.ObjectGraph;
//import org.buksbaum.WeatherStation.view.MainForm;
import org.buksbaum.WeatherStation.controllers.IMainController;

import javax.inject.Inject;

/**
 * Created by david on 4/1/2015.
 */
public class WeatherApp implements Runnable
{
  // our root window gets injected
  //@Inject
  //MainForm mainForm;

  @Inject
  IMainController mainController;

  public static void main(String args[])
  { //  create the IoC container with the specified configuration module
    ObjectGraph objectGraph = ObjectGraph.create(new WeatherStationModule());
    //  get out weather application class, the object root of our application
    //  Composite Pattern in Action!
    //WeatherApp weatherApp = objectGraph.get(WeatherApp.class);
    WeatherApp weatherApp = objectGraph.get(WeatherApp.class);
    //  Run the application. Strategy Pattern in Action!
    weatherApp.run();
  }

/*
  @Inject
  public WeatherApp(IMainController controller)
  {
    mainController = controller;
  }
*/

  /**
   * When an object implementing interface <code>Runnable</code> is used
   * to create a thread, starting the thread causes the object's
   * <code>run</code> method to be called in that separately executing
   * thread.
   * <p>
   * The general contract of the method <code>run</code> is that it may
   * take any action whatsoever.
   *
   * @see Thread#run()
   */
  @Override
  public void run()
  {
    mainController.run();
    //mainForm.ShowTheForm();
  }
}

