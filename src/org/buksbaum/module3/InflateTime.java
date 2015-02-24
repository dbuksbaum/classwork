package org.buksbaum.module3;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Calendar;

/**
 * Created by david on 2/24/2015.
 */
public class InflateTime
{
  public static void main(String [] args)
  {
    String filename = "time1.ser";
    if(args.length > 0)
    {
      filename = args[0];
    }
    PersistentTime time = null;
    FileInputStream fis = null;
    ObjectInputStream in = null;
    try
    {
      fis = new FileInputStream(filename);

/*To create an ObjectInputStream object, provide an existing InputStream object as the argument of the constructor.*/

      in = new ObjectInputStream(fis);
      time = (PersistentTime)in.readObject();
      in.close();
    }
    catch(IOException ex)
    {
      ex.printStackTrace();
    }
    catch(ClassNotFoundException ex)
    {
      ex.printStackTrace();
    }
    // print out restored time
    System.out.println("Flattened time: " + time.getTime());
    System.out.println();
    // print out the current time
    System.out.println("Current time: " + Calendar.getInstance().getTime());
  }
}
