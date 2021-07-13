package com.pyramid.controllers;

import com.pyramid.DAO.UserDAO;
import com.pyramid.entities.User;

import java.util.ArrayList;

public class UserController {
    private final UserDAO userDAO = new UserDAO();

    public User getUserById(long Id) {
        return userDAO.getUserById(Id);
    }

    public ArrayList<User> getUsers() {
        return userDAO.getUsers();
    }

    public void create(String firstName, String lastName) {
        userDAO.add(new User(firstName, lastName));
    }

    public void delete(long Id) {
        userDAO.delete(Id);
    }
}
