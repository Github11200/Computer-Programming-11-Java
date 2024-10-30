package ATM;

public class BankAccountTesting {
  static private String passedOrFailedString(boolean result) {
    return result ? "PASSED!" : "FAILED!";
  }

  static String equals(String a, String b) {
    return passedOrFailedString(a.equals(b));
  }

  static String equals(int a, int b) {
    return passedOrFailedString(a == b);
  }

  static String equals(double a, double b) {
    return passedOrFailedString(a == b);
  }

  static String equals(float a, float b) {
    return passedOrFailedString(a == b);
  }

  static String equals(char a, char b) {
    return passedOrFailedString(a == b);
  }

  static String equals(Object a, Object b) {
    return passedOrFailedString(a.equals(b));
  }

  static String notEquals(String a, String b) {
    return passedOrFailedString(!a.equals(b));
  }

  static String notEquals(int a, int b) {
    return passedOrFailedString(a != b);
  }

  static String notEquals(double a, double b) {
    return passedOrFailedString(a != b);
  }

  static String notEquals(float a, float b) {
    return passedOrFailedString(a != b);
  }

  static String notEquals(char a, char b) {
    return passedOrFailedString(a != b);
  }

  static String notEquals(Object a, Object b) {
    return passedOrFailedString(!a.equals(b));
  }

  public static void main(String[] args) {
    BankAccount testingAccount1 = new BankAccount();
    BankAccount targetAccountForTransaction = new BankAccount();

    System.out.println("TESTING GETTERS:");
    System.out.println("\tAccount number: " + testingAccount1.getAcctNum());
    System.out.println("\tFirst name: " + testingAccount1.getFName());
    System.out.println("\tLast name: " + testingAccount1.getLName());
    System.out.println("\tBalance: " + testingAccount1.getBalance());
    System.out.println("\tLog: " + testingAccount1.getLog());

    System.out.println("\nTESTING SETTERS:");
    testingAccount1.setFName("First name");
    System.out.println("\tChanged first name: " + equals(testingAccount1.getFName(), "First name"));
    testingAccount1.setFName("Last name");
    System.out.println("\tChanged last name: " + equals(testingAccount1.getFName(), "Last name"));
    int previousAccountNumber = testingAccount1.getAcctNum();
    testingAccount1.resetAcctNum();
    System.out.println("\tResetting account number: " + notEquals(testingAccount1.getAcctNum(), previousAccountNumber));
    System.out.println("\tChecking password wrong way: " + passedOrFailedString(!testingAccount1.checkPswd("")));
    testingAccount1.resetPswd(testingAccount1.pswd, "password");
    System.out.println("\tResetting password: " + equals(testingAccount1.pswd, "password"));

    System.out.println("\nTESTING GENERATORS:");
    System.out.println("\tGenerated account number: " + testingAccount1.genAcctNum(5));
    System.out.println(
        "\tLength of account number equals 5: " + equals(String.valueOf(testingAccount1.genAcctNum(5)).length(), 5));
    System.out.println("\tGenerated password: " + testingAccount1.genPswd(10));
    System.out.println("\tLength of password equals 10: " + equals(testingAccount1.genPswd(10).length(), 10));
    System.out.println("\tTesting timestamp generation: " + testingAccount1.genTimestamp());

    System.out.println("\nTESTING TRANSACTIONS:");
    testingAccount1.deposit(100);
    System.out.println("\tDepositing $100.00: " + equals(testingAccount1.getBalance(), 100));
    testingAccount1.deposit(-100);
    System.out.println("\tDepositing invalid amount: " + equals(testingAccount1.getBalance(), 100)); // Balance should
                                                                                                     // still stay the
                                                                                                     // same
    testingAccount1.withdraw(50);
    System.out.println("\tWithdrawing $50.00: " + equals(testingAccount1.getBalance(), 50));
    testingAccount1.withdraw(100);
    System.out.println("\tWithdrawing too much: " + equals(testingAccount1.getBalance(), 50)); // Balance should still
                                                                                               // stay the same
    testingAccount1.transferTo(50, targetAccountForTransaction);
    System.out
        .println("\tTransacting $50.00 to another account: " + equals(targetAccountForTransaction.getBalance(), 50));
    targetAccountForTransaction.transferTo(50, testingAccount1);
    System.out.println(
        "\tTransacting $50.00 back to current account: " + equals(targetAccountForTransaction.getBalance(), 0));
    testingAccount1.transferTo(200, targetAccountForTransaction);
    System.out.println(
        "\tTransacting invalid amount to other account: " + equals(targetAccountForTransaction.getBalance(), 0));
    System.out.println("Current account log:\n" + testingAccount1.getLog());
    System.out.println("Target account log:\n" + targetAccountForTransaction.getLog());

    System.out.println("\nTESTING PASSWORD GENERATOR USING LOOP:");
    for (int i = 0; i < 100; ++i)
      System.out.println("   " + testingAccount1.genPswd(6));

    System.out.println("\nTESTING ACCOUNT NUMBER GENERATOR USING LOOP:");
    for (int i = 0; i < 100; ++i)
      System.out.println("   " + testingAccount1.genAcctNum(6));
  }
}