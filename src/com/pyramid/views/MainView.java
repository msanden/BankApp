package com.pyramid.views;

import com.pyramid.controllers.MainController;

import java.util.Scanner;

public class MainView {
    private final Scanner scanner = new Scanner(System.in);
    private final MainController mainController = new MainController();

    public void printGreeting() {
        System.out.println("Hello!");
    }

    public boolean isAuthenticate() {
        String login = null;
        String password = null;

        System.out.println("Please enter your login");
        login = scanner.nextLine();
        System.out.println("Please enter your password");
        password = scanner.nextLine();

        return mainController.isAuthenticate(login, password);
    }
}
