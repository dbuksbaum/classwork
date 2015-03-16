package org.buksbaum.module6.ChangeColors;

// Frame to display the name of the color chosen by the user

import java.awt.*;         // low-level GUI stuff
import javax.swing.*;      // higher-level GUI stuff

/**
 * Created by david on 3/16/2015.
 */
public class FeedbackFrame extends JFrame
{ private JLabel colorChosen;
  private JPanel pane;

  public FeedbackFrame()
  { colorChosen = new JLabel("Test label");

    // frame setup
    setTitle("Color Chosen");
    setSize(165, 100);

    pane = new JPanel();
    setContentPane(pane);
    pane.setLayout(new BorderLayout());
    pane.add(colorChosen,"Center");
  }

  // allow outsiders to change text of label
  public void setLabel(String S)
  { colorChosen.setText("Thanks for choosing " + S); }
}
