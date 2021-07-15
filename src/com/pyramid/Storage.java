package com.pyramid;

import com.pyramid.entities.User;

import java.util.ArrayList;

public class Storage {

    private static ArrayList<User> users;

    public static ArrayList<User> getUsers() {
        if (users == null) {
            users = new ArrayList<>();
        }
        return users;
    }

    public static long getNewId() {
        ArrayList<User> users = getUsers();
        if (users.size() > 0) {
            return users.get(users.size() - 1).getId() + 1;
        }
        return 0;
    }

}
