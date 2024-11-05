package ATM;

public class BankAccountManager {
  private int numAccts;
  BankAccount[] acctArray;

  private static final int MAX_ACCOUNT_NUM = 100;

  BankAccountManager() {
    numAccts = 0;
    acctArray = new BankAccount[MAX_ACCOUNT_NUM];
  }

  int findFirstEmpty() {
    for (int i = 0; i < acctArray.length; ++i)
      if (acctArray[i] == null)
        return i;
    return -1;
  }

  boolean isAcctNumUnique(int accountNumber) {
    for (int i = 0; i < acctArray.length; ++i)
      if (acctArray[i] != null && acctArray[i].getAcctNum() == accountNumber)
        return false;
    return true;
  }

  boolean addAcct(BankAccount account) {
    int index = findFirstEmpty();
    if (index != -1) {
      while (!isAcctNumUnique(account.getAcctNum()))
        account.resetAcctNum();
      acctArray[index] = account;
      ++numAccts;
      return true;
    }
    return false;
  }

  boolean rmAcct(int accountNumber) {
    for (int i = 0; i < acctArray.length; ++i) {
      if (acctArray[i] != null && acctArray[i].getAcctNum() == accountNumber) {
        acctArray[i] = null;
        --numAccts;
        return true;
      }
    }
    return false;
  }

  BankAccount getAccount(int accountNumber) {
    for (int i = 0; i < acctArray.length; ++i)
      if (acctArray[i] != null && acctArray[i].getAcctNum() == accountNumber)
        return acctArray[i];
    return null;
  }

  void depositIntoAll(double amount) {
    for (int i = 0; i < acctArray.length; ++i)
      if (acctArray[i] != null)
        acctArray[i].deposit(amount);
  }

  void withdrawFromAll(double amount) {
    for (int i = 0; i < acctArray.length; ++i)
      if (acctArray[i] != null)
        acctArray[i].withdraw(amount);
  }

  void clearAccts() {
    for (int i = 0; i < acctArray.length; ++i)
      acctArray[i] = null;
    numAccts = 0;
  }

  void display() {
    System.out.println("NUMBER OF ACCOUNTS: " + acctArray.length);
    System.out.println("ACCOUNTS:");
    for (int i = 0; i < acctArray.length; ++i)
      if (acctArray[i] != null)
        System.out.println("   " + acctArray[i]);
  }
}