public class SavingsAccount extends Account implements Transferable {

    private double interestRate;

    public SavingsAccount(String accountNumber, String ownerName, double initialBalance, double interestRate) {
        super(accountNumber, ownerName, initialBalance);
        this.interestRate = interestRate;
    }

    public void applyInterest() {
        setBalance(getBalance() + (getBalance() * interestRate));
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
        this.withdraw(amount);
        target.deposit(amount);
    }

    @Override
    public void displayAccountInfo() {
        System.out.println("Savings | " + getAccountNumber()
                + " | " + getOwnerName()
                + " | $" + getBalance()
                + " | Rate: " + interestRate);
    }
}
