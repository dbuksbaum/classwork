package org.buksbaum.module5.ThreadTester;

/**
 * Created by david on 3/7/2015.
 */
public class ThreadTester
{
  static Summation thrd;
  public static void main(String[] args)
  {
    if(args.length > 0)
    {
      if(Integer.parseInt(args[0]) < 0)
        System.err.println(args[0] + " must be >= 0.");
      else
      {
        thrd = new Summation(Integer.parseInt(args[0]));
        thrd.start();
        thrd.setFlag();
        // the start method is a member of the Thread class.  When called
      }  // it in turn calls the object's run method IAW priority.
    }
    else
      System.out.println("Usage:  Summation <integer value>");

    try
    { //  commented out sleep in order to see the effect of no thread synchronization
      //thrd.sleep(1000);
    }
    catch(Exception e){}
    thrd.resetFlag();
    Summation test = new Summation(6);
    if(thrd.getFlag() == 0){test.start();}
    // start another thread

    Summation test1 = new Summation(8);
    if(test.getFlag() == 0){test1.start();}
    // yet start another thread

    DivisionTest dt = new DivisionTest();  //not a threaded object

    dt.run(); //a simple call to the DivisionTest object dt
    System.out.println("End of ThreadTester");
  }
}

