**Assignment: Banking System**

### **Team Member Name / Discord**

Artyn (Irazan)
Paul (strikefo)
Ivan (Zoxic)
Chris (Cold)


This project implements a banking system using the Java programming language.

The system includes a class, named Bank, which manages a collection of accounts that are then
stored by means of a list, thus allowing different account types to be handled polymorphically.

An abstract class (Account) defines information such as account number, the owner's name,
the balance, deposits, and withdrawals as part of an account. Three classes extend from
Account; those being CheckingAccount,  SavingsAccount, and BusinessAccount.
Each provides its own implementation of withdrawing.

An interface (Transferable) is implemented by CheckingAccount and BusinessAccount, allowing those
account types to transfer funds. SavingsAccount, however, does not have this interface implemented.

Exceptions are used to handle errors, should any come up.
InsufficientFundsException is thrown when a withdrawal or transfer
exceeds the available balance, and AccountNotFoundException is
thrown when an account can't be found.
