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
public class GridLayoutDemo extends JFrame
        implements ActionListener {
  private JButton buttons[];
  private String names[]= {"one", "two", "three", "four", "five", "six" };
  private boolean toggle = true;
  private Container container;
  private GridLayout grid1, grid2;

  // setup GUI
  public GridLayoutDemo(){
    super("GridLayout Demo");
    // setup layouts
    grid1 = new GridLayout(2,3,5,5);
    grid2 = new GridLayout(3,2,5,5);

    //get content pane and set its layout
    container = getContentPane();
    container.setLayout(grid1);

    //create and add buttons
    buttons = new JButton[names.length];

    for(int count = 0; count < names.length; count++)
    {
      buttons[count] = new JButton(names[count]);
      buttons[count].addActionListener(this);
      container.add(buttons[count]);
    }

    setSize(300,150);
    setVisible(true);
  }// end of constructor

  public void actionPerformed(ActionEvent event) {
    if(toggle)
      container.setLayout(grid2);
    else
      container.setLayout(grid1);

    // set toogle to opposite value
    toggle = !toggle;
    container.validate();
  }

  // execute application
  public static void main(String args[]) {
    GridLayoutDemo application = new GridLayoutDemo();
    application.setDefaultCloseOperation(
            JFrame.EXIT_ON_CLOSE);
  }
}// end of class
