package com.pyramid;

import com.pyramid.entities.User;

import java.util.ArrayList;

public class Storage {

    private static ArrayList<User> users;

    public static ArrayList<User> getUsers() {
        if(users == null) {
            return new ArrayList<>();
        }
        return users;
    }

}
