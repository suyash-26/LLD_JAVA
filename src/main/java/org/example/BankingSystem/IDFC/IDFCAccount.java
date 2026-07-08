package org.example.BankingSystem.IDFC;

import org.example.BankingSystem.AbstractAccount;

public class IDFCAccount extends AbstractAccount {
    public IDFCAccount(String accountId, String userId, String password, double initialBalance) {
        super(accountId, userId, password, initialBalance);
    }
}
