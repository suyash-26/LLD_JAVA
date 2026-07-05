package org.example.BankingSystem.interfaces;

public interface AccountFactory {
    Account getAccount();
    default String withdraw(Double amount){
        Account account = getAccount();
        return account.withdraw(amount);
    }
    String deposit(Double amount);
    Double checkBalance();
}
