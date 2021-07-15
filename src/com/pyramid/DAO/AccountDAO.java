package com.pyramid.DAO;

import com.pyramid.Storage;
import com.pyramid.entities.Account;
import com.pyramid.entities.AccountType;
import com.pyramid.entities.User;

import java.util.ArrayList;

public class AccountDAO {

    public Account getAccountByUserIdAndType(long id, AccountType type) {
        for (User user : Storage.getUsers()) {
            if (user.getId() == id) {
                for (Account account : user.getAccounts()) {
                    if (account.getType().equals(type)) {
                        return account;
                    }
                }
            }
        }

        return null;
    }

    public ArrayList<Account> getAccountsByUserId(long id) {
        for (User user : Storage.getUsers()) {
            if (user.getId() == id) {
                return user.getAccounts();
            }
        }

        return null;
    }
}
