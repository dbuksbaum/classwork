package org.buksbaum.WeatherStation.storage;

import org.buksbaum.WeatherStation.model.TemperatureStatistics;
import org.buksbaum.WeatherStation.model.WeatherData;
import org.joda.time.DateTime;

import java.util.Collection;
import java.util.Vector;

/**
 * Created by david on 3/22/2015.
 * Interface for all weather data storage options
 */
public interface IWeatherDataStore
{
  /**
   * Get the number of elements in the data store
   * @return the size
   */
  public int size();

  /**
   * UPSERTS the weather data to the data store.
   * This uses the capture date & time as a key, and will update a record if it exists,
   * or add a new record if it doesn't
   * @param weatherData the weather data
   * @throws NullPointerException if weatherData is null
   */
  public void addWeatherData(WeatherData weatherData) throws NullPointerException;

  /**
   * Gets the latest weather data item based on the capture date & time
   * @return the weather data
   */
  public WeatherData getCurrentWeatherData();

  /**
   * Gets up to the last two pressure values, if they exist.
   * The current pressure value will be in index 0, and the previous will be in index 1
   * @return an array of double with 0, 1, or 2 values
   */
  public double[] getLastTwoPressureValues();

  public TemperatureStatistics getTemperatureStatistics();

  /**
   * Gets all weather data in the data store
   * @return list of weather data objects
   */
  public Collection<WeatherData> getAllWeatherData();
  //public List<WeatherData> getWeatherDataInRange(DateTime start, DateTime end);

  /**
   * Removes all weather data objects from the database
   */
  public void clearAll();
}
