package com.pyramid.services;

import com.pyramid.DAO.UserDAO;

public class AuthenticationService {
    public UserDAO userDAO = new UserDAO();

    public boolean isAuthenticate(String login, String password) {
        if (userDAO.getUserByLoginAndPassword(login, password) != null) {
            return true;
        }
        return false;
    }
}
