package org.buksbaum.module9.ExampleMVC;

import org.buksbaum.WeatherStation.model.WeatherData;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;

/**
 * Created by david on 4/5/2015.
 *
 * Given how much intimate knowledge is shared between views, models, and controllers in this example,
 * I chose to create a new controller for the ExampleView
 */
public class ExampleDisplayController implements ActionListener
{
  private static final String connectionString = "jdbc:mysql://localhost/test?user=root&password=";
  private ExampleModel model;
  private ExampleDisplayView view;

  /**
   * Construct our controller with a model and view
   * @param model the model
   * @param view the view
   */
  public ExampleDisplayController(ExampleModel model, ExampleDisplayView view)
  {
    this.model = model;
    this.view = view;
  }

  /**
   * The listener for events.
   * @param e the event
   */
  public void actionPerformed(ActionEvent e) {
    Object source = e.getSource();
    if (source == view.getLoadRef())
    {
      loadAllRecords();
    }
  }

  /**
   * Load all records from the database and tell the view about it
   */
  private void loadAllRecords()
  {
    ArrayList<String> studentsArrayList = new ArrayList<String>();

    try
    { // Establish a connection to a given database URL:
      Connection connection = DriverManager.getConnection(connectionString);

      //Create a statement object for sending SQL statements to the database
      Statement stmt = connection.createStatement();

      // Execute SQL:
      stmt.execute("SELECT first_name, last_name, course, student_id FROM test.students;");

      // get results from the executed SQL:
      ResultSet results = stmt.getResultSet();

      //  loop through rows
      while(results.next())
      { //  convert the row

        String student = String.format("Student First Name=%s Last Name=%s Course=%s StudentID=%s", results.getString(1), results.getString(2), results.getString(3), results.getString(4));
        studentsArrayList.add(student);
      }

      //  close the connection
      connection.close();

      view.setHistoryList(studentsArrayList.toArray(new String[studentsArrayList.size()]));
    }
    catch(SQLException exception)
    { //  if we fail, just return
      exception.printStackTrace();
    }
  }
}
