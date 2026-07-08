package org.example.BankingSystem.IDFC;

import org.example.BankingSystem.interfaces.Account;
import org.example.BankingSystem.interfaces.AccountFactory;

public class IDFCAccountFactory implements AccountFactory {
    @Override
    public Account createAccount(String accountId, String userId, String password, double initialBalance) {
        return new IDFCAccount(accountId, userId, password, initialBalance);
    }
}
