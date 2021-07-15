package com.pyramid.views;

import com.pyramid.entities.AccountType;
import com.pyramid.entities.User;
import com.pyramid.utils.Utils;

public class UserView {

    public void printUserInfo(User user) {
        System.out.println("First name = " + user.getFirstName());
        System.out.println("Last name = " + user.getLastName());
    }

    public void printUserAccountsMenu() {
        System.out.println("What would you like to do?");
        System.out.println("1 - Checking");
        System.out.println("2 - Saving");
        System.out.println("3 - Exit to User menu");
    }

    public void printUserAccountMenu() {
        System.out.println("What would you like to do?");
        System.out.println("  1) Show account transaction history");
        System.out.println("  2) Withdraw");
        System.out.println("  3) Deposit");
        System.out.println("  4) Transfer");
        System.out.println("  5) Quit");
    }

    public void printAccountHistory(AccountType accountType) {
        System.out.println("Account transaction history" + accountType);
    }

    public void printWithdrawMenu(AccountType accountType) {
        System.out.println("Withdraw" + accountType);
    }

    public void printDepositMenu(AccountType accountType) {
        System.out.println("Deposit" + accountType);
    }

    public void printTransferMenu(AccountType accountType) {
        System.out.println("Transfer" + accountType);
    }


}
