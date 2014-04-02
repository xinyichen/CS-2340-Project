package com.whereismymoney.model;

/**
 * holds information relevant to an account.
 * 
 * @author Xinyi Chen
 * 
 */
public class Account {
    /**
     * This is a private, final String that contains the full name.
     */
    private final String myFullName;
    /**
     * This is a private, final String that contains the display name.
     */
    private final String myDisplayName;
    /**
     * This is a private, final double that contains the balance.
     */
    private final double myBalance;
    /**
     * This is a private, final double that contains the interest rate.
     */
    private final double myInterestRate;
    /**
     * This is the account constructor.
     * @param fullName          This is a String that contains the user's full name.
     * @param displayName       This is a String that contains the display name.
     * @param balance           This is a double that contains the balance.
     * @param interestRate      This is a double that contains the interest rate.
     */
    public Account(String fullName, String displayName, double balance,
            double interestRate) {
        myFullName = fullName;
        myDisplayName = displayName;
        myBalance = balance;
        myInterestRate = interestRate;
    }
    /**
     * This is a getter for the full name.
     * @return      String containing the full name.
     */
    public String getFullName() {
        return myFullName;
    }
    /**
     * This is a getter for the display name.
     * @return      String containing the display name.
     */
    public String getDisplayName() {
        return myDisplayName;
    }
    /**
     * This is a getter for the balance.
     * @return      double containing the balance.
     */
    public double getBalance() {
        return myBalance;
    }
    /**
     * This is a getter for the interest rate.
     * @return      double containing the interest rate.
     */
    public double getInterestRate() {
        return myInterestRate;
    }

    /**
     * Outputs a formatted string that represents the account information.
     * 
     * @param colWidth1
     *            custom-defined column width for display name
     * @param colWidth2
     *            custom-defined column width for balance
     * @param colWidth3
     *            custom-defined column width for interest rate
     * @return a formatted string of account display name, balance, and interest
     *         rate
     */
    public String toString(int colWidth1, int colWidth2, int colWidth3) {
        // input integrity check
        String tooSmall = "";
        if (colWidth1 < myDisplayName.length()) {
            tooSmall += "column 1 ";
        }
        if (colWidth2 < Double.toString(myBalance).length()) {
            tooSmall += "column2 ";
        }
        if (colWidth3 < Double.toString(myInterestRate).length()) {
            tooSmall += "column 3";
        }

        if (tooSmall.length() > 0) {
            throw new IllegalArgumentException(
                    "please define large enough column width for " + tooSmall);
        }

        return String.format("%-" + colWidth1 + "s", myDisplayName)
                + String.format("%-" + colWidth2 + "s", myBalance)
                + String.format("%-" + colWidth3 + "s", myInterestRate);
    }
}
