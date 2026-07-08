package org.example.BankingSystem;

import org.example.BankingSystem.interfaces.Account;

public interface Bank {
    String addAccount(Account account);
    String deleteAccount(String accountId);
    String depositAmount(String accountId, String password, Double amount);
    String withdrawAmount(String accountId, String password, Double amount);
    String checkBalance(String accountId, String password);
}
