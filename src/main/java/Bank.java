package main.java;

import java.util.ArrayList;
import java.util.Random;

public class Bank {

    private String name;
    private ArrayList<User> users;
    private ArrayList<Account> accounts;

    public Bank(String name) {
        this.name = name;
        this.users = new ArrayList<User>();
        this.accounts = new ArrayList<Account>();
    }

    /** generate random user identifier and check it doesn't already exist in bank's list of users */
    public String generateUserID(){
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
            for (User user : this.users) {
                if(userID.compareTo(user.getUserID()) == 0) {
                    isNotUnique = true;
                    break;
                }
            }
        } while (isNotUnique);

        return userID.toString();
    }

    /** generate random account identifier and check it doesn't already exist in our bank's of accounts */
    public String generateAccountID(){
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
            for (Account account : this.accounts) {
                if(accountID.compareTo(account.getAccountID()) == 0) {
                    isNotUnique = true;
                    break;
                }
            }
        } while (isNotUnique);

        return accountID.toString();
    }

    public void addAccount(Account account) {
        this.accounts.add(account);
    }


    public User addUser(String firstName, String lastName, String pin) {

        //add user to bank's list of clients
        User user = new User(firstName, lastName, pin, this);
        this.users.add(user);

        //create savings account for the user
        Account account = new Account("Savings", user, this);
        user.addAccount(account);
        this.accounts.add(account);

        return user;
    }

    public String getName(){
        return this.name;
    }

    public User userLogin(String userID, String pin) {
        //return user with matching pin
        for (User user : users) {
            if(user.getUserID().compareTo(userID) == 0 && user.isPinValid(pin)) {
                return user;
            }
        }
        return null;
    }
}
