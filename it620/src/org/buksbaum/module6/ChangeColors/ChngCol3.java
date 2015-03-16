package org.buksbaum.module6.ChangeColors;

// Demo use of button in Swing: change between bg colors
// Add text field to get new color
// Add menu to get color
// Bill McMillan, 10/27/02

import java.awt.*;         // low-level GUI stuff
import java.awt.event.*;   //    ditto, to handle user events
import javax.swing.*;      // higher-level GUI stuff

/**
 * Created by david on 3/16/2015.
 */
public class ChngCol3 extends JFrame  // main application window
{
  private JPanel majorPane;          // main content pane
  private JPanel pane;               // content pane to hold btns, etc.
  private JButton changeBtn;         // button to change bg color
  private JTextField newColor;       // for user to type new color
  private JLabel colorLbl;           // to label text field
  private JMenuBar menuBar;          // menu bar for frame
  private JMenu colorMenu;           // menu for colors
  private JMenuItem mItem;           // temp for menu item construction

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
  }
  }

  // inner classes for listening to menu items
  //  (can have single listener for all and then use if-then to ID item)

  class BlueListener implements ActionListener
  { public void actionPerformed(ActionEvent e)
  { pane.setBackground(Color.blue);}
  }

  class GreenListener implements ActionListener
  { public void actionPerformed(ActionEvent e)
  { pane.setBackground(Color.green);}
  }

  class RedListener implements ActionListener
  { public void actionPerformed(ActionEvent e)
  { pane.setBackground(Color.red);}
  }

  class CyanListener implements ActionListener
  { public void actionPerformed(ActionEvent e)
  { pane.setBackground(Color.cyan);}
  }

  // constructor:
  public ChngCol3 ()
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
    colorLbl.setForeground(Color.white);
    newColor = new JTextField(12);          // 12 columns

    // menu setup
    menuBar = new JMenuBar();
    colorMenu = new JMenu("Color");

    // for each color, make menu item, put in menu, hook to listener:
    mItem = new JMenuItem("Blue");
    colorMenu.add(mItem);
    mItem.addActionListener(new BlueListener());

    mItem = new JMenuItem("Green");
    colorMenu.add(mItem);
    mItem.addActionListener(new GreenListener());

    mItem = new JMenuItem("Red");
    colorMenu.add(mItem);
    mItem.addActionListener(new RedListener());

    mItem = new JMenuItem("Cyan");
    colorMenu.add(mItem);
    mItem.addActionListener(new CyanListener());

    menuBar.add(colorMenu);       // attach menu to menu bar

    // major content pane setup
    majorPane = new JPanel();
    setContentPane(majorPane);
    majorPane.setLayout(new BorderLayout());  // N, S, E, W, or center

    pane = new JPanel();
    // layout is left to right, top to bottom, centered:
    pane.setLayout(new FlowLayout(FlowLayout.CENTER));
    pane.add(menuBar);
    pane.add(changeBtn);                 // attach button made above
    pane.add(colorLbl);                  // attach text label
    pane.add(newColor);                  // attach text field

    // attach menu and pane to major pane
    majorPane.add(menuBar,"North");      // across top of frame
    majorPane.add(pane,"Center");        // centered in remaining area

    // make bg of pane blue to start
    pane.setBackground(Color.blue);
  }

  public static void main(String[] args)
  { ChngCol3 cc = new ChngCol3();
    cc.show();
  }
}
