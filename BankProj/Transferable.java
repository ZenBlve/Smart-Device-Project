package BankProj;

public interface Transferable {
    void transfer(Account target, double amount) throws InsufficientFundsException;
}
