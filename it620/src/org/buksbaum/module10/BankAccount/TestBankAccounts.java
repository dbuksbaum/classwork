package org.buksbaum.module10.BankAccount;

/**
 * Created by david on 4/7/2015.
 */
public class TestBankAccounts {
  /**
   * @param args
   * Created by D. J. Norris 9/2012
   */
  public static void main(String[] args) {
    String name;
    double testBalance;

    name = "John Jones";
    testBalance = 1234.89;
    CheckingAccount chkAcct = new CheckingAccount(name,testBalance);
    chkAcct.displayAccount();
    chkAcct.calcInterest(34);
    System.out.println("Balance after interest added");
    chkAcct.displayBalance();
    System.out.println();

    name = "Mary Dow";
    testBalance = 4567.44;
    SavingsAccount savAcct = new SavingsAccount(name,testBalance);
    savAcct.displayAccount();
    savAcct.calcInterest(44);
    System.out.println("Balance after interest added");
    savAcct.displayBalance();
  }
}
