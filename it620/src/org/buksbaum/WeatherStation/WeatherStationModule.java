package org.buksbaum.WeatherStation;

import dagger.Module;
import org.buksbaum.WeatherStation.controllers.ControllerModule;

/**
 * Created by david on 4/1/2015.
 * Dagger module that is the root of the modules loaded for the object graph in the
 * Weather Stationm Application
 *
 * This module only imports the startup class and the controller module it needs to reference
 */
@Module(library = false, complete = true, injects = {WeatherApp.class}, includes = {ControllerModule.class})
class WeatherStationModule
{
}
