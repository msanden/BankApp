package com.pyramid.utils;

import com.pyramid.Storage;
import com.pyramid.entities.Account;
import com.pyramid.entities.AccountType;
import com.pyramid.entities.Transaction;
import com.pyramid.entities.User;

public class Initializer {

    public void init() {
        User user = new User("John", "Wick");
        user.setLogin("test");
        user.setPassword("123");

        Account checkingAccount = new Account(AccountType.CHECKING);
        Account savingAccount = new Account(AccountType.SAVING);
        checkingAccount.getTransactions().add(new Transaction(300.50));
        savingAccount.getTransactions().add(new Transaction(-50.25));

        user.getAccounts().add(checkingAccount);
        user.getAccounts().add(savingAccount);

        Storage.getUsers().add(user);
    }
}
