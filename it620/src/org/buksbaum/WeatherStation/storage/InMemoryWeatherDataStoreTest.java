package org.buksbaum.WeatherStation.storage;

import org.buksbaum.WeatherStation.model.WeatherData;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class InMemoryWeatherDataStoreTest extends WeatherDataStoreTest
{
  @Before
  public void setUp() throws Exception
  { //  set out strategy to the in memory data store
    weatherDataStore = new InMemoryWeatherDataStore();
  }

  @After
  public void tearDown() throws Exception
  { //  be a good garbage collection citizen and null out our locals
    weatherDataStore = null;
  }
}