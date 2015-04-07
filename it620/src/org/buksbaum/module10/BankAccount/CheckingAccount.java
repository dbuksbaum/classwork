package org.buksbaum.module10.BankAccount;

/**
 * Created by david on 4/7/2015.
 */
public class CheckingAccount extends Account {
  public static double RATE = .01/12; // monthly rate
  public CheckingAccount(){} // default ctor

  public CheckingAccount(String newName, double newBalance){
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
      factor = 0;	// factor is 0 if days < 30
    }
    interest = RATE * balance * factor;
    creditAccount(interest);
  }
}
