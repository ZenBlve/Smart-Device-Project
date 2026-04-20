**Assignment: Banking System**

### **Team Member Name / Discord**

Artyn (lrazan)
Paul (strikefo)
Ivan (Zoxic)
Chris (Cold)

### **Project Overview**

Design and implement a **Banking System** in Java using object-oriented programming principles. Your program should model a bank that manages different types of accounts and allows customers to perform financial transactions.

### **Requirements**

Your solution must include:

* multiple classes  
* inheritance  
* at least one abstract base class  
* at least one interface  
* method overriding and runtime polymorphism  
* exceptions for invalid operations  
* proper encapsulation  
* separate class files

### **Core Idea**

A bank manages different types of accounts, such as checking accounts, savings accounts, and other account types you choose. These accounts share common behavior, but they also have account-specific rules and features. The system should be able to manage a collection of accounts and perform operations on them.

### **Minimum Requirements**

#### **1\. Account Hierarchy**

Create an abstract base class representing a generic bank account.

Then create several derived classes representing specific account types.

Examples:

* CheckingAccount  
* SavingsAccount  
* BusinessAccount  
* CreditAccount

You may choose your own account types.

#### **2\. Interface**

Create at least one interface.

Examples:

* `Transferable` for accounts that can transfer money  
* `InterestBearing` for accounts that earn interest  
* `LoanEligible` for accounts that can request loans

Some, but not necessarily all, account types should implement the interface.

#### **3\. Bank Class**

Create a class that manages all accounts in the system.

This class should store accounts polymorphically and provide operations such as:

* adding accounts  
* finding accounts  
* depositing money  
* withdrawing money  
* transferring money  
* displaying account information

#### **4\. Exceptions**

Create and use custom exception classes for invalid situations.

Examples might include:

* account not found  
* insufficient funds  
* invalid transaction amount  
* unsupported operation

You should decide what exceptions make sense for your design.

#### **5\. Demonstration**

Your `main()` method must demonstrate:

* creating multiple account objects  
* storing and using them polymorphically  
* calling overridden methods  
* at least one interface in action  
* at least two exceptions being thrown and caught

### **Design Constraints**

Your program must have:

* at least 6 classes total  
* at least 3 concrete derived classes  
* at least 1 abstract base class  
* at least 1 interface  
* at least 2 custom exception classes

### **Submission**

Submit:

* all `.java` files  
* a short `README` explaining your design  
* sample output from running your program

### **Notes**

You are responsible for deciding:

* what classes are needed  
* what data each class should store  
* what methods belong in each class  
* which classes should inherit from others  
* which classes should implement the interface  
* what exceptions should exist and when they should be thrown

Your design will be graded on correctness, object-oriented design, and code quality.