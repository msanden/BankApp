import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.security.MessageDigest;


/**
 * User class representing a customer/client
 * */

public class User {

    private String firstName;
    private String lastName;
    private byte[] pinNumber;
    private String userID;
    private ArrayList<Account> accounts;

    /** creates a user with a specified name, pinNumber and their atm branch */
    public User(String firstName, String lastName, String pinNumber, Bank atm) {
        this.firstName = firstName;
        this.lastName = lastName;

        /** pin stored as a string hashed using md5 algorithm */
        try {
            MessageDigest cryptPin = MessageDigest.getInstance("MD5");
            this.pinNumber = cryptPin.digest(pinNumber.getBytes());
        } catch (NoSuchAlgorithmException e) {
            System.out.println(" The cryptographic algorithm requested is not available in the environment");
            e.printStackTrace();
            System.exit(1);
        }

        /**generate userID for each user*/
        this.userID = atm.getUserID();
        this.accounts = new ArrayList<Account>();
        System.out.printf("Welcome %s, %s with ID %s created.\n", lastName, firstName, this.userID);
    }

    /** add an account to user's list of accounts */
    public void addAccount(Account account) {
        this.accounts.add(account);
    }
}
