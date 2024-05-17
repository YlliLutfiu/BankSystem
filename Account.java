import java.util.ArrayList;
import java.util.List;

public class Account {
    private String accountId;
    private String userName;
    private double accountBalance;
    private List<Transaction> transactions;

    public Account(String accountId, String userName, double initialBalance) {
        this.accountId = accountId;
        this.userName = userName;
        this.accountBalance = initialBalance;
        this.transactions = new ArrayList<>();
    }
}