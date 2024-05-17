public class Bank {
    private String bankName;
    private List<Account> accountsList;
    private double totalTransactionFees;
    private double totalTransferAmount;
    private double transactionFlatFee;
    private double transactionPercentFee;

    public Bank(String bankName, double TransactionFlatFee, double transactionPercentFee) {
        this.bankName = bankName;
        this.accountsList = new ArrayList<>();
        this.transactionFlatFee = transactionFlatFee;
        this.transactionPercentFee = transactionPercentFee;
    }
}