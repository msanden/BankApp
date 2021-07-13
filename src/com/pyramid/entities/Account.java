package com.pyramid.entities;

import java.util.ArrayList;

public class Account {
    private AccountType name;
    private ArrayList<Transaction> transaction;

    public AccountType getName() {
        return name;
    }

    public void setName(AccountType name) {
        this.name = name;
    }

    public ArrayList<Transaction> getTransaction() {
        return transaction;
    }

    public void setTransaction(ArrayList<Transaction> transaction) {
        this.transaction = transaction;
    }
}
