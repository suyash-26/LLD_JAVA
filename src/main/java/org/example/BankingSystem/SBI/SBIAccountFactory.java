package org.example.BankingSystem.SBI;

import org.example.BankingSystem.interfaces.Account;
import org.example.BankingSystem.interfaces.AccountFactory;

public class SBIAccountFactory implements AccountFactory {
    @Override
    public Account getAccount(){
        return new SBIAccount();
    }
}
