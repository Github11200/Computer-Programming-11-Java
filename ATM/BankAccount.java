import java.util.*;
import java.text.*;

/*
 * CERTAIN METHODS AND VARIABLES ARE PUBLIC WHEN THEY SHOULDN'T BE FOR TESTING PURPOSES SUCH AS pswd and all of the generator functions 
*/

public class BankAccount {
  static int MAX_PASSWORD_LENGTH = 5;

  int acctNum;
  double balance;
  String fName;
  String lName;
  String pswd;
  String log;

  /***************************** Constructors *****************************/
  BankAccount() {
    acctNum = genAcctNum(5);
    balance = 0;
    fName = null;
    lName = null;
    pswd = genPswd(10);
    log = "";
  }

  BankAccount(String firstName, String lastName) {
    acctNum = genAcctNum(5);
    balance = 0;
    fName = firstName;
    lName = lastName;
    pswd = genPswd(10);
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

  /**********************************************************************/

  /***************************** Transactions *****************************/
  boolean deposit(double amount) {
    if (amount >= 0) {
      balance += amount;
      log += "\t" + genTimestamp() + "  Deposit Successful [$" + String.format("%.2f", amount) + "]\n";

      return true;
    }
    return false;
  }

  boolean withdraw(double amount) {
    if (amount >= 0 && balance >= amount) {
      balance -= amount;
      log += "\t" + genTimestamp() + "  Withdrawal Successful [$" + String.format("%.2f", amount) + "]\n";

      return true;
    }
    return false;
  }

  boolean transferTo(double amount, BankAccount targetAccount) {
    if (amount >= 0 && withdraw(amount)) {
      targetAccount.deposit(amount);
      log += "\t" + genTimestamp() + "  Transfer [$" + amount + " to account " + targetAccount.acctNum + "]\n";
      log += "\t" + genTimestamp() + "  Transfer [$" + amount + " received from account " + acctNum + "]\n";
      return true;
    }
    log += "\t" + genTimestamp() + "  Transfer Failed [$" + amount + " to account " + targetAccount.acctNum + "]\n";
    return false;
  }

  /**********************************************************************/

  /***************************** Setters *****************************/
  boolean checkPswd(String password) {
    return password.equals(pswd);
  }

  boolean resetPswd(String currentPassword, String newPassword) {
    if (checkPswd(currentPassword)) {
      pswd = newPassword;
      log += "\t" + genTimestamp() + "  Password Successfully Changed!\n";

      return true;
    }
    log += "\t" + genTimestamp() + "  Reset Password Failed!\n";
    return false;
  }

  void resetAcctNum() {
    acctNum = genAcctNum(5);
  }

  void setFName(String firstName) {
    fName = firstName;
  }

  void setLName(String lastName) {
    lName = lastName;
  }

  /*****************************************************************/

  /***************************** Getters *****************************/
  String getFName() {
    return fName;
  }

  String getLName() {
    return lName;
  }

  String getLog() {
    return log;
  }

  double getBalance() {
    return balance;
  }

  int getAcctNum() {
    return acctNum;
  }

  /*****************************************************************/

  /***************************** Generators *****************************/
  int genAcctNum(int length) {
    int min = (int) Math.pow(10, length - 1);
    int max = (int) Math.pow(10, length);
    return (int) (min + (Math.random() * (max - min)));
  }

  String genPswd(int length) {
    String[] strArray = { "a", "b", "c", "d", "e", "f", "g", "h", "i",
        "j", "k", "l", "m", "n", "o", "p", "q", "r",
        "s", "t", "u", "v", "w", "x", "y", "z", "A",
        "B", "C", "D", "E", "F", "G", "H", "I", "J",
        "K", "L", "M", "N", "O", "P", "Q", "R", "S",
        "T", "U", "V", "W", "X", "Y", "Z", "1", "2",
        "3", "4", "5", "6", "7", "8", "9", "0" };

    if (length > 0) {
      Random randomNumberGenerator = new Random();
      String password = "";
      while (password.length() != length) {
        password += strArray[randomNumberGenerator.nextInt(26)];
        if (password.length() == length)
          break;
        password += strArray[randomNumberGenerator.nextInt(26) + 26];
        if (password.length() == length)
          break;
        password += strArray[randomNumberGenerator.nextInt(9) + 52];
      }
      return password;
    }
    return "";
  }

  String genTimestamp() {
    String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
    return timeStamp;
  }

  /********************************************************************/

  void display() {
    System.out.println("Account Number: " + acctNum);
    System.out.println("Balance: " + balance);
    System.out.println("First name: " + fName);
    System.out.println("Last name: " + lName);
    System.out.println("Password: " + pswd);
    System.out.println("LOG:\n" + log);
  }

  public static void main(String[] args) {
  }
}