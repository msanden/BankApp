package com.pyramid.controllers;

import com.pyramid.DAO.AccountDAO;
import com.pyramid.entities.Account;
import com.pyramid.entities.AccountType;

import java.util.ArrayList;

public class AccountController {
    private final AccountDAO accountDAO = new AccountDAO();

    public Account getAccountByUserIdAndType(long id, AccountType type) {
        return accountDAO.getAccountByUserIdAndType(id, type);
    }

    public ArrayList<Account> getAccountsByUserId(long id) {
        return accountDAO.getAccountsByUserId(id);
    }
}
