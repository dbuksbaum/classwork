package org.buksbaum.WeatherStation.view;

import dagger.Module;
import dagger.Provides;

/**
 * Created by david on 4/3/2015.
 */
@Module(library = true)
public class ViewModule
{
  @Provides
  public IMainForm provideMainForm()
  {
    return new MainForm();
  }

  @Provides
  public ICollectWeatherDataForm provideCollectWeatherDataDialog()
  {
    return new CollectWeatherData();
  }
}
