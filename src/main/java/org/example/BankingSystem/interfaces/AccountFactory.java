package org.example.BankingSystem.interfaces;

public interface  AccountFactory {
    Account createAccount(String accountId, String userId, String password, double initialBalance);
}
