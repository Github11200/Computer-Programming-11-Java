package ATM;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.*;

public class BankAccountManagerTesting {
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