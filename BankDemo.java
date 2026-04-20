public class BankDemo {

    public static void main(String[] args) {
        Bank bank = new Bank();

        CheckingAccount checking = new CheckingAccount("CHK-001", "Ivan Petrov", 500.00);
        SavingsAccount savings   = new SavingsAccount("SAV-001", "Ivan Petrov", 1000.00, 0.05);
        BusinessAccount business = new BusinessAccount("BIZ-001", "Petrov Enterprises", 2000.00);
        CheckingAccount alice    = new CheckingAccount("CHK-002", "Alice Smith", 750.00);

        bank.addAccount(checking);
        bank.addAccount(savings);
        bank.addAccount(business);
        bank.addAccount(alice);
        System.out.println("Initial Account Info");
        bank.findAllAccounts().forEach(Account::displayAccountInfo);
        System.out.println();

        System.out.println("Normal Transactions");

        try {
            bank.deposit("CHK-001", 200.00);
            System.out.println("Deposited $200 into CHK-001");

            bank.withdraw("SAV-001", 150.00);
            System.out.println("Withdrew $150 from SAV-001");

            bank.transfer("CHK-001", "CHK-002", 100.00);
            System.out.println("Transferred $100 from CHK-001 to CHK-002");

        } catch (AccountNotFoundException | InsufficientFundsException e) {
            System.out.println("Unexpected error: " + e.getMessage());
        }

        System.out.println();

        System.out.println("Transferable Interface Demo");

        Transferable transferableAccount = savings;
        try {
            transferableAccount.transfer(checking, 50.00);
            System.out.println("Transferred $50 from SAV-001 to CHK-001 via Transferable interface");
        } catch (InsufficientFundsException e) {
            System.out.println("Transfer failed: " + e.getMessage());
        }

        System.out.println();
        System.out.println("Applying Interest to Savings Account");
        System.out.print("Before: ");
        savings.displayAccountInfo();
        savings.applyInterest();
        System.out.print("After:  ");
        savings.displayAccountInfo();
        System.out.println();
        System.out.println("Business Account Overdraft");
        try {
            bank.withdraw("BIZ-001", 2500.00);
            System.out.println("Withdrew $2500 from BIZ-001 (used overdraft)");
            bank.findAccount("BIZ-001").displayAccountInfo();
        } catch (AccountNotFoundException | InsufficientFundsException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println();
        System.out.println("Exception Demo 1: InsufficientFundsException");
        try {
            bank.withdraw("CHK-001", 999999.00);
        } catch (InsufficientFundsException e) {
            System.out.println("Caught InsufficientFundsException: " + e.getMessage());
        } catch (AccountNotFoundException e) {
            System.out.println("Unexpected: " + e.getMessage());
        }

        System.out.println();
        System.out.println("Exception Demo 2: AccountNotFoundException");
        try {
            bank.withdraw("FAKE-999", 100.00);
        } catch (AccountNotFoundException e) {
            System.out.println("Caught AccountNotFoundException: " + e.getMessage());
        } catch (InsufficientFundsException e) {
            System.out.println("Unexpected: " + e.getMessage());
        }

        System.out.println();
        System.out.println("Delete Account Demo");
        try {
            bank.deleteAccount("CHK-002");
            System.out.println("Deleted account CHK-002");
            bank.findAccount("CHK-002");
        } catch (AccountNotFoundException e) {
            System.out.println("Confirmed deleted — " + e.getMessage());
        }

        System.out.println();
        System.out.println("Final Account Balances");
        bank.findAllAccounts().forEach(Account::displayAccountInfo);
    }
}
