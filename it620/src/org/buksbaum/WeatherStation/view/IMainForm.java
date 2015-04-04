package org.buksbaum.WeatherStation.view;

import org.buksbaum.WeatherStation.model.WeatherData;

import java.util.List;
import java.util.Vector;

/**
 * Created by david on 4/3/2015.
 */
public interface IMainForm
{
  public void showTheForm();
  public void setStatusText(String text);

  public void clearHistory();
  public void setHistoryData(String[] historyItems);
  public void setCurrentConditions(String currentConditions);
  public void setForecast(String forecast);
  public void setStatistics(String statistics);
  public void setHeatIndex(String heatIndex);
  public void setWindChill(String windChill);

  //  event handlers
  public void setFormVisibilityEventHandler(FormVisibilityChanged formVisibilityEventHandler);
  public void setUpdateCommandEventHandler(UpdateCommand updateCommand);

}

