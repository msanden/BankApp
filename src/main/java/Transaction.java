package main.java;

import main.java.Account;

import java.util.Date;
import java.util.Random;

public class Transaction {
    /**
     * The amount for this transaction
     */
    private double amount;

    /**
     * The time and date for this transaction
     */
    private Date timestamp;

    /**
     * A message to describe the transaction
     */
    private String message;

    /**
     * The current account the transaction is being performed.
     */
    private Account accountInProgess;

    /**
     * The transaction number of the user for a single transaction
     */
    private String accountNo;
    /**
     * The location of the bank to print on the transaction slip
     */
    private String location;
    /**
     * The current balance of the main.java.User
     */
    private String availableBalance;

    public Transaction(double amount, Account accountInProgess){
        this.amount = amount;
        this.accountInProgess = accountInProgess;
        this.timestamp = new Date();
        this.message = "";
    }

    public Transaction(double amount, Account accountInProgess, String message){
        //Call the two-arg constructor
        this(amount, accountInProgess);

        //
        this.message = message;
    }

    public String generateUniqueTransactionNumber(){
        String utn;
        Random randomNumber = new Random();
        int lengthOfTransNumber = 9;
        do {
            utn = "";
            for(int character = 0; character < lengthOfTransNumber; character++){
                utn += ((Integer) randomNumber.nextInt(10)).toString();
            }
            break;
            //go through all transactions in the transactions arraylist and compare the id
            //if it is equal then we have to keep making a new unique transaction number

        } while(true);

        return "";
    }

    public String getLocation(){
        return this.location;
    }

    public String getAvailableBalance(){
        return this.availableBalance;
    }
}
