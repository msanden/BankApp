package main.java;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Bank bank = new Bank("Bank of America");
        User user = bank.addUser("John", "Doe", "1234");
        Account account = new Account("Checking", user, bank);
        user.addAccount(account);
        bank.addAccount(account);

        User currentUser;

        while (true) {

            // stay in login prompt until successful login
            currentUser = mainMenuPrompt(bank, scanner);

            // stay in main menu until user quits
            printUserMenu(currentUser, scanner);
        }
    }

    public static User mainMenuPrompt(Bank bank, Scanner scanner) {
        String userID;
        String pin;
        User authUser;

        // prompt user for user ID/pin combo until a correct one is reached
        do {
            System.out.printf("\n\nWelcome to %s\n\n", bank.getName());
            System.out.print("Enter user ID: ");
            userID = scanner.nextLine();
            System.out.print("Enter pin: ");
            pin = scanner.nextLine();

            // try to get user object corresponding to ID and pin combo
            authUser = bank.userLogin(userID, pin);
            if (authUser == null) {
                System.out.println("Incorrect user ID/pin combination. " +
                        "Please try again");
            }

        } while (authUser == null);    // continue looping until we have a
        // successful login

        return authUser;
    }

    public static void printUserMenu(User user, Scanner scanner) {
        user.printAccountsSummary();
        int choice;

        do {
            System.out.println("What would you like to do?");
            System.out.println("  1) Show account transaction history");
            System.out.println("  2) Withdraw");
            System.out.println("  3) Deposit");
            System.out.println("  4) Transfer");
            System.out.println("  5) Quit");
            System.out.println();
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();

            if (choice < 1 || choice > 5) {
                System.out.println("Invalid choice. Please choose 1-5.");
            }
        } while (choice < 1 || choice > 5);

        switch (choice) {
            case 1:
                showTransactionHistory(user, scanner);
                break;
            case 2:
                withdrawFunds(user, scanner);
                break;
            case 3:
                depositFunds(user, scanner);
                break;
            case 4:
                transferFunds(user, scanner);
                break;
            case 5:
                // gobble up rest of previous input
                scanner.nextLine();
                break;
        }

        // redisplay this menu unless the user wants to quit
        if (choice != 5) {
            printUserMenu(user, scanner);
        }

    }

    public static void transferFunds(User theUser, Scanner sc) {
        int fromAcct;
        int toAcct;
        double amount;
        double acctBal;

        // get account to transfer from
        do {
            System.out.printf("Enter the number (1-%d) of the account to " +
                    "transfer from: ", theUser.numAccounts());
            fromAcct = sc.nextInt() - 1;
            if (fromAcct < 0 || fromAcct >= theUser.numAccounts()) {
                System.out.println("Invalid account. Please try again.");
            }
        } while (fromAcct < 0 || fromAcct >= theUser.numAccounts());
        acctBal = theUser.getAccountBalance(fromAcct);

        // get account to transfer to
        do {
            System.out.printf("Enter the number (1-%d) of the account to " +
                    "transfer to: ", theUser.numAccounts());
            toAcct = sc.nextInt() - 1;
            if (toAcct < 0 || toAcct >= theUser.numAccounts()) {
                System.out.println("Invalid account. Please try again.");
            }
        } while (toAcct < 0 || toAcct >= theUser.numAccounts());

        // get amount to transfer
        do {
            System.out.printf("Enter the amount to transfer (max $%.02f): $",
                    acctBal);
            amount = sc.nextDouble();
            if (amount < 0) {
                System.out.println("Amount must be greater than zero.");
            } else if (amount > acctBal) {
                System.out.printf("Amount must not be greater than balance " +
                        "of $.02f.\n", acctBal);
            }
        } while (amount < 0 || amount > acctBal);

        // finally, do the transfer
        theUser.addAcctTransaction(fromAcct, -1 * amount, String.format(
                "Transfer to account %s", theUser.getAccountId(toAcct)));
        theUser.addAcctTransaction(toAcct, amount, String.format(
                "Transfer from account %s", theUser.getAccountId(fromAcct)));
    }

    public static void withdrawFunds(User user, Scanner scanner) {
        int fromAcct;
        double amount;
        double acctBal;
        String message;

        // get account to withdraw from
        do {
            System.out.printf("Enter the number (1-%d) of the account to " +
                    "withdraw from: ", user.numAccounts());
            fromAcct = scanner.nextInt() - 1;
            if (fromAcct < 0 || fromAcct >= user.numAccounts()) {
                System.out.println("Invalid account. Please try again.");
            }
        } while (fromAcct < 0 || fromAcct >= user.numAccounts());
        acctBal = user.getAccountBalance(fromAcct);

        // get amount to transfer
        do {
            System.out.printf("Enter the amount to withdraw (max $%.02f): $",
                    acctBal);
            amount = scanner.nextDouble();
            if (amount < 0) {
                System.out.println("Amount must be greater than zero.");
            } else if (amount > acctBal) {
                System.out.printf("Amount must not be greater than balance " +
                        "of $%.02f.\n", acctBal);
            }
        } while (amount < 0 || amount > acctBal);

        // gobble up rest of previous input
        scanner.nextLine();

        // get a memo
        System.out.print("Enter a message: ");
        message = scanner.nextLine();

        // do the withdrwal
        user.addAcctTransaction(fromAcct, -1 * amount, message);

    }

    public static void depositFunds(User user, Scanner scanner) {
        int toAcct;
        double amount;
        String message;

        // get account to withdraw from
        do {
            System.out.printf("Enter the number (1-%d) of the account to " +
                    "deposit to: ", user.numAccounts());
            toAcct = scanner.nextInt() - 1;
            if (toAcct < 0 || toAcct >= user.numAccounts()) {
                System.out.println("Invalid account. Please try again.");
            }
        } while (toAcct < 0 || toAcct >= user.numAccounts());

        // get amount to transfer
        do {
            System.out.printf("Enter the amount to deposit: $");
            amount = scanner.nextDouble();
            if (amount < 0) {
                System.out.println("Amount must be greater than zero.");
            }
        } while (amount < 0);

        // gobble up rest of previous input
        scanner.nextLine();

        // get a memo
        System.out.print("Enter a message: ");
        message = scanner.nextLine();

        // do the deposit
        user.addAcctTransaction(toAcct, amount, message);

    }

    public static void showTransactionHistory(User user, Scanner scanner) {
        int account;

        do {
            System.out.printf("Enter the number (1-%d) of the account\nwhose " +
                    "transactions you want to see: ", user.numAccounts());
            account = scanner.nextInt() - 1;

            if (account < 0 || account >= user.numAccounts()) {
                System.out.println("Invalid account. Please try again.");
            }
        } while (account < 0 || account >= user.numAccounts());

        // print the transaction history
        user.printAcctTransHistory(account);
    }

}
