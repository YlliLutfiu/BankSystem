import java.util.ArrayList;
import java.util.List;

public class Bank {
    private String bankName;
    private List<Account> accountsList;
    private double totalTransactionFees;
    private double totalTransferAmount;
    private double transactionFlatFee;
    private double transactionPercentFee;

    public Bank(String bankName, double transactionFlatFee, double transactionPercentFee) {
        this.bankName = bankName;
        this.accountsList = new ArrayList<>();
        this.transactionFlatFee = transactionFlatFee;
        this.transactionPercentFee = transactionPercentFee;
    }

    public void createAccount(String accountId, String userName, double initialBalance) {
        accountsList.add(new Account(accountId, userName, initialBalance));
    }

    public Account findAccount(String accountId) {
        for (Account account : accountsList) {
            if (account.getAccountId().equals(accountId)) {
                return account;
            }
        }
        throw new IllegalArgumentException("Account not found");
    }

    public void performTransaction(String fromAccountId, String toAccountId, double amount, boolean isFlatFee) throws Exception {
        Account fromAccount = findAccount(fromAccountId);
        Account toAccount = findAccount(toAccountId);

        double fee = isFlatFee ? transactionFlatFee : amount * transactionPercentFee / 100;
        double totalAmount = amount + fee;

        fromAccount.withdraw(totalAmount);
        toAccount.deposit(amount);

        totalTransactionFees += fee;
        totalTransferAmount += amount;

        fromAccount.getTransactions().add(new Transaction(amount, fromAccountId, toAccountId, "Transfer to " + toAccountId));
        toAccount.getTransactions().add(new Transaction(amount, fromAccountId, toAccountId, "Transfer from " + fromAccountId));
    }

    public void withdraw(String accountId, double amount) throws Exception {
        Account account = findAccount(accountId);
        account.withdraw(amount);
    }

    public void deposit(String accountId, double amount) {
        Account account = findAccount(accountId);
        account.deposit(amount);
    }
    
}
