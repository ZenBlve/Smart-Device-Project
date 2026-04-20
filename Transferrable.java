public interface Transferrable{
    void transfer(Account target, double amount) throws InsufficientFundsException;
}
