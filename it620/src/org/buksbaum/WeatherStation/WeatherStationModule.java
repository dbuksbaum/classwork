package org.buksbaum.WeatherStation;

import dagger.Module;
import org.buksbaum.WeatherStation.view.MainForm;
import org.buksbaum.WeatherStation.view.ViewModules;

/**
 * Created by david on 4/1/2015.
 */
@Module
        (
                injects = WeatherApp.class,
                includes = ViewModules.class
        )
class WeatherStationModule
{

}
