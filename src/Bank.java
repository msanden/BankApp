import java.util.ArrayList;
import java.util.Random;

public class Bank {

    private String name;
    private ArrayList<User> users;
    private ArrayList<Account> accounts;

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
}
