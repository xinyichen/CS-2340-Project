package com.whereismymoney.model;

import java.util.ArrayList;
import java.util.List;

public class AccountManager {
    
    public List<String> getAccountList() {
        ArrayList<String> ret = new ArrayList<String>();
        ret.add("a");
        ret.add("b");
        ret.add("c");
        ret.add("d");
        ret.add("e");
        ret.add("f");
        return ret;
    }
    
    public Account getAccountInfo(String displayName) {
        return new Account("trial", displayName, 100.00, 0.05);
    }
    
    public boolean createAccount(String fullName, String disPlayName, double balance, double interestRate) {
        return true;
    }

}
