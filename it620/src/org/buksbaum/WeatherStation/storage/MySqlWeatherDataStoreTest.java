package org.buksbaum.WeatherStation.storage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MySqlWeatherDataStoreTest  extends WeatherDataStoreTest
{
  @Before
  public void setUp() throws Exception
  { //  set out strategy to the MySQL data store
    weatherDataStore = new MySqlWeatherDataStore();

    //  make sure the repo is clear before we do anything
    weatherDataStore.clearAll();
  }

  @After
  public void tearDown() throws Exception
  { //  be a good garbage collection citizen and null out our locals
    weatherDataStore = null;
  }
}