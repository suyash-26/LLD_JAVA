package org.example.BankingSystem;

import org.example.BankingSystem.interfaces.Account;

public abstract class AbstractAccount implements Account {
    private final String accountId;
    private final String userId;
    private final String password;
    private double balance;

    protected AbstractAccount(String accountId, String userId, String password, double initialBalance) {
        this.accountId = accountId;
        this.userId = userId;
        this.password = password;
        this.balance = initialBalance;
    }

    @Override
    public String getAccountId() {
        return accountId;
    }

    public String getUserId() {
        return userId;
    }

    @Override
    public boolean matchesPassword(String password) {
        return this.password.equals(password);
    }

    @Override
    public String deposit(Double amount) {
        balance += amount;
        return amount + " deposited successfully, Available Balance: " + balance;
    }

    @Override
    public String withdraw(Double amount) {
        if (balance < amount) {
            return "Not enough balance";
        }
        balance -= amount;
        return amount + " withdrawn successfully, Available Balance: " + balance;
    }

    @Override
    public Double checkBalance() {
        return balance;
    }
}
