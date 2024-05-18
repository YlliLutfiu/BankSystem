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

    public void deposit(double amount) {
        if (amount > 0) {
            accountBalance += amount;
            transactions.add(new Transaction(amount, accountId, accountId, "Deposit"));
        } else {
            throw new IllegalArgumentException("Deposit amount must be positive");
        }
    }

    public void withdraw(double amount) throws Exception {
        if (amount > 0 && accountBalance >= amount) {
            accountBalance -= amount;
            transactions.add(new Transaction(amount, accountId, accountId, "Withdrawal"));
        } else {
            throw new Exception("Insufficient funds or invalid amount");
        }
    }

    public String getAccountId() {
        return accountId;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }
}
