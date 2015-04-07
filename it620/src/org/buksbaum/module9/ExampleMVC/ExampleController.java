package org.buksbaum.module9.ExampleMVC;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by david on 4/5/2015.
 */
public class ExampleController implements ActionListener
{ //  my connection string
  private static final String connectionString = "jdbc:mysql://localhost/test?user=root&password=";
  private ExampleModel model;
  private ExampleView view;

  public ExampleController(ExampleModel exampleModel, ExampleView exampleView) {
    this.model = exampleModel;
    this.view = exampleView;
  }

  public void actionPerformed(ActionEvent e) {
    Object source = e.getSource();
    if (source == view.getUpdateRef())
    {
      updateModel();
    }
    // i added this if check to see if the save button was pressed
    else if(source == view.getSaveRef())
    { //  the save button was pressed, call the save record method
      saveRecord();
    }
  }

  private void updateModel() {
    String firstName = null;
    String lastName = null;

    firstName = view.getFirstName();
    lastName = view.getLastName();
    model.updateModel(firstName, lastName, view.getCourse(), view
            .getId());
  }

  /**
   * Saves the current data out to the MySQL database
   */
  private void saveRecord()
  {
    try
    { // Establish a connection to a given database URL:
      Connection connection = DriverManager.getConnection(connectionString);

      //Create a statement object for sending SQL statements to the database
      Statement stmt = connection.createStatement();
      connection.setAutoCommit(true);

      //  build the insert statement
      StringBuilder sql = new StringBuilder();
      sql.append("REPLACE INTO students (first_name, last_name, course, student_id) VALUES (");
      //  first name
      sql.append(String.format("\'%s\', ", view.getFirstName()));
      //  last name
      sql.append(String.format("\'%s\', ", view.getLastName()));
      //  course
      sql.append(String.format("\'%s\', ", view.getCourse()));
      //  student id
      sql.append(String.format("\'%s\');", view.getId()));

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
}

