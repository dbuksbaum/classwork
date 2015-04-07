package org.buksbaum.module10.BankAccount;

import java.text.NumberFormat;

/**
 * Created by david on 4/7/2015.
 */
public abstract class Account {
  protected String name;
  protected double balance;
  protected double withDrawal;
  protected double deposit;

  public Account(){}; //default ctor
  public Account(String newName, double newBalance){
    this.name = newName;
    this.balance = newBalance;
  }

  abstract void calcInterest(int days); //to be implemented in the subclasses

  public void creditAccount(double amount){ // credit account
    balance += amount;
  }

  public void debitAccount(double amount){ // debit account
    balance -= amount;
  }
  // display name and balance amount
  public void displayAccount(){
    NumberFormat formatter = NumberFormat.getCurrencyInstance(); //currency format
    System.out.println("Account holder:" + name);
    System.out.println("Balance: " + formatter.format(balance));
  }
  // display only balance amount
  public void displayBalance(){
    NumberFormat formatter = NumberFormat.getCurrencyInstance();
    System.out.println("Balance: " + formatter.format(balance));
  }
}
