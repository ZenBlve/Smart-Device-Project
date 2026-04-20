public class CheckingAccount extends Account implements Transferable {

    public CheckingAccount(String accountNumber, String ownerName, double initialBalance) {
        super(accountNumber, ownerName, initialBalance);
    }

    @Override
    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount <= 0 || amount > getBalance()) {
            throw new InsufficientFundsException(amount, getBalance());
        }
        setBalance(getBalance() - amount);
    }

    @Override
    public void transfer(Account target, double amount) throws InsufficientFundsException {
        if (target == null) {
            throw new IllegalArgumentException("Target account cannot be null");
        }
        this.withdraw(amount);
        target.deposit(amount);
    }

    @Override
    public void displayAccountInfo() {
        System.out.println("Checking | " + getAccountNumber()
                + " | " + getOwnerName()
                + " | $" + getBalance());
    }
}