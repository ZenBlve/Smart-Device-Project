import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Bank {

    private List<Account> accounts;

    public Bank() {
        accounts = new ArrayList<>();
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public void deleteAccount(String accountNumber) throws AccountNotFoundException {
        Account account = findAccount(accountNumber);
        accounts.remove(account);
    }

    public Account findAccount(String accountNumber) throws AccountNotFoundException {
        for (Account account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        throw new AccountNotFoundException(accountNumber);
    }

    // Returns a read-only view of all accounts (used for polymorphic display)
    public List<Account> findAllAccounts() {
        return Collections.unmodifiableList(accounts);
    }

    public void deposit(String accountNumber, double amount)
            throws AccountNotFoundException, InsufficientFundsException {
        findAccount(accountNumber).deposit(amount);
    }

    public void withdraw(String accountNumber, double amount)
            throws AccountNotFoundException, InsufficientFundsException {
        findAccount(accountNumber).withdraw(amount);
    }

    public void transfer(String fromAccount, String toAccount, double amount)
            throws AccountNotFoundException, InsufficientFundsException {
        Account from = findAccount(fromAccount);
        Account to = findAccount(toAccount);
        from.withdraw(amount);
        to.deposit(amount);
    }
}
