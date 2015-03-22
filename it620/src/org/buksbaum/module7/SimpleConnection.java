package org.buksbaum.module7;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.*;
import java.sql.DriverManager;


/**
 * Created by david on 3/21/2015.
 */
public class SimpleConnection {

  public static void main(String[] args) {
    try {
      // register driver
      Class.forName("com.mysql.jdbc.Driver").newInstance();

      // Establish a connection to a given database URL:
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost/test");//,"root","heathn1");

      //Create a statement object for sending SQL statements to the database
      Statement stmt = con.createStatement();

      // Execute SQL:
      stmt.execute("SELECT * FROM Customers");
      // get results from the executed SQL:
      ResultSet results = stmt.getResultSet();

      int rowCount = 0;

      ResultSetMetaData rsmd = results.getMetaData();
      int columnCount = rsmd.getColumnCount();

      // table header
      System.out.println("\t");
      for (int i = 0; i < columnCount; i++) {
        System.out.print("\t" + rsmd.getColumnLabel(i + 1) + "\t");
      }
      System.out.println("\n");

      // the data
      while (results.next()) {
        rowCount++;
        System.out.println("\n");
        for (int i = 0; i < columnCount; i++) {
          System.out.print("\t" + results.getString(i + 1) + "\t" );
        }
        System.out.println("\n");
      }

      // Close the connection:
      con.close();

    }
    catch(Exception e) {
      System.out.println(e);
    }

  }
}
