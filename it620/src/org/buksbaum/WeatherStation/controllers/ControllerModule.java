package org.buksbaum.WeatherStation.controllers;

import dagger.Module;
import dagger.Provides;
import org.buksbaum.WeatherStation.storage.StorageModule;
import org.buksbaum.WeatherStation.view.ViewModule;

/**
 * Created by david on 4/3/2015.
 */
//  this module imports its dependencies for views and storage
//  we need to declare this a library since the IMainController is not used in this module
@Module(library = true, includes = {ViewModule.class, StorageModule.class})
public class ControllerModule
{
  @Provides
  public IMainController provideWeatherAppController(WeatherAppController weatherAppController)
  {
    return weatherAppController;
  }

  @Provides
  ICollectWeatherDataController provideCollectWeatherDataController(CollectWeatherDataController collectWeatherDataController)
  {
    return collectWeatherDataController;
  }
}

