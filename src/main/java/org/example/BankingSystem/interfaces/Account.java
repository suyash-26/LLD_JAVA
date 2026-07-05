package org.example.BankingSystem.interfaces;

public interface Account {
    String withdraw(Double amount);
    String deposit(Double amount);
    Double checkBalance();
}
