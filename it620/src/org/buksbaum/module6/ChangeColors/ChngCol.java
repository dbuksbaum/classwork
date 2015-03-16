package org.buksbaum.module6.ChangeColors;

// Demo use of button in Swing: change between 2 bg colors
// Bill McMillan, 10/27/02

// JBuilder demands package

import java.awt.*;         // low-level GUI stuff
import java.awt.event.*;
//    ditto, to handle user events
import javax.swing.*;      // higher-level GUI stuff

/**
 * Created by david on 3/16/2015.
 */
public class ChngCol extends JFrame  // main application window
{
  private JPanel pane;               // content pane to hold btns, etc.
  private JButton changeBtn;         // button to change bg color
  private String currentColor;       // what color are we now?

  // An inner class that is just to listen to color buttons
  //   (has access to variables in class ChngCol):

  class colorButtonListener implements ActionListener
  { public void actionPerformed(ActionEvent e)
  { if (currentColor.equals("blue"))
  { pane.setBackground(Color.green);
    currentColor = "green";
  }
  else
  { pane.setBackground(Color.blue);
    currentColor = "blue";
  }
  }
  }

  // constructor:
  public ChngCol ()
  {
    // frame setup
    setTitle("Change Color");
    // setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // problem in BlueJ
    setSize(400, 200);

    // button setup
    changeBtn = new JButton("Change Color");
    // create listener object and attach to button:
    changeBtn.addActionListener(new colorButtonListener());

    // content pane setup
    pane = new JPanel();
    setContentPane(pane);              // this frame will use pane
    pane.setLayout(new FlowLayout());  // left to right, top to bottom
    pane.add(changeBtn);               // attach button made above
    //pane.setVisible(true);
    // make bg of pane blue to start
    currentColor = "blue";
    pane.setBackground(Color.blue);
    //pane.setVisible(true);
  }

  public static void main(String[] args)
  { ChngCol cc = new ChngCol();
    cc.show();
  }
}
