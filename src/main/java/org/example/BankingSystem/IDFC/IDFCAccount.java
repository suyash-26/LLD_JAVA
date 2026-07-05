package org.example.BankingSystem.IDFC;

import org.example.BankingSystem.interfaces.Account;

public class IDFCAccount implements Account {
    public String accountId;
    public String userId;
    public Double balance;
    public String password;
    @Override
    public String deposit(Double amount){
        this.balance+=amount;
        return amount + " deposited successfully Available Balance: " + this.balance;
    }
    @Override
    public String withdraw(Double amount){
        if(balance<amount){
            return "Not enough balance";
        }else{
            this.balance-=amount;
            return amount + " withdrawn successfully, Available Balance: " + this.balance;
        }
    }
    @Override
    public Double checkBalance(){
        return this.balance;
    }
}
