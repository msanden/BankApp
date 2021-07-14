package com.pyramid;

import com.pyramid.entities.AccountType;
import com.pyramid.entities.User;
import com.pyramid.utils.Initializer;
import com.pyramid.views.MainView;
import com.pyramid.views.UserView;

public class App {
    private static MainView mainView;
    private static UserView userView;
    private static User currentUser;

    public static void main(String[] args) {
        new Initializer().init();
        mainView = new MainView();
        userView = new UserView();

        mainView.printGreeting();
        mainView.printMainMenu();

        signInCycle();
        userCycle();
    }

    private static void signInCycle() {
        do {
            currentUser = mainView.signIn();

            if (currentUser == null) {
                System.out.println("Error!");
            }
        } while (currentUser == null);
    }

    private static void userCycle() {
        int userChoice;
        do {
            userView.printUserInfo(currentUser);
            userView.printUserAccountsMenu();
            userChoice = userView.getUserChoice();

            switch (userChoice) {
                case 1:
                    userAccountCycle(AccountType.CHECKING);
                    break;
                case 2:
                    userAccountCycle(AccountType.SAVING);
                    break;
                case 3:
                    //
                    break;
                default:
                    System.out.println("Error!");
            }
        } while (userChoice <= 0 || userChoice > 4);
    }

    private static void userAccountCycle(AccountType accountType) {
        int userChoice;
        do {
            userView.printUserInfo(currentUser);
            userView.printUserAccountMenu();
            userChoice = userView.getUserChoice();

            switch (userChoice) {
                case 1:
                    userView.printAccountHistory(accountType);
                    break;
                case 2:
                    userView.printWithdrawMenu(accountType);
                    break;
                case 3:
                    userView.printDepositMenu(accountType);
                    break;
                case 4:
                    userView.printTransferMenu(accountType);
                    break;
                case 5:
                    //
                    break;
                default:
                    System.out.println("Error!");
            }
        } while (userChoice != 5);
    }
}

