package org.buksbaum.WeatherStation.storage;

import org.buksbaum.WeatherStation.model.WeatherData;
import org.junit.Test;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by david on 3/22/2015.
 */
public abstract class WeatherDataStoreTest
{
  protected IWeatherDataStore weatherDataStore;

  @Test
  public void testWeatherDataSize() throws Exception
  {
    assertEquals(0, weatherDataStore.size());
  }

  @Test
  public void testAddWeatherData() throws Exception
  {
    assertEquals(0, weatherDataStore.size());

    weatherDataStore.addWeatherData(new WeatherData(80, 30.4f, 65, 10));
    assertEquals(1, weatherDataStore.size());

    weatherDataStore.addWeatherData(new WeatherData(82, 29.2f, 70, 15));
    assertEquals(2, weatherDataStore.size());

    weatherDataStore.addWeatherData(new WeatherData(78, 29.2f, 90, 20));
    assertEquals(3, weatherDataStore.size());
  }

  @Test
  public void testGetCurrentWeatherData() throws Exception
  {
    assertEquals(0, weatherDataStore.size());

    weatherDataStore.addWeatherData(new WeatherData(80, 30.4f, 65, 10));
    assertEquals(1, weatherDataStore.size());

    weatherDataStore.addWeatherData(new WeatherData(82, 29.2f, 70, 15));
    assertEquals(2, weatherDataStore.size());

    final WeatherData weatherData = new WeatherData(78, 29.2f, 90, 20);
    weatherDataStore.addWeatherData(weatherData);
    assertEquals(3, weatherDataStore.size());

    //  get the current according to the store
    WeatherData currentWeatherData = weatherDataStore.getCurrentWeatherData();

    //  compare the last added with the current returned
    //assertEquals(weatherData, currentWeatherData);

    //  shouldnt need to do this, but need to because the object assertion fails when comparing the doubles
    assertEquals(weatherData.getCaptureTime(), currentWeatherData.getCaptureTime());
    assertEquals(weatherData.getTemperature(), currentWeatherData.getTemperature(), 0.000001f);
    assertEquals(weatherData.getPressure(), currentWeatherData.getPressure(), 0.000001f);
    assertEquals(weatherData.getHumidity(), currentWeatherData.getHumidity());
    assertEquals(weatherData.getWindSpeed(), currentWeatherData.getWindSpeed());
  }

  @Test
  public void testGetAllWeatherData() throws Exception
  {
    assertEquals(0, weatherDataStore.size());

    weatherDataStore.addWeatherData(new WeatherData(80, 30.4f, 65, 10));
    assertEquals(1, weatherDataStore.size());

    weatherDataStore.addWeatherData(new WeatherData(82, 29.2f, 70, 15));
    assertEquals(2, weatherDataStore.size());

    weatherDataStore.addWeatherData(new WeatherData(78, 29.2f, 90, 20));
    assertEquals(3, weatherDataStore.size());

    Collection<WeatherData> allWeatherData = weatherDataStore.getAllWeatherData();
    assertEquals(3, allWeatherData.size());
    //  test a sample of each to make sure they got returned in order
    Iterator<WeatherData> iterator = allWeatherData.iterator();
    assertEquals(10, iterator.next().getWindSpeed());
    assertEquals(15, iterator.next().getWindSpeed());
    assertEquals(20, iterator.next().getWindSpeed());

    assertEquals(false, iterator.hasNext());
  }

  @Test
  public void testClearAll() throws Exception
  {
    assertEquals(0, weatherDataStore.size());

    weatherDataStore.addWeatherData(new WeatherData(80, 30.4f, 65, 10));
    assertEquals(1, weatherDataStore.size());

    weatherDataStore.addWeatherData(new WeatherData(82, 29.2f, 70, 15));
    assertEquals(2, weatherDataStore.size());

    weatherDataStore.addWeatherData(new WeatherData(78, 29.2f, 90, 20));
    assertEquals(3, weatherDataStore.size());

    //  clear it all
    weatherDataStore.clearAll();

    //  now prove it
    assertEquals(0, weatherDataStore.size());
  }
}
