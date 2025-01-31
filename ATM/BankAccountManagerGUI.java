import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

/*******************************************
 * WORK ON THE CHANGE PASSWORD 🙏🙏🙏🙏
 ******************************************/

public class BankAccountManagerGUI extends JFrame {
    static BankAccountManager bankAccountManager = new BankAccountManager();
    final private CardLayout cardLayout = new CardLayout();
    final private String ROOT_PANEL_ID = "RootPanel";
    final private String LOGIN_PANEL_ID = "LoginPanel";
    final private String REGISTER_PANEL_ID = "RegisterPanel";
    final private String MAIN_PANEL_ID = "MainPanel";
    final private String DEPOSIT_PANEL_ID = "DepositPanel";
    final private String WITHDRAW_PANEL_ID = "WithdrawPanel";
    final private String TRANSFER_PANEL_ID = "TransferPanel";
    final private String ACCOUNT_INFO_PANEL_ID = "AccountInfoPanel";
    final private String TRANSACTION_PANEL_ID = "TransactionPanel";
    final private String CHANGE_PASSWORD_PANEL_ID = "ChangePasswordPanel";
    BankAccount currentBankAccount = null;
    private JButton LOGINButton;
    private JPanel panel;
    private JPanel loginPanel;
    private JPanel mainPanel;
    private JButton loginButton;
    private JPasswordField passwordTextField;
    private JButton rootDepositButton;
    private JButton rootWithdrawButton;
    private JButton rootTransferToButton;
    private JButton rootAccountInfoButton;
    private JButton rootViewTransactionsButton;
    private JButton rootChangePasswordButton;
    private JButton logoutButton;
    private JPanel rootPanel;
    private JButton rootLoginButton;
    private JButton registerButton;
    private JPanel depositPanel;
    private JSpinner depositAmount;
    private JButton depositButton;
    private JPanel withdrawPanel;
    private JPanel transferPanel;
    private JPanel accountInfoPanel;
    private JPanel transactionsPanel;
    private JPanel changePasswordPanel;
    private JSpinner withdrawAmount;
    private JButton withdrawButton;
    private JLabel accountNumber;
    private JLabel accountBalance;
    private JLabel accountFirstName;
    private JLabel accountLastName;
    private JLabel transactions;
    private JPasswordField newPasswordField;
    private JPasswordField confirmNewPasswordField;
    private JLabel currentPasswordLabel;
    private JLabel newPasswordLabel;
    private JLabel confirmNewPasswordLabel;
    private JLabel depositAmountLabel;
    private JLabel withdrawAmountLabel;
    private JSpinner transferAmountSpinner;
    private JTextField transferAcountNumberTextField;
    private JLabel transferAmountLabel;
    private JLabel transferAccountNumberLabel;
    private JButton transferButton;
    private JButton depositExitButton;
    private JButton withdrawExitButton;
    private JButton transferExitButton;
    private JButton accountInfoExitButton;
    private JButton transactionsExitButton;
    private JButton changePasswordButton;
    private JButton changePasswordExitButton;
    private JPanel registerPanel;
    private JTextField firstNameTextField;
    private JTextField lastNameTextField;
    private JCheckBox generatePasswordCheckBox;
    private JButton createAccountButton;
    private JButton registerExitButton;
    private JTextField usernameTextField;
    private JScrollPane transactionsScrollPanel;
    private JLabel transactionsText;
    private JPasswordField currentPasswordField;
    private JPasswordField passwordField;
    private JLabel passwordFieldLabel;

    public BankAccountManagerGUI() {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            System.out.println("Java sucks :( :( :( :( :( :(");
        }

        // Initialize CardLayout
        panel = new JPanel(cardLayout);

        // Add panels to the CardLayout
        panel.add(rootPanel, ROOT_PANEL_ID);
        panel.add(registerPanel, REGISTER_PANEL_ID);
        panel.add(loginPanel, LOGIN_PANEL_ID);
        panel.add(mainPanel, MAIN_PANEL_ID);
        panel.add(depositPanel, DEPOSIT_PANEL_ID);
        panel.add(withdrawPanel, WITHDRAW_PANEL_ID);
        panel.add(transferPanel, TRANSFER_PANEL_ID);
        panel.add(accountInfoPanel, ACCOUNT_INFO_PANEL_ID);
        panel.add(transactionsPanel, TRANSACTION_PANEL_ID);
        panel.add(changePasswordPanel, CHANGE_PASSWORD_PANEL_ID);

        // Set up JFrame
        setContentPane(panel); // Use the parent panel with CardLayout

        /*=================================================
        COMMENT BACK IN AFTER TESTING

        cardLayout.show(panel, ROOT_PANEL_ID);
        =================================================*/

        cardLayout.show(panel, ROOT_PANEL_ID);

        setTitle("Bank Account Manager");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setLocationRelativeTo(null);
        setVisible(true);

        rootLoginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panel, LOGIN_PANEL_ID);
            }
        });

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int accountNumber = Integer.parseInt(usernameTextField.getText());
                    currentBankAccount = bankAccountManager.getAccount(accountNumber);
                    if (currentBankAccount == null)
                        throw new IllegalArgumentException("Invalid account number");
                    else if (!currentBankAccount.checkPswd(String.valueOf(passwordTextField.getPassword()))) {
                        currentBankAccount = null;
                        throw new IllegalArgumentException("Invalid password");
                    }
                    usernameTextField.setText("");
                    passwordTextField.setText("");
                    cardLayout.show(panel, MAIN_PANEL_ID);
                } catch (Exception e1) {
                    String message = e1.getMessage();
                    String title = "Error";

                    if (e1 instanceof NumberFormatException)
                        message = "Please enter your account number, not any other characters";
                    dialogWindow(title, message);
                }
            }
        });

        rootDepositButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panel, DEPOSIT_PANEL_ID);
            }
        });

        rootWithdrawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panel, WITHDRAW_PANEL_ID);
            }
        });

        rootTransferToButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panel, TRANSFER_PANEL_ID);
            }
        });

        rootAccountInfoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panel, ACCOUNT_INFO_PANEL_ID);
                accountNumber.setText("Account Number: " + currentBankAccount.getAcctNum());
                accountBalance.setText("Balance: $" + String.format("%.2f", currentBankAccount.getBalance()));
                accountFirstName.setText("First Name: " + currentBankAccount.getFName());
                accountLastName.setText("Last Name: " + currentBankAccount.getLName());
            }
        });

        rootViewTransactionsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panel, TRANSACTION_PANEL_ID);
                String logText = currentBankAccount.getLog().replace("\n", "<br>");
                transactionsText.setText("<html>" + logText + "</html>");
            }
        });

        rootChangePasswordButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panel, CHANGE_PASSWORD_PANEL_ID);
            }
        });

        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentBankAccount = null;
                cardLayout.show(panel, ROOT_PANEL_ID);
            }
        });

        depositExitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panel, MAIN_PANEL_ID);
            }
        });

        withdrawExitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panel, MAIN_PANEL_ID);
            }
        });

        transferExitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panel, MAIN_PANEL_ID);
            }
        });

        accountInfoExitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panel, MAIN_PANEL_ID);
            }
        });

        transactionsExitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panel, MAIN_PANEL_ID);
            }
        });

        changePasswordExitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panel, MAIN_PANEL_ID);
            }
        });

        registerExitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panel, ROOT_PANEL_ID);
            }
        });

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panel, REGISTER_PANEL_ID);
            }
        });

        depositButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int amount = (Integer) depositAmount.getValue();
                boolean deposited = currentBankAccount.deposit(amount);

                String message = "";
                String title = "";

                if (amount < 0) {
                    title = "Error!";
                    message = "Please enter a positive number";
                } else if (deposited) {
                    title = "Success!";
                    message = "Deposited successfully!";
                    depositAmount.setValue(0);
                } else {
                    title = "Error!";
                    message = "Deposit failed!";
                }

                dialogWindow(title, message);
            }
        });

        withdrawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int amount = (Integer) withdrawAmount.getValue();
                boolean withdrawn = currentBankAccount.withdraw(amount);

                String message = "";
                String title = "";

                if (amount < 0) {
                    title = "Error!";
                    message = "Please enter an amount greater than zero";
                } else if (withdrawn) {
                    title = "Success!";
                    message = "Withdrawn successfully!";
                    withdrawAmount.setValue(0);
                } else {
                    title = "Error!";
                    message = "Withdraw failed! Not enough account balance.";
                }

                dialogWindow(title, message);
            }
        });

        changePasswordButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String currentPassword = String.valueOf(currentPasswordField.getPassword());
                String newPassword = String.valueOf(newPasswordField.getPassword());
                String newPasswordConfirmation = String.valueOf(confirmNewPasswordField.getPassword());

                String title = "";
                String message = "";

                if (currentBankAccount.checkPswd(currentPassword)) {
                    if (newPassword.isEmpty()) {
                        title = "Error!";
                        message = "Password cannot be empty!";
                    } else if (newPassword.equals(newPasswordConfirmation)) {
                        currentBankAccount.resetPswd(currentPassword, newPassword);
                        title = "Success!";
                        message = "Password changed successfully! :)";
                        currentPasswordField.setText("");
                        newPasswordField.setText("");
                        confirmNewPasswordField.setText("");
                        System.out.println(currentBankAccount.pswd);
                    } else {
                        title = "Error!";
                        message = "New password and new password confirmation do not match! :(";
                    }
                } else {
                    title = "Error!";
                    message = "Current password does not match! :(";
                }

                dialogWindow(title, message);
            }
        });

        transferButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int transferAmount = (Integer) transferAmountSpinner.getValue();
                String transferAccountNumberString = transferAcountNumberTextField.getText();

                String title = "";
                String message = "";

                if (transferAccountNumberString.isEmpty()) {
                    title = "Error!";
                    message = "Account number cannot be empty!";
                } else if (!isNumeric(transferAccountNumberString)) {
                    title = "Error!";
                    message = "Account number is not a number!";
                } else if (bankAccountManager.getAccount(Integer.parseInt(transferAccountNumberString)) == null) {
                    title = "Error!";
                    message = "Account not found!";
                } else if (transferAmount < 0) {
                    title = "Error!";
                    message = "Transfer amount cannot be less than 0!";
                } else if (transferAmount > currentBankAccount.getBalance()) {
                    title = "Error!";
                    message = "Transfer amount exceeds current balance!";
                } else {
                    int transferAccountNumber = Integer.parseInt(transferAccountNumberString);
                    BankAccount accountToTransfer = bankAccountManager.getAccount(transferAccountNumber);
                    boolean isTransferred = currentBankAccount.transferTo(transferAmount, accountToTransfer);
                    if (isTransferred) {
                        title = "Success!";
                        message = "Transfered successfully! :)";
                        transferAmountSpinner.setValue(0);
                        transferAcountNumberTextField.setText("");
                    } else {
                        title = "Error!";
                        message = "Transfer failed! :(";
                    }
                }

                dialogWindow(title, message);
            }
        });

        createAccountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String firstName = firstNameTextField.getText();
                String lastName = lastNameTextField.getText();
                String password = String.valueOf(passwordField.getPassword());
                boolean generatePassword = generatePasswordCheckBox.isSelected();

                String title = "";
                String message = "";

                if (firstName.isEmpty()) {
                    title = "Error!";
                    message = "First name cannot be empty!";
                } else if (lastName.isEmpty()) {
                    title = "Error!";
                    message = "Last name cannot be empty!";
                } else if (!generatePassword && password.isEmpty()) {
                    title = "Error!";
                    message = "Password cannot be empty!";
                } else {
                    BankAccount newBankAccount;
                    if (generatePassword) {
                        newBankAccount = new BankAccount(firstName, lastName);
                    } else {
                        newBankAccount = new BankAccount(0, 0, firstName, lastName, password, "");
                        newBankAccount.resetAcctNum();
                    }

                    if (bankAccountManager.addAcct(newBankAccount)) {
                        title = "Success!";
                        message = "Account number: " + newBankAccount.getAcctNum();
                    } else {
                        title = "Error!";
                        message = "Can't add more accounts! :(";
                    }

                    firstNameTextField.setText("");
                    lastNameTextField.setText("");
                    passwordField.setText("");
                    generatePasswordCheckBox.setSelected(false);
                    cardLayout.show(panel, ROOT_PANEL_ID);
                }
                dialogWindow(title, message);
            }
        });

        generatePasswordCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                passwordField.setVisible(!generatePasswordCheckBox.isSelected());
                passwordFieldLabel.setVisible(!generatePasswordCheckBox.isSelected());
            }
        });
    }

    public static void main(String[] args) {
        BankAccount bankAccount1 = new BankAccount("Darth", "Vader");
        BankAccount bankAccount2 = new BankAccount("Obi-wan", "Kenobi");
        BankAccount bankAccount3 = new BankAccount("Luke", "Skywalker");

        bankAccountManager.addAcct(bankAccount1);
        bankAccountManager.addAcct(bankAccount2);
        bankAccountManager.addAcct(bankAccount3);
        bankAccountManager.display();

        bankAccount1.display();
        new BankAccountManagerGUI();
    }

    private boolean isNumeric(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private void dialogWindow(String title, String message) {
        JDialog dialog = new JDialog();
        JLabel successLabel = new JLabel(message, JLabel.CENTER);

        dialog.setTitle(title);
        dialog.setModal(true);
        dialog.setLocationRelativeTo(null);
        dialog.setSize(300, 200);
        dialog.add(successLabel, JLabel.CENTER);
        dialog.setVisible(true);
    }
}
