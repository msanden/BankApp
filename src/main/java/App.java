package main.java;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner stdin = new Scanner(System.in);
        Bank bank = new Bank("Simple Bank");

        User newClient = bank.addUser("Jay", "Jay", "0000");
        Account newAccount = new Account("Checking",newClient, bank);

        newClient.addAccount(newAccount);
        bank.addAccount(newAccount);

        User currentTransaction;
        while(true) {

            /** stay in login prompt until login is successful */
            currentTransaction = App.mainMenuPrompt(bank, stdin);

            /** stay in main menu interface until user quits */
            App.printUserMenu(currentTransaction, stdin);
        }
    }

    public static User mainMenuPrompt(Bank bank, Scanner stdin) {

        String userID;
        String pin;
        User authenticateUser;

        //prompt user for correct user id/pin combo
        do {
            System.out.printf("Welcome to %s \n", bank.getName());
            System.out.println("Enter your Account ID");
            userID = stdin.nextLine();
            System.out.println("Enter your pin: ");
            pin = stdin.nextLine();

            //Find User Object with corresponding id/pin combo
            authenticateUser = bank.userLogin(userID, pin);
            if (authenticateUser == null) {
                System.out.println("You entered an incorrect pin or password");
            }
        } while(authenticateUser == null);

        return authenticateUser;
    }

    public static void printUserMenu(User user, Scanner stdin) {

        //print summary of the user's accounts
        user.printAccountsSummary();
        int option;
        do {
            System.out.println("What would you like to do?");
            System.out.println("  1) Transaction History");
            System.out.println("  2) Withdraw");
            System.out.println("  3) Deposit");
            System.out.println("  4) Transfer");
            System.out.println("  5) Exit");
            System.out.println();
            System.out.print("Enter choice: ");
            option = stdin.nextInt();

            if(option < 1 || option > 5) {
                System.out.println("Enter a valid choice");
            }
        } while (option < 1 || option > 5);

        switch (option) {
            case 1:
                App.showTransactionHistory(user, stdin);
                break;
            case 2:
                App.withdrawFunds(user, stdin);
                break;
            case 3:
                App.depositFunds(user, stdin);
                break;
            case 4:
                App.transferFunds(user, stdin);
                break;
        }
        //re-display menu unless user quits
        if (option != 5) {
            App.printUserMenu(user, stdin);
        }
    }

    public static void showTransactionHistory(User user, Scanner scan){
        int currentAccount;

        do{
            System.out.printf("Enter the (1-%d) of the account\n" +
                    "whose transactions you want to see: " +
                    user.numofAccounts());

            currentAccount = scan.nextInt() - 1;
            if(currentAccount < 0 || currentAccount >= user.numofAccounts()){
                System.out.println("Invalid account number. Please try again!");
            }
        } while(currentAccount < 0 || currentAccount >= user.numofAccounts());

        user.printAccountTransHistory(currentAccount);
    }

    public static void withdrawFunds(User user, Scanner scan){
        int fromAccount;
        double amount;
        double accountBalance;
        String memo;

        //
        do {
            System.out.printf("Enter the number (1-%d) of the account\n" +
                    "to withdraw from: ", user.numofAccounts());
            fromAccount = scan.nextInt() - 1;
            if(fromAccount < 0 || fromAccount >= user.numofAccounts()){
                System.out.println("Invalid account number. Please try again!");
            }
        } while(fromAccount < 0 || fromAccount >= user.numofAccounts());


        accountBalance = user.getAccountBalance(fromAccount);

        //get the amount to transfer
        do {
            System.out.printf("Enter the amount to withdraw (max $%.02f): $",
                    accountBalance);
            amount = scan.nextDouble();
            if(amount < 0){
                System.out.println("Amount must not be a negative number!");
            } else if(amount > accountBalance){
                System.out.printf("Amount must not be greater than\n" +
                        "balance of $%0.02f.\n", accountBalance);
            }
        } while(amount < 0 || amount > accountBalance);

        //get left over data
        scan.nextLine();

        //get memo
        System.out.print("Enter a memo: ");
        memo = scan.nextLine();

        //do the withdrawal
        user.addAccountTransaction(fromAccount, -1*amount, memo);

    }

    public static void depositFunds(User user, Scanner scan){
        int toAccount;
        double amount;
        double accountBalance;
        String memo;

        //Transfer from this account
        do {
            System.out.printf("Enter the number (1-%d) of the account\n" +
                    "to deposit in: ", user.numofAccounts());
            toAccount = scan.nextInt() - 1;
            if(toAccount < 0 || toAccount >= user.numofAccounts()){
                System.out.println("Invalid account number. Please try again!");
            }
        } while(toAccount < 0 || toAccount >= user.numofAccounts());


        accountBalance = user.getAccountBalance(toAccount);

        //get the amount to transfer
        do {
            System.out.printf("Enter the amount to transfer (max $%.02f): $",
                    accountBalance);
            amount = scan.nextDouble();
            if(amount < 0){
                System.out.println("Amount must not be a negative number!");
            }
        } while(amount < 0);

        //get left over data
        scan.nextLine();

        //get memo
        System.out.print("Enter a memo: ");
        memo = scan.nextLine();

        //do the deposit
        user.addAccountTransaction(toAccount, amount, memo);
    }

    public static void transferFunds(User user, Scanner scan){
        int fromAccount;
        int toAccount;
        double amount;
        double accountBalance;

        //Transfer from this account
        do {
            System.out.printf("Enter the number (1-%d) of the account\n" +
                    "to transfer from: ", user.numofAccounts());
            fromAccount = scan.nextInt() - 1;
            if(fromAccount < 0 || fromAccount >= user.numofAccounts()){
                System.out.println("Invalid account number. Please try again!");
            }
        } while(fromAccount < 0 || fromAccount >= user.numofAccounts());


        accountBalance = user.getAccountBalance(fromAccount);


        //Transfer to this account
        do {
            System.out.printf("Enter the number (1-%d) of the account\n" +
                    "to transfer to: ", user.numofAccounts());
            toAccount = scan.nextInt() - 1;
            if(toAccount < 0 || toAccount >= user.numofAccounts()){
                System.out.println("Invalid account number. Please try again!");
            }
        } while(toAccount < 0 || toAccount >= user.numofAccounts());

        //get the amount to transfer
        do {
            System.out.printf("Enter the amount to transfer (max $%.02f): $",
                    accountBalance);
            amount = scan.nextDouble();
            if(amount < 0){
                System.out.println("Amount must not be a negative number!");
            } else if(amount > accountBalance){
                System.out.printf("Amount must not be greater than\n" +
                        "balance of $%0.02f.\n", accountBalance);
            }
        } while(amount < 0 || amount > accountBalance);

        //Do the transfer
        user.addAccountTransaction(fromAccount, -1*amount,
                String.format("Transfer from account %s", user.getAccountID(toAccount)));
        user.addAccountTransaction(toAccount, amount,
                String.format("Transfer to account %s", user.getAccountID(fromAccount)));

    }




}
