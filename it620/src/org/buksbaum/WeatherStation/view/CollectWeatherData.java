package org.buksbaum.WeatherStation.view;

import javax.swing.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class CollectWeatherData extends JDialog implements ICollectWeatherDataForm
{
  private static double temperature;
  private static double pressure;
  private static int humidity;
  private static int windSpeed;
  private static Boolean okPressed;
  private JPanel contentPane;
  private JButton buttonOK;
  private JButton buttonCancel;
  private JFormattedTextField temperatureText;
  private JFormattedTextField pressureText;
  private JFormattedTextField humidityText;
  private JFormattedTextField windSpeedText;
  private static final DecimalFormat FLOATING_FORMAT = (DecimalFormat) NumberFormat.getNumberInstance(Locale.getDefault());
  private static final DecimalFormat INTEGER_FORMAT = (DecimalFormat) NumberFormat.getNumberInstance(Locale.getDefault());

  public CollectWeatherData()
  {
    okPressed = false;
    setContentPane(contentPane);
    setModal(true);
    getRootPane().setDefaultButton(buttonOK);

    //  set up the formats for floating and integer text fields
    FLOATING_FORMAT.applyLocalizedPattern("#,##0.00");
    INTEGER_FORMAT.applyLocalizedPattern("#,##0");

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

  private void onOK()
  {
// add your code here
    okPressed = true;
    extractValues();
    dispose();
  }

  private void onCancel()
  {
// add your code here if necessary
    okPressed = false;
    dispose();
  }

  private void createUIComponents()
  { // TODO: place custom component creation code here
    temperatureText = new JFormattedTextField(FLOATING_FORMAT);
    pressureText = new JFormattedTextField(FLOATING_FORMAT);
    humidityText = new JFormattedTextField(INTEGER_FORMAT);
    windSpeedText  = new JFormattedTextField(INTEGER_FORMAT);
  }

  private void extractValues()
  {
    temperature = ((Number)temperatureText.getValue()).doubleValue();
    pressure = ((Number)pressureText.getValue()).doubleValue();
    humidity = ((Number)humidityText.getValue()).intValue();
    windSpeed = ((Number)windSpeedText.getValue()).intValue();
  }

  @Override
  public double getTemperature()
  {
    return temperature;
  }

  @Override
  public double getPressure()
  {
    return pressure;
  }

  @Override
  public int getHumidity()
  {
    return humidity;
  }

  @Override
  public int getWindSpeed()
  {
    return windSpeed;
  }

  @Override
  public Boolean showDialog()
  {
    CollectWeatherData dialog = new CollectWeatherData();
    dialog.setTitle("Enter Weather Data");
    //  set the start up location to use the system defaults
    dialog.setLocationByPlatform(true);
    dialog.pack();
    dialog.setVisible(true);

    return okPressed;
  }
}
