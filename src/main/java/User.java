package main.java;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

/**
 * main.java.User class representing a customer/client
 */
public class User {
    private String firstName;
    private String lastName;
    private byte[] pinNumber;
    private String userID;
    private ArrayList<Account> accounts;

    /**
     * creates a user with a specified name, pinNumber and their atm branch
     */
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

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public String getUserID() {
        return this.userID;
    }

    public int numAccounts() {
        return accounts.size();
    }

    public double getAccountBalance(int acctIdx) {
        return accounts.get(acctIdx).getBalance();
    }

    public String getAccountId(int acctIdx) {
        return accounts.get(acctIdx).getId();
    }

    public void printAcctTransHistory(int acctIdx) {
        accounts.get(acctIdx).printTransHistory();
    }

    public void addAcctTransaction(int acctIdx, double amount, String memo) {
        accounts.get(acctIdx).addTransaction(amount, memo);
    }

    public boolean validatePin(String aPin) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            return MessageDigest.isEqual(md.digest(aPin.getBytes()),
                    pinNumber);
        } catch (Exception e) {
            System.err.println("Error, caught exception : " + e.getMessage());
            System.exit(1);
        }

        return false;
    }

    public void printAccountsSummary() {
        System.out.printf("\n\n%s's accounts summary\n", firstName);

        for (int i = 0; i < accounts.size(); i++) {
            System.out.printf("%d) %s\n", i + 1,
                    accounts.get(i).getSummaryLine());
        }

        System.out.println();
    }

}
