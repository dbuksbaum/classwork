package org.buksbaum.WeatherStation.view;

import org.buksbaum.WeatherStation.model.WeatherData;

import java.util.List;
import java.util.Vector;

/**
 * Created by david on 4/3/2015.
 * Interface defining the capabilities of the main form of the Weather Station Application
 */
public interface IMainForm
{
  /**
   * Show the main form.
   */
  public void showTheForm();

  /**
   * Set the status text at the top of the form.
   * @param text the text to be displayed
   */
  public void setStatusText(String text);

  /**
   * Clear the history list
   */
  public void clearHistory();

  /**
   * Sets the history list to the passed list of items
   * @param historyItems string array of historical weather data items
   */
  public void setHistoryData(String[] historyItems);

  /**
   * Sets the text for the current conditions
   * @param currentConditions the text for the current conditions
   */
  public void setCurrentConditions(String currentConditions);

  /**
   * Sets the text for the forecasted weather
   * @param forecast the text for the forecast
   */
  public void setForecast(String forecast);

  /**
   * Sets the text for statistics on the weather collected to date
   * @param statistics the weather statistics
   */
  public void setStatistics(String statistics);

  /**
   * Sets the heat index for the current weather
   * @param heatIndex the heat index
   */
  public void setHeatIndex(String heatIndex);

  /**
   * Sets the wind chill for the current weather
   * @param windChill the wind chill index
   */
  public void setWindChill(String windChill);

  //  event handlers

  /**
   * Sets a Lambda handler for being notified when the form visibility changes
   * @param formVisibilityEventHandler lambda function interface for the handler
   */
  public void setFormVisibilityEventHandler(FormVisibilityChanged formVisibilityEventHandler);

  /**
   * Sets the Lambda handler for being notified when the update button is pressed
   * @param updateCommand lambda function interface for the handler
   */
  public void setUpdateCommandEventHandler(UpdateCommand updateCommand);
}

