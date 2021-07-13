package com.pyramid.views;

import com.pyramid.entities.User;
import com.pyramid.utils.Utils;

public class UserView {

    public void printUserInfo(User user) {
        System.out.println("First name = " + user.getFirstName());
        System.out.println("Last name = " + user.getLastName());
    }

    public void printUserMenu() {
        System.out.println("1 - User Info");
        System.out.println("2 - Exit to Main menu");
    }

    public int enterUserChoice() {
        return Integer.parseInt(Utils.scanner.nextLine());
    }
}
