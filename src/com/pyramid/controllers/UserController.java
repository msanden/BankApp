package com.pyramid.controllers;

import com.pyramid.DAO.UserDAO;
import com.pyramid.entities.User;

import java.util.ArrayList;

public class UserController {
    private final UserDAO userDAO = new UserDAO();

    public User getUserById(long id) {
        return userDAO.getUserById(id);
    }

    public ArrayList<User> getUsers() {
        return userDAO.getUsers();
    }

    public void create(String firstName, String lastName) {
        userDAO.add(new User(firstName, lastName));
    }

    public void delete(long id) {
        userDAO.delete(id);
    }
}
