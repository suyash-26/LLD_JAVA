package org.example.BankingSystem.SBI;

import org.example.BankingSystem.interfaces.Account;
import org.example.BankingSystem.interfaces.AccountFactory;

public class SBIAccountFactory implements AccountFactory {
    @Override
    public Account createAccount(String accountId, String userId, String password, double initialBalance) {
        return new SBIAccount(accountId, userId, password, initialBalance);
    }
}
