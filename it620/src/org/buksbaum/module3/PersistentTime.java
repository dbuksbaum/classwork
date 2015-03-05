package org.buksbaum.module3;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by david on 2/24/2015.
 * The PersistentTime class from the Data IO and Object Serialization Examples_Mod3 document
 */
public class PersistentTime implements Serializable
{
  private Date time;
  public PersistentTime()
  {
    time = Calendar.getInstance().getTime();
  }
  public Date getTime()
  {
    return time;
  }
}

