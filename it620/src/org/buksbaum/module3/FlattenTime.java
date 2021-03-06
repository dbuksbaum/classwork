package org.buksbaum.module3;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * Created by david on 2/24/2015.
 * The FlattenTime class from the Data IO and Object Serialization Examples_Mod3 document
 */
public class FlattenTime
{
  /**
   * Main method that flattens time or serializes a PersistentTime object
   * @param args Command line arguments - non expected
   */
  public static void main(String [] args)
  {
    String filename = "time1.ser";
    if(args.length > 0)
    {
      filename = args[0];
    }
    PersistentTime time = new PersistentTime();
    FileOutputStream fos = null;
    ObjectOutputStream out = null;


    try
    {
      fos = new FileOutputStream(filename);

/*To create an ObjectOutputStream object, provide an existing OutputStream object as the argument of the constructor. */

      out = new ObjectOutputStream(fos);
      out.writeObject(time);
      out.close();
    }
    catch(IOException ex)
    {
      ex.printStackTrace();
    }
  }
}
