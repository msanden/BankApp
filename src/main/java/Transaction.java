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

    public double getAmount(){
        return this.amount;
    }

    public String getSummaryLine(){
        if(this.amount >= 0){
            return String.format("%s : $%0.02f : %s",
                    this.timestamp.toString(),
                    this.amount, this.message);
        } else {
            return String.format("%s : $(%0.02f) : %s",
                    this.timestamp.toString(),
                    -this.amount, this.message);
        }
    }

}
