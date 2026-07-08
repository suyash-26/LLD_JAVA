package org.example.BankingSystem.IDFC;

import org.example.BankingSystem.Bank;
import org.example.BankingSystem.interfaces.Account;

import java.util.HashMap;
import java.util.Map;

public class IDFCBank implements Bank {
    private final Map<String, IDFCAccount> accounts = new HashMap<>();

    @Override
    public String addAccount(Account account) {
        if (!(account instanceof IDFCAccount idfcAccount)) {
            return "Invalid account type for IDFC Bank";
        }
        accounts.put(idfcAccount.getAccountId(), idfcAccount);
        return "Account added";
    }

    @Override
    public String deleteAccount(String accountId) {
        if (accounts.remove(accountId) == null) {
            return "Invalid Account";
        }
        return "Account removed";
    }

    @Override
    public String depositAmount(String accountId, String password, Double amount) {
        IDFCAccount account = accounts.get(accountId);
        if (account == null || !account.matchesPassword(password)) {
            return "Invalid Account";
        }
        return account.deposit(amount);
    }

    @Override
    public String withdrawAmount(String accountId, String password, Double amount) {
        IDFCAccount account = accounts.get(accountId);
        if (account == null || !account.matchesPassword(password)) {
            return "Invalid Account";
        }
        return account.withdraw(amount);
    }

    @Override
    public String checkBalance(String accountId, String password) {
        IDFCAccount account = accounts.get(accountId);
        if (account == null || !account.matchesPassword(password)) {
            return "Invalid Account";
        }
        return "Available Balance: " + account.checkBalance();
    }
}
