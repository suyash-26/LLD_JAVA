package org.example.BankingSystem.IDFC;

import org.example.BankingSystem.interfaces.Account;
import org.example.BankingSystem.interfaces.AccountFactory;
import org.example.BankingSystem.SBI.SBIAccount;

public class IDFCAccountFactory implements AccountFactory {
    @Override
    public Account getAccount(){
        return new SBIAccount();
    }
}
