package com.pyramid;

import com.pyramid.entities.User;

import java.util.ArrayList;

public class Storage {

    private ArrayList<User> users;

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }
}
