package main.java;

import java.util.ArrayList;
import java.util.Random;

public class Bank {
    private String name;
    private ArrayList<User> users;
    private ArrayList<Account> accounts;

    public Bank(String name) {
        this.name = name;

        users = new ArrayList<User>();
        accounts = new ArrayList<Account>();
    }

    /**
     * generate random user identifier and check it doesn't already exist in bank's list of users
     */
    public String generateUserID() {
        String userID;
        Random random = new Random();
        int len = 7;
        boolean isNotUnique;

        do {
            userID = "";

            /** generate a string of length 7, made of integers in range 0-9 */
            for (int i = 0; i < len; i++) {
                userID += ((Integer) random.nextInt(10)).toString();
            }

            // if generated string exists set flag to true, break to generate unique string
            isNotUnique = false;
            for (User user : users) {
                if (userID.compareTo(user.getUserID()) == 0) {
                    isNotUnique = true;
                    break;
                }
            }
        } while (isNotUnique);

        return userID;
    }

    /**
     * generate random account identifier and check it doesn't already exist in our bank's of accounts
     */
    public String generateAccountID() {
        String accountID;
        Random random = new Random();
        int len = 10;
        boolean isNotUnique;

        do {
            accountID = "";

            /** generate a string of length 7, made of integers in range 0-9 */
            for (int i = 0; i < len; i++) {

                accountID += ((Integer) random.nextInt(10)).toString();
            }

            // if generated string exists set flag to true, break to generate unique string
            isNotUnique = false;
            for (Account account : accounts) {
                if (accountID.compareTo(account.getId()) == 0) {
                    isNotUnique = true;
                    break;
                }
            }
        } while (isNotUnique);

        return accountID;
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public User addUser(String firstName, String lastName, String pin) {

        // create a new User object and add it to our list
        User user = new User(firstName, lastName, pin, this);
        this.users.add(user);

        // create a savings account for the user and add it to our list
        Account account = new Account("Savings", user, this);
        user.addAccount(account);
        accounts.add(account);

        return user;
    }

    public User userLogin(String userID, String pin) {

        for (User user : users) {

            // if we find the user, and the pin is correct, return User object
            if (user.getUserID().compareTo(userID) == 0 && user.validatePin(pin)) {
                return user;
            }
        }

        // if we haven't found the user or have an incorrect pin, return null
        return null;
    }

    public String getName() {
        return name;
    }
}
