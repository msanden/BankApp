package main.java;

import main.java.Account;
import main.java.Bank;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.security.MessageDigest;


/**
 * main.java.User class representing a customer/client
 * */

public class User {

    private String firstName;
    private String lastName;
    private byte[] pinNumber;
    private String userID;
    private ArrayList<Account> accounts;

    /** creates a user with a specified name, pinNumber and their atm branch */
    public User(String firstName, String lastName, String pinNumber, Bank bank) {
        this.firstName = firstName;
        this.lastName = lastName;

        /** pin stored as a string hashed using md5 algorithm */
        try {
            MessageDigest cryptPin = MessageDigest.getInstance("MD5");
            this.pinNumber = cryptPin.digest(pinNumber.getBytes());
        } catch (NoSuchAlgorithmException e) {
            System.out.println(" The cryptographic algorithm requested is not available in the environment");
            e.printStackTrace();
            System.exit(1);
        }

        /**generate userID for each user*/
        this.userID = bank.generateUserID();
        this.accounts = new ArrayList<Account>();
        System.out.printf("Welcome %s, %s with ID %s created.\n", lastName, firstName, this.userID);
    }

    /** add an account to user's list of accounts */
    public void addAccount(Account account) {
        this.accounts.add(account);
    }

    public String getUserID() {
        return this.userID;
    }

    public boolean isPinValid(String pin) {

        try {
            MessageDigest validatePin = MessageDigest.getInstance("MD5");
            return MessageDigest.isEqual(validatePin.digest(pin.getBytes()), this.pinNumber);
        } catch (NoSuchAlgorithmException e) {
            System.out.println(" The cryptographic algorithm requested is not available in the environment");
            e.printStackTrace();
            System.exit(1);
        }
        return false;
    }

    public String getFirstName() {
        return this.firstName;
    }

    /**
     * account summary for this user */
    public void printAccountsSummary() {
        System.out.printf("\n\n%s 's account summary\n", this.firstName);
        for(int i = 0; i < accounts.size(); i++) {
            System.out.printf("  %d) %s\n", i+1, accounts.get(i).getSummaryLine());
        }
        System.out.println();
    }

    public int numofAccounts() {
        return accounts.size();
    }

    public void printAccountTransHistory(int accountkey) {
        accounts.get(accountkey).printTransHistory();
    }

    public double getAccountBalance(int accountkey) {
        return accounts.get(accountkey).getBalance();
    }

    public String getAccountID(int accountkey) {
        return accounts.get(accountkey).getAccountID();
    }

    public void addAccountTransaction(int accountkey, double amount, String memo) {
        this.accounts.get(accountkey).addTransaction(amount, memo);
    }
}
