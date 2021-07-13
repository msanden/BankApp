import java.util.ArrayList;

public class Bank {

    private String name;
    private ArrayList<User> users;
    private ArrayList<Account> accounts;

    public void addAccount(Account account) {
        this.accounts.add(account);
    }
}
