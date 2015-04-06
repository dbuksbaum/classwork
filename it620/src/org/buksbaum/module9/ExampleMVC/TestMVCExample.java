package org.buksbaum.module9.ExampleMVC;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by david on 4/5/2015.
 */
public class TestMVCExample {
  public static void main(String[] arguments) {

    // Instantiate model
    ExampleModel exampleModel = new ExampleModel();
    // Instantiate view to enter data
    ExampleView view = new ExampleView(exampleModel);
    exampleModel.addContactView(view);
    createGui(view, "Enter Student Information");
    // Contact view to display data
    ExampleDisplayView displayView = new ExampleDisplayView(exampleModel);
    exampleModel.addContactView(displayView);
    createGui(displayView, "Student Information");
  }

  private static void createGui(JPanel contents, String windowName) {
    JFrame frame = new JFrame(windowName);
    frame.getContentPane().add(contents);
    frame.addWindowListener(new WindowCloseManager());
    frame.pack();
    frame.setVisible(true);
  }

  private static class WindowCloseManager extends WindowAdapter
  {
    public void windowClosing(WindowEvent evt) {
      System.exit(0);
    }
  }
}
