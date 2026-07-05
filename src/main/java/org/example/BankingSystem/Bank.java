package org.example.BankingSystem;

import org.example.BankingSystem.interfaces.Account;

public interface Bank {
    public String addAccount(Account account);
    public String deleteAccount(Account account);
    public String depositAmount(Account account, Double amount);
    public String withdrawAmount(Account account, Double amount);
}
