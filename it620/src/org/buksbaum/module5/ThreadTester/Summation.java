package org.buksbaum.module5.ThreadTester;

/**
 * Created by david on 3/7/2015.
 */
class Summation extends Thread //throws InterruptedException
{
  public Summation() {  // default constructor
  }
  public Summation(int n) {
    upper = n;
  }

  public void run() {
    int sum = 0;

    if(upper > 0 ) {
      for( int i = 1; i <= upper; i++)
        sum += i;
    }

    System.out.println("The sum of " + upper + " is " + sum);
    resetFlag();
    try{
      //sleep(1000);
    }
    catch(Exception e){}
    resetFlag();
  }

  public int getFlag()
  {
    return flag;
  }

  public static void setFlag()

  {
    flag = 1;
  }
  public static void resetFlag(){
    flag = 0;
  }
  private int upper;

  private static int flag = 0;

} // end of summation class definition
