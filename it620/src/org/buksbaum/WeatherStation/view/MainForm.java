package org.buksbaum.WeatherStation.view;

import dagger.Provides;

import javax.swing.*;

/**
 * Created by david on 3/31/2015.
 */
public class MainForm
{
  private JPanel panel1;
  private JButton currentConditionsButton;
  private JButton forecastButton;
  private JButton statisticsButton;
  private JButton heatIndexButton;
  private JButton updateButton;
  private JButton historyButton;
  private JPanel contentPanel;

  public static void main(String[] args)
  {
    JFrame frame = new JFrame("Dave's Ultimate Weather App");
    frame.setContentPane(new MainForm().panel1);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.pack();
    frame.setVisible(true);
  }


  public void ShowTheForm()
  {
    JFrame frame = new JFrame("Dave's Ultimate Weather App");
    frame.setContentPane(this.panel1);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.pack();
    frame.setVisible(true);
  }
}
