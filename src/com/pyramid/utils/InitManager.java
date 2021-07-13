package com.pyramid.utils;

import com.pyramid.Storage;
import com.pyramid.entities.User;

public class InitManager {

    public void init() {
        User user = new User("John", "Wick");
        user.setLogin("test");
        user.setPassword("123");

        Storage.getUsers().add(user);
    }
}
