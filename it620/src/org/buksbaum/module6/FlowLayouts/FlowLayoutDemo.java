package org.buksbaum.module6.FlowLayouts;

/*
 * Created on Dec 8, 2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */

/**
 * @author donn
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Created by david on 3/16/2015.
 */
public class FlowLayoutDemo extends JFrame {
  private JButton leftButton, centerButton, rightButton;
  private Container container;
  private FlowLayout layout;

  public FlowLayoutDemo()
  {
    super("FlowLayout Demo");
    layout  = new FlowLayout();

    container = getContentPane();
    container.setLayout(layout);

    leftButton = new JButton("Left");
    leftButton.addActionListener(
            new ActionListener() {
              public void actionPerformed(ActionEvent event)
              {
                layout.setAlignment(FlowLayout.LEFT);
                layout.layoutContainer(container);
              }
            } // end of inner class
    ) ;

    container.add(leftButton);

    centerButton = new JButton("Center");
    centerButton.addActionListener(
            new ActionListener() {
              public void actionPerformed(ActionEvent event)
              {
                layout.setAlignment(FlowLayout.CENTER);
                layout.layoutContainer(container);
              }
            } // end of inner class
    ) ;

    container.add(centerButton);

    rightButton = new JButton("Right");
    rightButton.addActionListener(
            new ActionListener() {
              public void actionPerformed(ActionEvent event)
              {
                layout.setAlignment(FlowLayout.RIGHT);
                layout.layoutContainer(container);
              }
            } // end of inner class
    ) ;

    container.add(rightButton);

    setSize(300,75);
    setVisible(true);

  } // end of the constructor

  public static void main(String args[])
  {
    FlowLayoutDemo application = new FlowLayoutDemo();

    application.setDefaultCloseOperation(
            JFrame.EXIT_ON_CLOSE);
  }


} // end of class
