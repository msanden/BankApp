package com.pyramid.controllers;

import com.pyramid.services.AuthenticationService;

public class MainController {
    private final AuthenticationService authenticationService = new AuthenticationService();

    public boolean isAuthenticate(String login, String password) {
        return authenticationService.isAuthenticate(login, password);
    }
}
