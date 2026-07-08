package org.example.BankingSystem.interfaces;

public interface Account {
    String getAccountId();
    boolean matchesPassword(String password);
    String withdraw(Double amount);
    String deposit(Double amount);
    Double checkBalance();
}
