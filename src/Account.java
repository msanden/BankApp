import java.util.ArrayList;

public class Account {
    private String name;
    private String accountID;
    private User accHolder;
    private ArrayList<Transaction> transactionHistory;

    public Account(String name, User accHolder, Bank bank) {
        this.name = name;
        this.accHolder = accHolder;
        this.accountID = bank.generateAccountID();
        this.transactionHistory = new ArrayList<Transaction>();
        accHolder.addAccount(this);
        bank.addAccount(this);
    }

    public String getAccountID() {
        return this.accountID;
    }
}
