public class Transaction{
    private double amount;
    private String originatingAccountId;
    private String resultingAccountId;
    private String transactionReason;

    public Transaction(double amount, String originatingAccountId, String resultingAccountId, String transactionReason) {
        this.amount = amount;
        this.originatingAccountId = originatingAccountId;
        this.resultingAccountId = resultingAccountId;
        this.transactionReason = transactionReason;
    }
}