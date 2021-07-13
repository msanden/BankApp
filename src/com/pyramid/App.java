package com.pyramid;

import com.pyramid.entities.User;
import com.pyramid.utils.InitManager;
import com.pyramid.views.MainView;

import java.util.ArrayList;

public class App {
    private static MainView mainView;

    public static void main(String[] args) {
        new InitManager().init();
        ArrayList<User> users = Storage.getUsers();
        mainView = new MainView();

        mainView.printGreeting();
        mainView.printMainMenu();
        mainView.signIn();

        if(MainView.currentUser != null) {
            mainView.printUserMenu();
        }

    }
}
