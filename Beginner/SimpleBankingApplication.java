import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class BankAccount {
    private String accountNumber;
    private String accountHolderName;
    private double balance;

    public BankAccount(String accountNumber, String accountHolderName, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if( amount > 0) {
            balance += amount;
            System.out.println("Deposited: ₹" + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if(amount > 0 && balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawn: ₹" + amount);
        } else {
            System.out.println("Insufficient funds or invalid withdrawal amount.");
        }
    }

    public void displayAccountInfo() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Balance: ₹" + balance);
    }

}

public class SimpleBankingApplication {

    private static Map<String, BankAccount> accounts = new HashMap<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            displayMenu();
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    createAccount();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    withdraw();
                    break;
                case 4:
                    checkBalance();
                    break;
                case 5:
                    displayAllAccounts();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }


    private static void displayMenu() {
        System.out.println("\nSimple Banking Application");
        System.out.println("1. Create Account");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Check Balance");
        System.out.println("5. Display All Accounts");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void createAccount() {
        System.out.println("Enter the account number: ");
        String accountNumber = sc.nextLine();
        System.out.println("Enter the account holder name: ");
        String accountHolderName = sc.nextLine();
        System.out.println("Enter initial balance: ");
        double balance = sc.nextDouble();
        sc.nextLine();

        BankAccount account = new BankAccount(accountNumber, accountHolderName, balance);
        accounts.put(accountNumber, account);
        System.out.println("Account created successfully");
    }

    private static void deposit() {
        System.out.println("Enter the account number");
        String accountNumber = sc.nextLine();
        BankAccount account = accounts.get(accountNumber);
        if(account!=null) {
            System.out.println("Enter the amount: ");
            double amount = sc.nextDouble();
            sc.nextLine();
            account.deposit(amount);
        } else {
            System.out.println("Account not found..");
        }
    }

    private static void withdraw() {
        System.out.println("Enter the account number: ");
        String accountNumber = sc.nextLine();
        BankAccount account = accounts.get(accountNumber);
        if(account != null) {
            System.out.println("Enter withdrawal amount: ");
            double amount = sc.nextDouble();
            sc.nextLine();
            account.withdraw(amount);
        } else {
            System.out.println("Account not found..");
        }
    }

    private static void checkBalance() {
        System.out.println("Enter the account number");
        String accountNumber = sc.nextLine();
        BankAccount account = accounts.get(accountNumber);
        if(account != null) {
            account.displayAccountInfo();
        } else {
            System.out.println("Account not found..");
        }
    }

    private static void displayAllAccounts() {
        if (accounts.isEmpty()) {
            System.out.println("No accounts to display..");
            return;
        }

        System.out.println("\nAll Accounts");
        for(BankAccount account: accounts.values()) {
            account.displayAccountInfo();
            System.out.println("------");
        }
    }
}
