package com.pyramid.DAO;

import com.pyramid.Storage;
import com.pyramid.entities.User;

import java.util.ArrayList;

public class UserDAO {
    //private Storage storage = Storage;

    public User getUserById(long id) {
        for (User user : Storage.getUsers()) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    public ArrayList<User> getUsers() {
        return Storage.getUsers();
    }

    public void add(User user) {
        Storage.getUsers().add(user);
    }

    public void delete(long id) {
        int index = -1;
        for (int i = 0; i < Storage.getUsers().size(); i++) {
            if (Storage.getUsers().get(i).getId() == id) {
                index = i;
            }
        }
        if (index != -1) {
            Storage.getUsers().remove(index);
        }
    }
}