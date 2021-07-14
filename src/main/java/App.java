package main.java;

import java.util.Scanner;

public class App {









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
