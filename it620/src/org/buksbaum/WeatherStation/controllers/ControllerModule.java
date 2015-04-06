package org.buksbaum.WeatherStation.controllers;

import dagger.Module;
import dagger.Provides;
import org.buksbaum.WeatherStation.storage.StorageModule;
import org.buksbaum.WeatherStation.view.ViewModule;

/**
 * Created by david on 4/3/2015.
 * this module imports its dependencies for views and storage
 * we need to declare this a library since the IMainController is not used in this module
 */
@Module(library = true, includes = {ViewModule.class, StorageModule.class})
public class ControllerModule
{
  /**
   * Provides the main controller, which is currently a WeatherAppController. It does perform
   * injection into the WeatherAppController
   * @param weatherAppController a marker type informing Dagger IoC what type to create
   * @return the main controller
   */
  @Provides
  public IMainController provideWeatherAppController(WeatherAppController weatherAppController)
  {
    return weatherAppController;
  }

  /**
   * Provides the collect weather data controller. It does perform injection into the CollectWeatherDataController
   * @param collectWeatherDataController a marker type informing Dagger IoC what type to create
   * @return the collect weather data controller
   */
  @Provides
  ICollectWeatherDataController provideCollectWeatherDataController(CollectWeatherDataController collectWeatherDataController)
  {
    return collectWeatherDataController;
  }
}

