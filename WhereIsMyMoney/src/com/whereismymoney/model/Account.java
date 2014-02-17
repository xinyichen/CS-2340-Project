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
        
    public String getMyFullName() {
        return myFullName;
    }

    public String getMyDisplayName() {
        return myDisplayName;
    }

    public double getMyBalance() {
        return myBalance;
    }

    public double getMyInterestRate() {
        return myInterestRate;
    }
}
