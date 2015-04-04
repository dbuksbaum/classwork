package org.buksbaum.WeatherStation.storage;

import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;

/**
 * Created by david on 4/3/2015.
 *
 * Dagger module that educates the object graph in the Weather Stationm Application
 * about the exposed storage classes in the application.
 *
 * This module is a library since the exposed types are not used in this module.
 */
@Module(library = true)
public class StorageModule
{
  /**
   * Provides the one and only (Singelton pattern at work!) weather data store
   * @return the weather data store
   */
  @Provides
  @Singleton
  public IWeatherDataStore provideWeatherDataStore()
  {
    //  uncomment the next line (and comment 2 lines after) to use the in memory flavor of storage
    //return new InMemoryWeatherDataStore();
    //  returns the mysql weather data store
    return new MySqlWeatherDataStore();
  }
}
