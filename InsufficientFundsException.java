public class InsufficientFundsException extends Exception {
    public InsufficientFundsException(double amount, double balance) {
        super("Cannot withdraw " + amount + ": insufficient funds. Current balance: " + balance);
    }
}
