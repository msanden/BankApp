package com.pyramid.views;

import com.pyramid.controllers.MainController;
import com.pyramid.controllers.UserController;
import com.pyramid.entities.User;
import com.pyramid.utils.Utils;

import java.util.Scanner;

public class MainView {

    private final MainController mainController = new MainController();
    private final UserController userController = new UserController();
    public static User currentUser = null;

    public void printGreeting() {
        System.out.println("Hello!");
    }

    public int enterUserChoice() {
        return Integer.parseInt(Utils.scanner.nextLine());
    }

    public void printMainMenu() {
        System.out.println("1 - Sign In");
        System.out.println("2 - Exit");
    }

    public void signIn() {
        String login;
        String password;

        System.out.println("Please enter your login");
        login = Utils.scanner.nextLine();
        System.out.println("Please enter your password");
        password = Utils.scanner.nextLine();

        if (mainController.isAuthenticate(login, password)) {
            currentUser = userController.getUserByLoginAndPassword(login, password);
        }
    }
}
