import java.util.Scanner;

public class BankSystemApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Bank bank = new Bank("MyBank", 10.0, 5.0);

        initializeSampleData(bank);

        while (true) {
            System.out.println("Bank System Menu:");
            System.out.println("Press 1 to create Account");
            System.out.println("Press 2 to Deposit");
            System.out.println("Press 3 to Withdraw");
            System.out.println("Press 4 to Transfer");
            System.out.println("Press 5 to check Account Balance");
            System.out.println("Press 6 to check Bank Total Fees and Transfers");
            System.out.println("Press 7 to view Account Transactions");
            System.out.println("Press 8 to Exit");
            System.out.print("Please choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            try {
                switch (choice) {
                    case 1:
                        createAccount(bank, scanner);
                        break;
                    case 2:
                        performDeposit(bank, scanner);
                        break;
                    case 3:
                        performWithdrawal(bank, scanner);
                        break;
                    case 4:
                        performTransfer(bank, scanner);
                        break;
                    case 5:
                        checkAccountBalance(bank, scanner);
                        break;
                    case 6:
                        checkBankSummary(bank);
                        break;
                    case 7:
                        viewAccountTransactions(bank, scanner);
                        break;
                    case 8:
                        System.out.println("Exiting...");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private static void initializeSampleData(Bank bank) {
        bank.createAccount("A001", "Alice", 1000.0);
        bank.createAccount("A002", "Bob", 500.0);
    }

    private static void createAccount(Bank bank, Scanner scanner) {
        System.out.print("Enter Account ID: ");
        String accountId = scanner.nextLine();
        System.out.print("Enter User Name: ");
        String userName = scanner.nextLine();
        System.out.print("Enter Initial Balance: ");
        double initialBalance = scanner.nextDouble();
        scanner.nextLine();

        bank.createAccount(accountId, userName, initialBalance);
        System.out.println("Account created successfully.");
    }

    private static void performDeposit(Bank bank, Scanner scanner) {
        System.out.print("Enter Account ID: ");
        String accountId = scanner.nextLine();
        System.out.print("Enter Deposit Amount: ");
        double depositAmount = scanner.nextDouble();
        scanner.nextLine();

        bank.deposit(accountId, depositAmount);
        System.out.println("Deposit successful.");
    }

    private static void performWithdrawal(Bank bank, Scanner scanner) {
        System.out.print("Enter Account ID: ");
        String accountId = scanner.nextLine();
        System.out.print("Enter Withdraw Amount: ");
        double withdrawAmount = scanner.nextDouble();
        scanner.nextLine();

        try {
            bank.withdraw(accountId, withdrawAmount);
            System.out.println("Withdrawal successful.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void performTransfer(Bank bank, Scanner scanner) {
        System.out.print("Enter From Account ID: ");
        String fromAccountId = scanner.nextLine();
        System.out.print("Enter To Account ID: ");
        String toAccountId = scanner.nextLine();
        System.out.print("Enter Transfer Amount: ");
        double transferAmount = scanner.nextDouble();
        System.out.print("Use Flat Fee (true/false): ");
        boolean isFlatFee = scanner.nextBoolean();
        scanner.nextLine();

        try {
            bank.performTransaction(fromAccountId, toAccountId, transferAmount, isFlatFee);
            System.out.println("Transfer successful.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void checkAccountBalance(Bank bank, Scanner scanner) {
        System.out.print("Enter Account ID: ");
        String accountId = scanner.nextLine();
        Account account = bank.findAccount(accountId);
        System.out.println("Account Balance: " + account.getAccountBalance());
    }

    private static void checkBankSummary(Bank bank) {
        System.out.println("Total Transaction Fees: " + bank.getTotalTransactionFees());
        System.out.println("Total Transfer Amount: " + bank.getTotalTransferAmount());
    }

    private static void viewAccountTransactions(Bank bank, Scanner scanner) {
        System.out.print("Enter Account ID: ");
        String accountId = scanner.nextLine();
        Account account = bank.findAccount(accountId);
        for (Transaction transaction : account.getTransactions()) {
            System.out.println("Transaction: " + transaction.getTransactionReason() + ", Amount: " + transaction.getAmount());
        }
    }
}
