package main.java;
import java.util.Date;


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

    public String getLocation(){
        return this.location;
    }

    public String getAvailableBalance(){
        return this.availableBalance;
    }

    public String getAccountNo(){  return this.accountNo; }
}
