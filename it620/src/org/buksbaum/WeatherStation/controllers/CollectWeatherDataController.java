package org.buksbaum.WeatherStation.controllers;

import org.buksbaum.WeatherStation.model.WeatherData;
import org.buksbaum.WeatherStation.view.ICollectWeatherDataForm;

import javax.inject.Inject;

/**
 * Created by david on 4/3/2015.
 */
public class CollectWeatherDataController implements ICollectWeatherDataController
{
  private WeatherData collectedWeatherData;

  @Inject
  ICollectWeatherDataForm collectWeatherDataForm;


  @Override
  public Boolean showDialog()
  {
    Boolean dialogClosedWithOk = collectWeatherDataForm.showDialog();
    if(dialogClosedWithOk)
      extractDialogData();

    return dialogClosedWithOk;
  }

  @Override
  public WeatherData getEnteredWeatherData()
  {
    return collectedWeatherData;
  }

  private void extractDialogData()
  {
    collectedWeatherData = new WeatherData(
            collectWeatherDataForm.getTemperature(),
            collectWeatherDataForm.getPressure(),
            collectWeatherDataForm.getHumidity(),
            collectWeatherDataForm.getWindSpeed());
  }
}
