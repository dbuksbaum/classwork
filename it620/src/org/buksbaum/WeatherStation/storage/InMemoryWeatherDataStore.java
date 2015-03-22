package org.buksbaum.WeatherStation.storage;

import org.buksbaum.WeatherStation.model.WeatherData;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * Created by david on 3/22/2015.
 */
public class InMemoryWeatherDataStore implements IWeatherDataStore
{
  private ArrayList<WeatherData> weatherDataList;

  public InMemoryWeatherDataStore()
  {
    this.weatherDataList = new ArrayList<WeatherData>();
  }

  /**
   * Get the number of elements in the data store
   * @return the size
   */
  public int size()
  {
    return weatherDataList.size();
  }

  /**
   * UPSERTS the weather data to the data store.
   * This uses the capture date & time as a key, and will update a record if it exists,
   * or add a new record if it doesn't
   *
   * @param weatherData the weather data
   * @throws NullPointerException if weatherData is null
   */
  @Override
  public void addWeatherData(WeatherData weatherData) throws NullPointerException
  { //  make sure weatherData is not null
    Objects.requireNonNull(weatherData);

    //  the index if object exists
    int updateIndex = -1;

    //  do we have the item in the list. Need to do an int loop instead of iterator since we want the index
    for (int i = 0; i < weatherDataList.size(); ++i)
    {
      if(weatherDataList.get(i).getCaptureTime() == weatherData.getCaptureTime())
      {
        updateIndex = i;
        break;
      }
    }

    //  do the UPSERT to the memory list
    if(updateIndex >= 0)
    { //  update the item in the list
      weatherDataList.set(updateIndex, weatherData);
    }
    else
    { //  add the new element to the list
      weatherDataList.add(weatherData);
    }

    //  sort the list to correct the position of the new item
    //  we could just make a sorted list an insert in the right position, but since this class is really
    //  only be used for testing, I am cheating with a less efficient, but simpler model
    Collections.sort(weatherDataList);
  }

  /**
   * Gets the latest weather data item based on the capture date & time
   *
   * @return the weather data
   */
  @Override
  public WeatherData getCurrentWeatherData()
  { //  return null if nothing in the list
    if(weatherDataList.size() <= 0)
      return null;

    //  return the last element
    return weatherDataList.get(weatherDataList.size() - 1);
  }

  /**
   * Gets all weather data in the data store
   *
   * @return list of weather data objects
   */
  @Override
  public List<WeatherData> getAllWeatherData()
  { //  return a new collection of weather data items
    return new ArrayList<WeatherData>(weatherDataList);
  }

  /**
   * Removes all weather data objects from the database
   */
  @Override
  public void clearAll()
  {
    weatherDataList.clear();
  }
}
