import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Random;

import org.junit.*;

public class BankAccountManagerTesting {
  @Test
  public void resettingWithNoAccounts() {
    BankAccountManager bankAccountManager = new BankAccountManager();
    bankAccountManager.clearAccts();
    assertEquals(bankAccountManager.findFirstEmpty(), 0);
  }

  @Test
  public void withdrawingWithNoAccounts() {
    BankAccountManager bankAccountManager = new BankAccountManager();
    bankAccountManager.withdrawFromAll(100);
    assertEquals(bankAccountManager.findFirstEmpty(), 0);
  }

  @Test
  public void depositingWithNoAccounts() {
    BankAccountManager bankAccountManager = new BankAccountManager();
    bankAccountManager.depositIntoAll(100);
    assertEquals(bankAccountManager.findFirstEmpty(), 0);
  }

  @Test
  public void addingAccountToFullArray() {
    BankAccountManager bankAccountManager = new BankAccountManager();
    Random randomNumberGenerator = new Random();
    for (int i = 0; i < 100; ++i) {
      BankAccount bankAccount = new BankAccount(randomNumberGenerator.nextInt(1000), 0, "JackJack", "please work",
          "crazy password", "ha ha");
      bankAccountManager.addAcct(bankAccount);
    }

    assertFalse(bankAccountManager.addAcct(
        new BankAccount(randomNumberGenerator.nextInt(1000), 0, "JackJack", "please work", "crazy password", "ha ha")));
    assertEquals(bankAccountManager.findFirstEmpty(), -1);
  }

  @Test
  public void resetAllAccounts() {
    BankAccountManager bankAccountManager = new BankAccountManager();
    BankAccount bankAccount = new BankAccount(555, 0, "JackJack", "please work", "crazy password", "ha ha");
    bankAccountManager.addAcct(bankAccount);
    BankAccount bankAccount2 = new BankAccount(666, 0, "Yolo", "please work", "crazy password", "ha ha");
    bankAccountManager.addAcct(bankAccount2);
    BankAccount bankAccount3 = new BankAccount(777, 0, "Doink", "please work", "crazy password", "ha ha");
    bankAccountManager.addAcct(bankAccount3);

    assertEquals(bankAccountManager.findFirstEmpty(), 3);
    bankAccountManager.clearAccts();
    assertEquals(bankAccountManager.findFirstEmpty(), 0);
  }

  @Test
  public void depositToAllAccounts() {
    BankAccountManager bankAccountManager = new BankAccountManager();
    BankAccount bankAccount = new BankAccount(555, 0, "JackJack", "please work", "crazy password", "ha ha");
    bankAccountManager.addAcct(bankAccount);
    BankAccount bankAccount2 = new BankAccount(666, 0, "Yolo", "please work", "crazy password", "ha ha");
    bankAccountManager.addAcct(bankAccount2);
    BankAccount bankAccount3 = new BankAccount(777, 0, "Doink", "please work", "crazy password", "ha ha");
    bankAccountManager.addAcct(bankAccount3);

    bankAccountManager.depositIntoAll(100);

    assertEquals(bankAccountManager.getAccount(555).getBalance(), 100, 1e-9);
    assertEquals(bankAccountManager.getAccount(666).getBalance(), 100, 1e-9);
    assertEquals(bankAccountManager.getAccount(777).getBalance(), 100, 1e-9);
  }

  @Test
  public void withdrawFromAllAccounts() {
    BankAccountManager bankAccountManager = new BankAccountManager();
    BankAccount bankAccount = new BankAccount(555, 0, "JackJack", "please work", "crazy password", "ha ha");
    bankAccountManager.addAcct(bankAccount);
    BankAccount bankAccount2 = new BankAccount(666, 0, "Yolo", "please work", "crazy password", "ha ha");
    bankAccountManager.addAcct(bankAccount2);
    BankAccount bankAccount3 = new BankAccount(777, 0, "Doink", "please work", "crazy password", "ha ha");
    bankAccountManager.addAcct(bankAccount3);

    bankAccountManager.depositIntoAll(200);
    bankAccountManager.withdrawFromAll(50);
    assertEquals(bankAccountManager.getAccount(555).getBalance(), 150, 1e-9);
    assertEquals(bankAccountManager.getAccount(666).getBalance(), 150, 1e-9);
    assertEquals(bankAccountManager.getAccount(777).getBalance(), 150, 1e-9);
  }

  @Test
  public void getAccount() {
    BankAccountManager bankAccountManager = new BankAccountManager();
    BankAccount bankAccount = new BankAccount(555, 0, "JackJack", "please work", "crazy password", "ha ha");
    bankAccountManager.addAcct(bankAccount);
    BankAccount bankAccount2 = new BankAccount(666, 0, "Yolo", "please work", "crazy password", "ha ha");
    bankAccountManager.addAcct(bankAccount2);
    BankAccount bankAccount3 = new BankAccount(777, 0, "Doink", "please work", "crazy password", "ha ha");
    bankAccountManager.addAcct(bankAccount3);

    assertEquals(bankAccountManager.getAccount(555).getFName(), "JackJack");
    assertEquals(bankAccountManager.getAccount(666).getFName(), "Yolo");
    assertEquals(bankAccountManager.getAccount(777).getFName(), "Doink");
    assertEquals(bankAccountManager.getAccount(542), null);
  }

  @Test
  public void addAccount() {
    BankAccountManager bankAccountManager = new BankAccountManager();
    BankAccount bankAccount = new BankAccount();
    bankAccountManager.addAcct(bankAccount);
    assertEquals(bankAccountManager.acctArray[0].getAcctNum(), bankAccount.getAcctNum());
  }

  @Test
  public void removeAccount() {
    BankAccountManager bankAccountManager = new BankAccountManager();
    BankAccount bankAccount = new BankAccount(555, 0, "hi", "please work", "crazy password", "ha ha");
    bankAccountManager.addAcct(bankAccount);
    BankAccount bankAccount2 = new BankAccount(666, 0, "hi", "please work", "crazy password", "ha ha");
    bankAccountManager.addAcct(bankAccount2);
    BankAccount bankAccount3 = new BankAccount(777, 0, "hi", "please work", "crazy password", "ha ha");
    bankAccountManager.addAcct(bankAccount3);

    int numberOfAccountsNotNull = 0;
    for (int i = 0; i < bankAccountManager.acctArray.length; ++i)
      if (bankAccountManager.acctArray[i] != null)
        ++numberOfAccountsNotNull;
    assertEquals(numberOfAccountsNotNull, 3);
    bankAccountManager.rmAcct(666);
    assertEquals(bankAccountManager.findFirstEmpty(), 1);
    assertFalse(bankAccountManager.rmAcct(666));
  }

  @Test
  public void isAccountNumberUnique() {
    BankAccountManager bankAccountManager = new BankAccountManager();
    BankAccount bankAccount = new BankAccount(555, 0, "hi", "please work", "crazy password", "ha ha");
    bankAccountManager.addAcct(bankAccount);
    BankAccount bankAccount2 = new BankAccount(666, 0, "hi", "please work", "crazy password", "ha ha");
    bankAccountManager.addAcct(bankAccount2);

    assertTrue(bankAccountManager.isAcctNumUnique(543));
    assertFalse(bankAccountManager.isAcctNumUnique(666));
  }

  @Test
  public void findFirstEmpty() {
    BankAccountManager bankAccountManager = new BankAccountManager();
    bankAccountManager.addAcct(new BankAccount());
    assertEquals(bankAccountManager.findFirstEmpty(), 1);
  }
}