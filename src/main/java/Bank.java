package main.java;

import java.util.ArrayList;
import java.util.Random;

public class Bank {

    private String name;
    private ArrayList<User> users;
    private ArrayList<Account> accounts;
    //private ArrayList<Transaction> transactions;

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
    /*
    // generate random transaction number and check if it doesn't already exist in our bank's transactions
    public String generateUniqueTransactionNumber(){
        String utn;
        Random randomNumber = new Random();
        int lengthOfTransNumber = 10;
        boolean isNotUnique;
        do {
            utn = "";
            for(int character = 0; character < lengthOfTransNumber; character++) {
                utn += ((Integer) randomNumber.nextInt(10)).toString();
            }
            //go through all transactions in the transactions arraylist and compare the id
            //if it is equal then we have to keep making a new unique transaction number
            // if generated string exists set flag to true, break to generate unique string
            isNotUnique = false;
            for (Transaction transaction : this.transactions) {
                if(utn.compareTo(transaction.getAccountNo()) == 0) {
                    isNotUnique = true;
                    break;
                }
            }
        } while (isNotUnique);

        return utn.toString();
}
*/
    public void addAccount(Account account) {
        this.accounts.add(account);
    }
}
