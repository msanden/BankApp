package com.pyramid.utils;

import com.pyramid.Storage;
import com.pyramid.entities.Account;
import com.pyramid.entities.AccountType;
import com.pyramid.entities.User;

public class Initializer {

    public void init() {
        User user = new User("John", "Wick");
        user.setLogin("test");
        user.setPassword("123");

        user.getAccounts().add(new Account(AccountType.CHECKING));
        user.getAccounts().add(new Account(AccountType.SAVING));

        Storage.getUsers().add(user);
    }
}
