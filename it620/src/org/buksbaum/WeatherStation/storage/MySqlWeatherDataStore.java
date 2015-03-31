package org.buksbaum.WeatherStation.storage;

import org.buksbaum.WeatherStation.model.WeatherData;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by david on 3/22/2015.
 * Concrete backing store using MySQL
 */
public class MySqlWeatherDataStore implements IWeatherDataStore
{
  private final String connectionString;
  private final DateTimeFormatter dateTimeFormatter = ISODateTimeFormat.dateTime();

  public MySqlWeatherDataStore() throws SQLException
  {
    connectionString = "jdbc:mysql://localhost/finalweatherdata?user=root&password=";
  }

  /**
   * Get the number of elements in the data store
   *
   * @return the size
   */
  @Override
  public int size()
  {
    int recordCount = 0;

    try
    { // Establish a connection to a given database URL:
      Connection connection = DriverManager.getConnection(connectionString);

      //Create a statement object for sending SQL statements to the database
      Statement stmt = connection.createStatement();

      // Execute SQL and get results from the executed SQL:
      ResultSet results = stmt.executeQuery("SELECT count(*) FROM weather_data;");

      //  move to the first result
      results.next();

      //  get the count
      recordCount = results.getInt(1);

      //  close the connection
      connection.close();
    }
    catch(SQLException exception)
    { //  if we fail, just return 0
      recordCount = 0;
      exception.printStackTrace();
    }

    return recordCount;
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

    try
    { // Establish a connection to a given database URL:
      Connection connection = DriverManager.getConnection(connectionString);

      //Create a statement object for sending SQL statements to the database
      Statement stmt = connection.createStatement();
      connection.setAutoCommit(true);

      //  build the insert statement
      StringBuilder sql = new StringBuilder();
      sql.append("REPLACE INTO weather_data (capture_time, temperature, pressure, humidity, wind_speed) VALUES (");
      //  capture time
      sql.append(String.format("\'%s\', ", weatherData.getCaptureTime().toString(dateTimeFormatter)));
      //  temperature
      sql.append(String.format("%f, ", weatherData.getTemperature()));
      //  pressure
      sql.append(String.format("%f, ", weatherData.getPressure()));
      //  humidity
      sql.append(String.format("%d, ", weatherData.getHumidity()));
      //  wind speed
      sql.append(String.format("%d);", weatherData.getWindSpeed()));

      // Execute SQL:
      int affectedRows = stmt.executeUpdate(sql.toString());

      //  close the connection
      connection.close();
    }
    catch(SQLException exception)
    { //  if we fail, just return
      exception.printStackTrace();
    }
  }

  /**
   * Gets the latest weather data item based on the capture date & time
   *
   * @return the weather data
   */
  @Override
  public WeatherData getCurrentWeatherData()
  {
    try
    { // Establish a connection to a given database URL:
      Connection connection = DriverManager.getConnection(connectionString);

      //Create a statement object for sending SQL statements to the database
      Statement stmt = connection.createStatement();

      // Execute SQL and get results from the executed SQL:
      ResultSet results = stmt.executeQuery("SELECT capture_time, temperature, pressure, humidity, wind_speed FROM finalweatherdata.weather_data WHERE capture_time=(SELECT MAX(capture_time) FROM weather_data);");

      //  move to the first result
      if(!results.next())
        return null; // no current data

      //  get the weather data object from the row
      WeatherData weatherData = convertDataRowToWeatherData(results);

      //  close the connection
      connection.close();

      //  return the result
      return weatherData;
    }
    catch(SQLException exception)
    { //  if we fail, just return
      exception.printStackTrace();
      return null;
    }
  }

  /**
   * Gets all weather data in the data store
   *
   * @return list of weather data objects
   */
  @Override
  public List<WeatherData> getAllWeatherData()
  {
    ArrayList<WeatherData> weatherDataArrayList = new ArrayList<WeatherData>();

    try
    { // Establish a connection to a given database URL:
      Connection connection = DriverManager.getConnection(connectionString);

      //Create a statement object for sending SQL statements to the database
      Statement stmt = connection.createStatement();

      // Execute SQL:
      stmt.execute("SELECT capture_time, temperature, pressure, humidity, wind_speed FROM finalweatherdata.weather_data ORDER BY capture_time ASC;");

      // get results from the executed SQL:
      ResultSet results = stmt.getResultSet();

      //  loop through rows
      while(results.next())
      { //  convert the row
        WeatherData weatherData = convertDataRowToWeatherData(results);

        //  skip the nulls, should never have any - but no reason to risk it
        if(weatherData != null)
          weatherDataArrayList.add(weatherData);
      }

      //  close the connection
      connection.close();

      return weatherDataArrayList;
    }
    catch(SQLException exception)
    { //  if we fail, just return
      exception.printStackTrace();

      //  in case of error, we clear the loaded results for consistency
      weatherDataArrayList.clear();
    }

    return weatherDataArrayList;
  }

  /**
   * Removes all weather data objects from the database
   */
  @Override
  public void clearAll()
  {
    try
    { // Establish a connection to a given database URL:
      Connection connection = DriverManager.getConnection(connectionString);

      //Create a statement object for sending SQL statements to the database
      Statement stmt = connection.createStatement();

      // Execute SQL to delete all rows
      //stmt.executeUpdate("TRUNCATE TABLE weather_data;");
      int affectedRows = stmt.executeUpdate("DELETE FROM weather_data;");

      //  close the connection
      connection.close();
    }
    catch(SQLException exception)
    { //  if we fail, just return
      exception.printStackTrace();
    }
  }

  /**
   * Convert the jdbc result row into a weather data object
   * @param results the jdbc result row
   * @return the weather data object
   * @throws SQLException thrown when something is wrong with the result row
   */
  private WeatherData convertDataRowToWeatherData(ResultSet results) throws SQLException
  {//  construct the result from the db results
    WeatherData weatherData = new WeatherData();
    //  get the capture time
    weatherData.setCaptureTime(dateTimeFormatter.parseDateTime(results.getString(1)));
    //  get the temperature
    weatherData.setTemperature(results.getDouble(2));
    //  get the pressure
    weatherData.setPressure(results.getDouble(3));
    //  get the humidity
    weatherData.setHumidity(results.getInt(4));
    //  get the wind speed
    weatherData.setWindSpeed(results.getInt(5));
    return weatherData;
  }
}
