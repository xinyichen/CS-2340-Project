package com.whereismymoney.model;

import android.content.Context;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

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
    
    // ToCheck: format here is good but got somehow destroyed in activity
    public String toString(int colWidth1, int colWidth2, int colWidth3) {
        return String.format("%-" + colWidth1 + "s", myDisplayName) +
                String.format("%-" + colWidth2 + "s", myBalance) + 
                String.format("%-" + colWidth3 + "s", myInterestRate);
    }
}
