package org.buksbaum.WeatherStation.view;

import dagger.Module;
import dagger.Provides;

/**
 * Created by david on 4/3/2015.
 * Dagger module that educates the object graph in the Weather Stationm Application
 * about the exposed views in the application.
 *
 * This module is a library since the exposed types are not used in this module.
 */
@Module(library = true)
public class ViewModule
{
  /**
   * Constructs a main form, but does not perform any injection on the main form itself
   * @return the main form
   */
  @Provides
  public IMainForm provideMainForm()
  {
    return new MainForm();
  }

  /**
   * Constructs the collect weather data dialog, but does not perform any injection on the dialog itself
   * @return the collect weather data dialog
   */
  @Provides
  public ICollectWeatherDataForm provideCollectWeatherDataDialog()
  {
    return new CollectWeatherData();
  }
}
