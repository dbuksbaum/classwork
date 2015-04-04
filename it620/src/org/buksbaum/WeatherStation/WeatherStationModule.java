package org.buksbaum.WeatherStation;

import dagger.Module;
import dagger.Provides;
import org.buksbaum.WeatherStation.controllers.ControllerModule;
import org.buksbaum.WeatherStation.controllers.IMainController;
import org.buksbaum.WeatherStation.controllers.WeatherAppController;

import javax.inject.Singleton;

/**
 * Created by david on 4/1/2015.
 */
//  this module only imports the startup class and the controller module it needs
@Module(library = false, complete = true, injects = {WeatherApp.class}, includes = {ControllerModule.class})
class WeatherStationModule
{
}
