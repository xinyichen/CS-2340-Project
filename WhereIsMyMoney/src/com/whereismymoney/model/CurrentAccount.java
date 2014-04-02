package com.whereismymoney.model;

/**
 * This class keeps track of the current account 
 * for purposes of accurately attributing 
 * transactions to the correct account.
 */

public class CurrentAccount {
	
	/**
	 * holds current account as type CurrentAccount.
	 */
    private static CurrentAccount currentAccount;
    
    /**
     * String to hold the account name.
     */
    private String accountName;
    
    /**
     * Private constructor to implement the Singleton design pattern.
     */
    private CurrentAccount() { 
    	accountName = null; 
    }
    
    /**
     * Synchoronized getter method to get the current account.
     * @return currentAccount
     */
    public static synchronized CurrentAccount getCurrentAccount()
    {
        if (currentAccount == null) {
            currentAccount = new CurrentAccount();
        }

        return currentAccount;
    }
    
    /**
     * Returns the current account's name.
     * @return The account name
     */
    public String getAccountName() {
        return accountName;
    }

    /**
     * Sets the current account's name.
     * @param accountName		This is a String.
     */
    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }
}