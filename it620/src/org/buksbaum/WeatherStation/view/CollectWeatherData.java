package org.buksbaum.WeatherStation.view;

import javax.swing.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

/**
 * Collect Weather Data is a dialog that implements the ICollectWeatherDataForm interface.
 * This dialog collects weather data from the user.
 */
public class CollectWeatherData extends JDialog implements ICollectWeatherDataForm
{
  //  fields
  private double temperature;
  private double pressure;
  private int humidity;
  private int windSpeed;
  private Boolean okPressed;
  private JPanel contentPane;
  private JButton buttonOK;
  private JButton buttonCancel;
  private JFormattedTextField temperatureText;
  private JFormattedTextField pressureText;
  private JFormattedTextField humidityText;
  private JFormattedTextField windSpeedText;
  //  constants that are used for formatting our JFormattedTextFields
  private static final DecimalFormat FLOATING_FORMAT = (DecimalFormat) NumberFormat.getNumberInstance(Locale.getDefault());
  private static final DecimalFormat INTEGER_FORMAT = (DecimalFormat) NumberFormat.getNumberInstance(Locale.getDefault());

  /**
   * Constructs the CollectWeatherData instance.
   */
  public CollectWeatherData()
  { //  sets some initial state information
    okPressed = false;
    setContentPane(contentPane);
    setModal(true);
    getRootPane().setDefaultButton(buttonOK);

    //  set the dialog title
    this.setTitle("Enter Weather Data");
    //  set the start up location to use the system defaults
    this.setLocationByPlatform(true);

    //  set up the formats for floating and integer text fields
    FLOATING_FORMAT.applyLocalizedPattern("#,##0.00");
    INTEGER_FORMAT.applyLocalizedPattern("#,##0");

    //  generated code to wire up the listeners for the command
    buttonOK.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e) {onOK();}
    });

    buttonCancel.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e) {onCancel();}
    });

// call onCancel() when cross is clicked
    setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
    addWindowListener(new WindowAdapter()
    {
      public void windowClosing(WindowEvent e)
      {
        onCancel();
      }
    });

// call onCancel() on ESCAPE
    contentPane.registerKeyboardAction(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        onCancel();
      }
    }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
  }

  /**
   * Called when the user clicks OK
   */
  private void onOK()
  {
// add your code here
    okPressed = true;
    extractValues();
    dispose();
  }

  /**
   * Called when the user clicks CANCEL or hits ESCAPE or the window is CLOSED
   */
  private void onCancel()
  {
// add your code here if necessary
    okPressed = false;
    dispose();
  }

  /**
   * Custom UI creation logic as part of the framework.
   * I use it to construct the JFormattedTextFields with the appropriate formatting logic
   */
  private void createUIComponents()
  { // TODO: place custom component creation code here1
    temperatureText = new JFormattedTextField(FLOATING_FORMAT);
    pressureText = new JFormattedTextField(FLOATING_FORMAT);
    humidityText = new JFormattedTextField(INTEGER_FORMAT);
    windSpeedText  = new JFormattedTextField(INTEGER_FORMAT);
  }

  /**
   * Extract the values from the text fields and store them
   */
  private void extractValues()
  {
    temperature = ((Number)temperatureText.getValue()).doubleValue();
    pressure = ((Number)pressureText.getValue()).doubleValue();
    humidity = ((Number)humidityText.getValue()).intValue();
    windSpeed = ((Number)windSpeedText.getValue()).intValue();
  }

  /**
   * Gets the temperature entered.
   * This value is only useful if the result of showDialog() is true.
   * @return the temperature
   */
  @Override
  public double getTemperature()
  {
    return temperature;
  }

  /**
   * Get the pressure entered.
   * This value is only useful if the result of showDialog() is true.
   * @return the pressure
   */
  @Override
  public double getPressure()
  {
    return pressure;
  }

  /**
   * Gets the humidity entered.
   * This value is only useful if the result of showDialog() is true.
   * @return the humidity
   */
  @Override
  public int getHumidity()
  {
    return humidity;
  }

  /**
   * Gets the wind speed entered.
   * This value is only useful if the result of showDialog() is true.
   * @return the wind speed
   */
  @Override
  public int getWindSpeed()
  {
    return windSpeed;
  }

  /**
   * Shows the collect weather data dialog and returns if the use pressed OK or CANCEL.
   * The data value getters are only meaningful if the result is OK.
   * @return true if the user pressed OK, false if the user pressed CANCEL.
   */
  @Override
  public Boolean showDialog()
  {
    //  pack the luggage
    this.pack();

    //  show the dialog!
    this.setVisible(true);

    //  let the called know what happened
    return okPressed;
  }
}
