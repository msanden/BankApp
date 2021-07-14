package main.java;

import java.util.ArrayList;

public class Account {
    private String name;
    private String id;
    private User user;
    private ArrayList<Transaction> transactions;

    public Account(String name, User user, Bank bank) {
        this.name = name;
        this.user = user;
        this.id = bank.generateAccountID();
        this.transactions = new ArrayList<Transaction>();
    }

    public String getId() {
        return id;
    }

    public void addTransaction(double amount) {
        Transaction transaction = new Transaction(amount, this);

        this.transactions.add(transaction);
    }

    public void addTransaction(double amount, String message) {
        Transaction transaction = new Transaction(amount, this, message);

        this.transactions.add(transaction);
    }

    public double getBalance() {
        double balance = 0;

        for (Transaction t : this.transactions) {
            balance += t.getAmount();
        }

        return balance;
    }

    public String getSummaryLine() {

        // get the account's balance
        double balance = getBalance();

        // format summary line depending on whether balance is negative
        if (balance >= 0) {
            return String.format("%s : $%.02f : %s", id, balance,
                    name);
        } else {
            return String.format("%s : $(%.02f) : %s", id, balance,
                    name);
        }

    }

    public void printTransHistory() {
        System.out.printf("\nTransaction history for account %s\n", id);

        for (int i = transactions.size() - 1; i >= 0; i--) {
            System.out.println(transactions.get(i).getSummaryLine());
        }

        System.out.println();

    }

}
