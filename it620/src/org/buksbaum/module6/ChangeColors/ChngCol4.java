package org.buksbaum.module6.ChangeColors;

// Demo use of button in Swing: change between bg colors
// Use dialogue box to get color
// Bill McMillan, 10/31/02

import java.awt.*;         // low-level GUI stuff
import java.awt.event.*;   //    ditto, to handle user events
import javax.swing.*;      // higher-level GUI stuff

/**
 * Created by david on 3/16/2015.
 */
public class ChngCol4 extends JFrame  // main application window
{
  private JPanel pane;               // content pane to hold btns, etc.
  private JButton changeBtn;         // button to change bg color

  // An inner class that is just to listen to color buttons
  //   (has access to variables in class ChngCol):

  class colorButtonListener implements ActionListener
  { public void actionPerformed(ActionEvent e)
  { String newC = JOptionPane.showInputDialog(
          null,                           // parent
          "red, green, blue, or cyan:",   // prompt
          "Color Choice",                 // title
          JOptionPane.QUESTION_MESSAGE); // kind
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
  }
  }

  // constructor:
  public ChngCol4 ()
  {
    // frame setup
    setTitle("Change Color");
    // setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(200, 300);

    // button setup
    changeBtn = new JButton("Change Color");
    // create listener object and attach to button:
    changeBtn.addActionListener(new colorButtonListener());

    pane = new JPanel();
    pane.setLayout(new FlowLayout(FlowLayout.CENTER));
    pane.add(changeBtn);                 // attach button made above
    setContentPane(pane);

    // make bg of pane blue to start
    pane.setBackground(Color.blue);
  }

  public static void main(String[] args)
  { ChngCol4 cc = new ChngCol4();
    cc.show();
  }
}

