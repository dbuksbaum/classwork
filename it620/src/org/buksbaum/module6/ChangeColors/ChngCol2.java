package org.buksbaum.module6.ChangeColors;

// Demo use of button in Swing: change between 2 bg colors
// Add text field to get new color
// Bill McMillan, 10/27/02

import java.awt.*;         // low-level GUI stuff
import java.awt.event.*;   //    ditto, to handle user events
import javax.swing.*;      // higher-level GUI stuff

/**
 * Created by david on 3/16/2015.
 */
public class ChngCol2 extends JFrame  // main application window
{
  private JPanel pane;               // content pane to hold btns, etc.
  private JButton changeBtn;         // button to change bg color
  private JTextField newColor;       // for user to type new color
  private JLabel colorLbl;

  // An inner class that is just to listen to color buttons
  //   (has access to variables in class ChngCol):

  class colorButtonListener implements ActionListener
  { public void actionPerformed(ActionEvent e)
  { String newC = newColor.getText();
    if (newC.equals("blue"))
    { pane.setBackground(Color.blue);
    }
    else if (newC.equals("green"))
    { pane.setBackground(Color.green);
    }
    else if (newC.equals("red"))
    { pane.setBackground(Color.red);
    }
    else if (newC.equals("cyan"))
    { pane.setBackground(Color.cyan);
    }
    else
    {
      pane.setBackground(Color.WHITE);
      System.out.println("I didn't recognize the color");
    }
  }
  }

  // constructor:
  public ChngCol2 ()
  {
    // frame setup
    setTitle("Change Color");
    // setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(200, 300);

    // button setup
    changeBtn = new JButton("Change Color");
    // create listener object and attach to button:
    changeBtn.addActionListener(new colorButtonListener());

    // label and text field setup
    colorLbl = new JLabel("blue, green, red, or cyan:");
    colorLbl.setForeground(Color.WHITE);
    newColor = new JTextField(12);          // 12 columns

    // content pane setup
    pane = new JPanel();
    setContentPane(pane);                // this frame will use pane
    // layout is left to right, top to bottom, centered:
    pane.setLayout(new FlowLayout(FlowLayout.CENTER));
    pane.add(changeBtn);                 // attach button made above
    pane.add(colorLbl);                  // attach text label
    pane.add(newColor);                  // attach text field

    // make bg of pane blue to start
    pane.setBackground(Color.blue);
  }

  public static void main(String[] args)
  { ChngCol2 cc = new ChngCol2();
    cc.show();
  }
}
