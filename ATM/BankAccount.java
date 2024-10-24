package ATM;

import java.time.Instant;
import java.util.*;
import java.text.*;

public class BankAccount {
  static private int MAX_PASSWORD_LENGTH = 5;

  private int acctNum;
  private double balance;
  private String fName;
  private String lName;
  private String pswd;
  private String log;

  BankAccount() {
    acctNum = genAcctNum();
    balance = 0;
    fName = null;
    lName = null;
    pswd = genPswd();
    log = "";
  }

  BankAccount(String firstName, String lastName) {
    acctNum = genAcctNum();
    balance = 0;
    fName = firstName;
    lName = lastName;
    pswd = genPswd();
    log = "";
  }

  BankAccount(int accountNumber, double accountBalance, String firstName, String lastName, String password,
      String defaultLog) {
    acctNum = accountNumber;
    balance = accountBalance;
    fName = firstName;
    lName = lastName;
    pswd = password;
    log = defaultLog;
  }

  boolean deposit(double amount) {
    if (amount > 0) {
      balance += amount;
      log += genTimestamp() + " Deposit Successful [$" + String.format("%.2f", amount) + "]";

      return true;
    }
    return false;
  }

  boolean withdraw (double) { }

  boolean transferTo (double, BankAccount) { }

  boolean checkPswd (String) { }

  boolean resetPswd (String, String) { }

  void resetAcctNum() {
  }

  void setFName (String) { }

  void setLName (String) { }

  String getFName() {
  }

  String getLName() {
  }

  String getLog() {
  }

  double getBalance() {
  }

  int getAcctNum() {
  }

  private int genAcctNum (int) { }

  private String genPswd (int) { }

  private String genTimestamp() {
    String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
    return timeStamp;
  }

  void display() {
  }

  public static void main(String[] args) {
  }
}
