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
            System.out.printf("\n\n Welcome to %s \n", bank.getName());
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
                App.showTransHistory(user, stdin);
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


}
