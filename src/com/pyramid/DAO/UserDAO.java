package com.pyramid.DAO;

import com.pyramid.Storage;
import com.pyramid.entities.User;

import java.util.ArrayList;

public class UserDAO {
    private Storage storage;

    public User getUserById(long Id) {
        for (User user : storage.getUsers()) {
            if (user.getId() == Id) {
                return user;
            }
        }
        return null;
    }

    public ArrayList<User> getUsers() {
        return storage.getUsers();
    }

    public void add(User user) {
        storage.getUsers().add(user);
    }

    public void delete(long Id) {
        int index = -1;
        for (int i = 0; i < storage.getUsers().size(); i++) {
            if (storage.getUsers().get(i).getId() == Id) {
                index = i;
            }
        }
        if (index != -1) {
            storage.getUsers().remove(index);
        }
    }
}