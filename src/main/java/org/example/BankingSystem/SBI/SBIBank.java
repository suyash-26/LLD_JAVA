package org.example.BankingSystem.SBI;

import org.example.BankingSystem.Bank;
import org.example.BankingSystem.interfaces.Account;

import java.util.List;

public class SBIBank implements Bank {
    List<SBIAccount> accounts;
    @Override
    public String addAccount(Account account){
        accounts.add((SBIAccount) account);
        return "Account added";
    }
    @Override
    public String deleteAccount(Account account){
        accounts.remove((SBIAccount) account);
        return "Account removed";
    }
    @Override
    public String depositAmount(Account account, Double amount){
        SBIAccount existingAccount = null;
        for(int i=0;i<accounts.size();i++){
            if(((SBIAccount)account).password.equals(accounts.get(i).password)){
                existingAccount = (SBIAccount) account;
                break;
            }
        }
        if(existingAccount != null){
            return existingAccount.deposit(amount);
        }
        return "Invalid Account";
    }
    @Override
    public String withdrawAmount(Account account, Double amount){
        return "Sorry";
    }
}
