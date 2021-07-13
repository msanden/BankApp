package com.pyramid;

import com.pyramid.utils.Initializer;
import com.pyramid.views.MainView;
import com.pyramid.views.UserView;

public class App {
    private static MainView mainView;
    private static UserView userView;

    public static void main(String[] args) {
        new Initializer().init();
        mainView = new MainView();
        userView = new UserView();

        mainView.printGreeting();
        mainView.printMainMenu();
        mainView.signIn();

        if (MainView.currentUser != null) {
            userCycle();
        }


    }

    private static void userCycle() {
        userView.printUserInfo(MainView.currentUser);
        userView.printUserMenu();

        userView.enterUserChoice();

    }
}
