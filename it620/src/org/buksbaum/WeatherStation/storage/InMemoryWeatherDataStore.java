package org.buksbaum.WeatherStation.storage;

import org.buksbaum.WeatherStation.model.TemperatureStatistics;
import org.buksbaum.WeatherStation.model.WeatherData;
import org.buksbaum.module8.DinerMerger.*;

import java.util.*;
import java.util.Iterator;

/**
 * Created by david on 3/22/2015.
 * Concrete backing store using an ArrayList
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
   * Gets up to the last two pressure values, if they exist.
   * The current pressure value will be in index 0, and the previous will be in index 1
   *
   * @return an array of double with 0, 1, or 2 values
   */
  @Override
  public double[] getLastTwoPressureValues()
  {
    double[] results = null;

    //  get previous pressure values
    if(weatherDataList.size() >= 2)
    { //  we have 2 or more pressure values
      results = new double[2];
      results[0] = weatherDataList.get(0).getPressure();
      results[1] = weatherDataList.get(1).getPressure();
    }
    else if(weatherDataList.size() >= 1)
    { //  we only have one pressure value
      results = new double[1];
      results[0] = weatherDataList.get(0).getPressure();
    }

    return results;
  }

  /**
   * Gets the temperature statistics if they exist.
   * @return null if no statistics, or the temperature statistics
   */
  @Override
  public TemperatureStatistics getTemperatureStatistics()
  {
    double maximumTemperature = 0.0f;
    double minimumTemperature = 200.0f;
    double averageTemperature = 0.0f;
    double sumOfAllTemperatures = 0.0f;

    //  no data, so just leave! thats right - GET OUT!
    if(weatherDataList.size() <= 0)
      return null;

    //  loop through all items using the Iterator Pattern!!!
    for (Iterator<WeatherData> weatherDataIterator = weatherDataList.iterator(); weatherDataIterator.hasNext(); )
    { //  get the next result value
      WeatherData weatherData = weatherDataIterator.next();
      //  get the temperature
      double temp = weatherData.getTemperature();

      //  sum up the temp
      sumOfAllTemperatures += temp;

      //  check if its the new max
      if(temp > maximumTemperature)
        maximumTemperature = temp;
      //  check if its the new min
      if(temp < minimumTemperature)
        minimumTemperature = temp;
    }

    //  calculate the average
    averageTemperature = (sumOfAllTemperatures / weatherDataList.size());

    //  return the stats
    return new TemperatureStatistics(maximumTemperature, minimumTemperature, averageTemperature);
  }

  /**
   * Gets all weather data in the data store
   *
   * @return list of weather data objects
   */
  @Override
  public Collection<WeatherData> getAllWeatherData()
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
