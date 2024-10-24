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
      log += genTimestamp() + " Deposit Successful [$" + String.format("%.2f", amount) + "]\n";
      return true;
    }
    return false;
  }

  boolean withdraw(double amount) {
    if (amount > 0 && (balance - amount) > 0) {
      balance -= amount;
      log += genTimestamp() + " Withdrawal Successful [$" + String.format("%.2f", amount) + "]\n";
      return true;
    }
    return false;
  }

  boolean transferTo (double, BankAccount) { }

  boolean checkPswd(String password) {
    return password.equals(pswd);
  }

  boolean resetPswd(String currentPassword, String newPassword) {
    if (checkPswd(currentPassword)) {
      pswd = newPassword;
      log += genTimestamp() + " Password Successfully Changed!";
      return true;
    }
    log += genTimestamp() + " Reset Password Failed!";
    return false;
  }

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

  private int genAcctNum(int length) {
    Random randomNumberGenerator = new Random();
    return randomNumberGenerator.nextInt(length) + 1;
  }

  private String genPswd(int length) {
    if (length == 0)
      return "";

    String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
    Random randomNumberGenerator = new Random();

    String newPassword = "";
    int charactersSection = 0;
    while (newPassword.length() < length) {
      int randomNumber = randomNumberGenerator.nextInt(charactersSection < 52 ? 26 : 10) + charactersSection;

      newPassword += characters.charAt(randomNumber);

      if (charactersSection == 0)
        charactersSection += 26;
      else if (charactersSection == 26)
        charactersSection += 10;
      else
        charactersSection = 0;
    }

    return newPassword;
  }

  private String genTimestamp() {
    String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
    return timeStamp;
  }

  void display() {
  }

  public static void main(String[] args) {
  }
}
