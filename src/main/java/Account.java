package main.java;

import java.util.ArrayList;

public class Account {

    private String name;
    private String accountID;
    private User accHolder;
    private ArrayList<Transaction> transactionHistory;

    public Account(String name, User accHolder, Bank bank) {

        this.name = name;
        this.accHolder = accHolder;
        this.accountID = bank.generateAccountID();
        this.transactionHistory = new ArrayList<Transaction>();
        //accHolder.addAccount(this);
        //bank.addAccount(this);
    }

    public String getAccountID() {
        return this.accountID;
    }

    public String getSummaryLine(){

        double balance = this.getBalance();

        if(balance >= 0){
            return String.format("%s : $%.02f : %s", this.accountID, balance, this.name);
        } else {
            return String.format("%s : $(%.02f) : %s", this.accountID, balance, this.name);
        }
    }

    public double getBalance(){

        double balance = 0;

        for (Transaction transaction : this.transactionHistory){
            balance += transaction.getAmount();
        }
        return balance;
    }

    public void printTransactionHistory(){

        System.out.printf("\nTransaction history for account %s\n", this.accountID);
        for (int t = this.transactionHistory.size() - 1; t >= 0; t--){
            System.out.println(this.transactionHistory.get(t).getSummaryLine());
        }
        System.out.println();
    }

    public void addTransaction(double amount, String message){

        Transaction newTransaction = new Transaction(amount,this, message);
        this.transactionHistory.add(newTransaction);
    }
}
