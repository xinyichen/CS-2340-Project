package com.whereismymoney.model;

public class Account {
    private final String myFullName;
    private final String myDisplayName;
    private final double myBalance;
    private final double myInterestRate;

    public Account(String fullName, String displayName, double balance, double interestRate) {
        myFullName = fullName;
        myDisplayName = displayName;
        myBalance = balance;
        myInterestRate = interestRate;
    }
        
    public String getFullName() {
        return myFullName;
    }

    public String getDisplayName() {
        return myDisplayName;
    }

    public double getBalance() {
        return myBalance;
    }

    public double getInterestRate() {
        return myInterestRate;
    }
}
