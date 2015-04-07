package org.buksbaum.module10.BankAccount;

/**
 * Created by david on 4/7/2015.
 */
public class SavingsAccount extends Account {

  public static double RATE = .02/12; // monthly rate
  public SavingsAccount(){} // default ctor

  public SavingsAccount(String newName, double newBalance){
    super(newName, newBalance); // call the base ctor
  }

  public void calcInterest(int days){ // this method must be implemented
    double interest;
    double factor;
    int x,y;
    x = days/30; // factor multiplier based on number of days
    y = days % 30;
    if (x >= 1) {
      factor = x + ((double)y)/30;
    }
    else {
      factor = ((double)y)/30;	// factor prorated for days < 30
    }
    interest = RATE * balance * factor;
    creditAccount(interest);
  }
}
