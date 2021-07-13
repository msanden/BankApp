import java.util.Date;

public class Transaction {
    /**
     * The amount for this transaction
     */
    private double amount;

    /**
     * The time and date for this transaction
     */
    private Date timestamp;

    /**
     * A message to describe the transaction
     */
    private String message;

    /**
     * The current account the transaction is being performed.
     */
    private Account accountInProgess;

    /**
     * The account number of the user for a single transaction
     */
    private String accountNo;
    /**
     * The location of the bank to print on the transaction slip
     */
    private String location;
    /**
     * The current balance of the User
     */
    private String availableBalance;
}
