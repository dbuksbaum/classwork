package org.buksbaum.WeatherStation.model;

import org.joda.time.DateTime;

/**
 * Created by david on 3/22/2015.
 * WeatherData class is the model of the raw data values used in weather data calculations
 */
public class WeatherData implements Comparable<WeatherData>
{
  //  fields
  //  the creation date & time of this weather data block - think Key
  private DateTime captureTime;
  private double temperature;
  private double pressure;
  private int humidity;
  private int windSpeed;

  //  constructors
  /**
   * Constructs a WeatherData class using all defaults at the current date & time
   */
  public WeatherData()
  {
    this(0.0, 0.0, 0, 0);
  }

  /**
   * Constructs a WeatherData class using specified values at the current date & time
   * @param temperature the temperature
   * @param pressure the air pressure
   * @param humidity the humidity
   * @param windSpeed the wind speed
   */
  public WeatherData(double temperature, double pressure, int humidity, int windSpeed)
  {
    this(DateTime.now(), temperature, pressure, humidity, windSpeed);
  }

  /**
   * Constructs a WeatherData class using specified values at the specified date & time
   * @param captureTime the time & date of the data capture
   * @param temperature the temperature
   * @param pressure the air pressure
   * @param humidity the humidity
   * @param windSpeed the wind speed
   */
  public WeatherData(DateTime captureTime, double temperature, double pressure, int humidity, int windSpeed)
  {
    this.captureTime = captureTime;
    this.temperature = temperature;
    this.pressure = pressure;
    this.humidity = humidity;
    this.windSpeed = windSpeed;
  }

  //  property accessors

  /**
   * Gets the temperature captured
   * @return the temperature
   */
  public double getTemperature()
  {
    return temperature;
  }

  /**
   * Sets the capture temperature
   * @param temperature the temperature
   */
  public void setTemperature(double temperature)
  {
    this.temperature = temperature;
  }

  /**
   * Gets the pressure captured
   * @return the pressure
   */
  public double getPressure()
  {
    return pressure;
  }

  /**
   * Sets the capture pressure
   * @param pressure the pressure
   */
  public void setPressure(double pressure)
  {
    this.pressure = pressure;
  }

  /**
   * Gets the captured humidity
   * @return the humidity
   */
  public int getHumidity()
  {
    return humidity;
  }

  /**
   * Sets the capture humidity
   * @param humidity the humidity
   */
  public void setHumidity(int humidity)
  {
    this.humidity = humidity;
  }

  /**
   * Gets the captured wind speed
   * @return the wind speed
   */
  public int getWindSpeed()
  {
    return windSpeed;
  }

  /**
   * Sets the capture wind speed
   * @param windSpeed the wind speed
   */
  public void setWindSpeed(int windSpeed)
  {
    this.windSpeed = windSpeed;
  }

  /**
   * Gets the date & time of the captured data sample
   * @return the date & time
   */
  public DateTime getCaptureTime()
  {
    return captureTime;
  }

  /**
   * Sets the date & time for this captured sample
   * @param captureTime the date & time
   */
  public void setCaptureTime(DateTime captureTime)
  {
    this.captureTime = captureTime;
  }

  /**
   * Compares this object with the specified object for order.  Returns a
   * negative integer, zero, or a positive integer as this object is less
   * than, equal to, or greater than the specified object.
   * <p>
   * <p>The implementor must ensure <tt>sgn(x.compareTo(y)) ==
   * -sgn(y.compareTo(x))</tt> for all <tt>x</tt> and <tt>y</tt>.  (This
   * implies that <tt>x.compareTo(y)</tt> must throw an exception iff
   * <tt>y.compareTo(x)</tt> throws an exception.)
   * <p>
   * <p>The implementor must also ensure that the relation is transitive:
   * <tt>(x.compareTo(y)&gt;0 &amp;&amp; y.compareTo(z)&gt;0)</tt> implies
   * <tt>x.compareTo(z)&gt;0</tt>.
   * <p>
   * <p>Finally, the implementor must ensure that <tt>x.compareTo(y)==0</tt>
   * implies that <tt>sgn(x.compareTo(z)) == sgn(y.compareTo(z))</tt>, for
   * all <tt>z</tt>.
   * <p>
   * <p>It is strongly recommended, but <i>not</i> strictly required that
   * <tt>(x.compareTo(y)==0) == (x.equals(y))</tt>.  Generally speaking, any
   * class that implements the <tt>Comparable</tt> interface and violates
   * this condition should clearly indicate this fact.  The recommended
   * language is "Note: this class has a natural ordering that is
   * inconsistent with equals."
   * <p>
   * <p>In the foregoing description, the notation
   * <tt>sgn(</tt><i>expression</i><tt>)</tt> designates the mathematical
   * <i>signum</i> function, which is defined to return one of <tt>-1</tt>,
   * <tt>0</tt>, or <tt>1</tt> according to whether the value of
   * <i>expression</i> is negative, zero or positive.
   *
   * @param o the object to be compared.
   * @return a negative integer, zero, or a positive integer as this object
   * is less than, equal to, or greater than the specified object.
   * @throws NullPointerException if the specified object is null
   * @throws ClassCastException   if the specified object's type prevents it
   *                              from being compared to this object.
   */
  @Override
  public int compareTo(WeatherData o)
  {
    if(o == null)
      return 1; //  non-null this > null other

    if((this.captureTime == null) && (o.captureTime == null))
      return 0;  //  null this.capture time == null other.captureTime

    if((this.captureTime == null) && (o.captureTime != null))
      return -1;  //  null this.capture time < non-null other.captureTime

    if((this.captureTime != null) && (o.captureTime == null))
      return 1;  //  non-null this.capture time > null other.captureTime

    //  excluded all null conditions, so now actually compare the results
    return getCaptureTime().compareTo(o.getCaptureTime());
  }
}
