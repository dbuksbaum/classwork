package org.buksbaum.WeatherStation.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

/**
 * Created by david on 3/31/2015.
 *
 * Instace of a class that implements IMainForm for the main window in the Weather Station Application
 */
public class MainForm implements IMainForm
{ //  fields
  private JPanel panel1;
  private JButton updateButton;
  private JLabel currentConditionsLabel;
  private JLabel forecastLabel;
  private JLabel statisticsLabel;
  private JLabel heatIndexLabel;
  private JLabel windChillIndexLabel;
  private JList historyList;
  private JLabel statusLabel;
  private FormVisibilityChanged formVisibilityEventHandler;
  private UpdateCommand updateCommand;

/*
  private void createUIComponents()
  {
    // TODO: place custom component creation code here
  }
*/

  /**
   * Show the main form.
   */
  @Override
  public void showTheForm()
  {//  create our frame
    JFrame frame = new JFrame("Dave's Ultimate Weather App");
    //  set the content panel
    frame.setContentPane(this.panel1);
    //  set the action on close button press
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //  set our minimum size
    frame.setMinimumSize(new Dimension(800, 500));
    //  set the start up location to use the system defaults
    frame.setLocationByPlatform(true);

    //  establish Proxy from the frames component listener to our delegates
    frame.addComponentListener(new ComponentAdapter()
    {
      /**
       * Invoked when the component has been made visible.
       *
       * @param e
       */
      @Override
      public void componentShown(ComponentEvent e)
      { //  if we have a form visibility event handler, let them know we are visible
        if (formVisibilityEventHandler != null)
          formVisibilityEventHandler.formVisibilityChanged(true);
        super.componentShown(e);
      }

      /**
       * Invoked when the component has been made invisible.
       *
       * @param e
       */
      @Override
      public void componentHidden(ComponentEvent e)
      { //  if we have a form visibility event handler, let them know we are not visible
        if (formVisibilityEventHandler != null)
          formVisibilityEventHandler.formVisibilityChanged(false);
        super.componentHidden(e);
      }
    });

    //  set up the update button
    updateButton.addActionListener(e ->
                                   {  //  if we have an update event handler, tell them to handle it!
                                     if(updateCommand != null)
                                       updateCommand.update();
                                   });

    //  pack the luggage
    frame.pack();
    //  show the window
    frame.setVisible(true);
  }

  /**
   * Set the status text at the top of the form.
   * @param text the text to be displayed
   */
  @Override
  public void setStatusText(String text)
  {
    statusLabel.setText(text);
  }

  /**
   * Clear the history list
   */
  @Override
  public void clearHistory()
  {
    historyList.removeAll();
  }

  /**
   * Sets the history list to the passed list of items
   * @param historyItems string array of historical weather data items
   */
  @Override
  public void setHistoryData(String[] historyItems)
  {
    historyList.setListData(historyItems);
  }

  /**
   * Sets the text for the current conditions
   * @param currentConditions the text for the current conditions
   */
  @Override
  public void setCurrentConditions(String currentConditions)
  {
    currentConditionsLabel.setText(currentConditions);
  }

  /**
   * Sets the text for the forecasted weather
   * @param forecast the text for the forecast
   */
  @Override
  public void setForecast(String forecast)
  {
    forecastLabel.setText(forecast);
  }

  /**
   * Sets the text for statistics on the weather collected to date
   * @param statistics the weather statistics
   */
  @Override
  public void setStatistics(String statistics)
  {
    statisticsLabel.setText(statistics);
  }

  /**
   * Sets the heat index for the current weather
   * @param heatIndex the heat index
   */
  @Override
  public void setHeatIndex(String heatIndex)
  {
    heatIndexLabel.setText(heatIndex);
  }

  /**
   * Sets the wind chill for the current weather
   * @param windChill the wind chill index
   */
  @Override
  public void setWindChill(String windChill)
  {
    windChillIndexLabel.setText(windChill);
  }

  //  event handler setters
  /**
   * Sets a Lambda handler for being notified when the form visibility changes
   * @param formVisibilityEventHandler lambda function interface for the handler
   */
  @Override
  public void setFormVisibilityEventHandler(FormVisibilityChanged formVisibilityEventHandler)
  {
    this.formVisibilityEventHandler = formVisibilityEventHandler;
  }

  /**
   * Sets the Lambda handler for being notified when the update button is pressed
   * @param updateCommand lambda function interface for the handler
   */
  @Override
  public void setUpdateCommandEventHandler(UpdateCommand updateCommand)
  {
    this.updateCommand = updateCommand;
  }
}

