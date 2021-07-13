package com.pyramid.views;

import com.pyramid.entities.User;

public class UserView {

    public void printUser(User user) {
        System.out.println("First name = " + user.getFirstName());
        System.out.println("Last name = " + user.getLastName());
    }
}
