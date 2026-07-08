package org.example.BankingSystem.SBI;

import org.example.BankingSystem.AbstractAccount;

public class SBIAccount extends AbstractAccount {
    public SBIAccount(String accountId, String userId, String password, double initialBalance) {
        super(accountId, userId, password, initialBalance);
    }
}
