public abstract class Account {

    private String accountNumber;
    private String ownerName;
    private double balance;

    public Account(String accountNumber, String ownerName, double initialBalance) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = initialBalance;
    }

    public void deposit(double amount) throws InsufficientFundsException {
        if (amount <= 0) {
            throw new InsufficientFundsException(amount, balance);
        }
        balance += amount;
    }

    public abstract void withdraw(double amount) throws InsufficientFundsException;

    public abstract void displayAccountInfo();

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public double getBalance() {
        return balance;
    }

    protected void setBalance(double balance) {
        this.balance = balance;
    }
}
