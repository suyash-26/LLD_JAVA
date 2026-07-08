package org.example.BankingSystem;

import org.example.BankingSystem.interfaces.Account;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ATM {
    private final Map<String, Bank> banksByCode = new HashMap<>();

    public void registerBank(String bankCode, Bank bank) {
        banksByCode.put(bankCode, bank);
    }

    public Set<String> supportedBanks() {
        return banksByCode.keySet();
    }

    public String addAccount(String bankCode, Account account) {
        Bank bank = banksByCode.get(bankCode);
        if (bank == null) {
            return "Bank not supported";
        }
        return bank.addAccount(account);
    }

    public String deleteAccount(String bankCode, String accountId) {
        Bank bank = banksByCode.get(bankCode);
        if (bank == null) {
            return "Bank not supported";
        }
        return bank.deleteAccount(accountId);
    }

    public String deposit(String bankCode, String accountId, String password, Double amount) {
        Bank bank = banksByCode.get(bankCode);
        if (bank == null) {
            return "Bank not supported";
        }
        return bank.depositAmount(accountId, password, amount);
    }

    public String withdraw(String bankCode, String accountId, String password, Double amount) {
        Bank bank = banksByCode.get(bankCode);
        if (bank == null) {
            return "Bank not supported";
        }
        return bank.withdrawAmount(accountId, password, amount);
    }

    public String checkBalance(String bankCode, String accountId, String password) {
        Bank bank = banksByCode.get(bankCode);
        if (bank == null) {
            return "Bank not supported";
        }
        return bank.checkBalance(accountId, password);
    }
}
