package BankProj;

public class BusinessAccount extends Account implements Transferable {

    private double overdraftLimit = 1000.0;

    public BusinessAccount(String accountNumber, String ownerName, double initialBalance) {
        super(accountNumber, ownerName, initialBalance);
    }

    @Override
    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount <= 0 || amount > getBalance() + overdraftLimit) {
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
        System.out.println("Business | " + getAccountNumber()
                + " | " + getOwnerName()
                + " | $" + getBalance()
                + " | Overdraft: 1000");
    }
}
