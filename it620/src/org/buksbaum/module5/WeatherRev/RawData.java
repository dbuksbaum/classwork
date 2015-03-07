package org.buksbaum.module5.WeatherRev;

/**
 * Created by david on 3/7/2015.
 */
public class RawData {
  private double temperature;
  private double humidity;
  private double pressure;
  private double windSpeed;

  public RawData(){} //default ctor

  public void setValues(double temp, double hum, double pres, double wind){
    this.temperature = temp;
    this.humidity = hum;
    this.pressure = pres;
    this.windSpeed = wind;
  }

  public double getTemperature(){
    return temperature;
  }
  public double getHumidity(){
    return humidity;
  }
  public double getPressure(){
    return pressure;
  }
  public double getWindSpeed(){
    return windSpeed;
  }
}
