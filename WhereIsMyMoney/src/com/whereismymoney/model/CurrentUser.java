package com.whereismymoney.model;

/**
 * singleton class that holds the current user's name.
 * @author cxy
 *
 */
public class CurrentUser {
	
	/**
	 * Current user variable of type CurrentUser.
	 */
    private static CurrentUser currentUser;
    
    /**
     * String to hold the user name.
     */
    private String userName;
    
    /**
     * Private constructor for class to implement Singleton design pattern.
     */
    private CurrentUser() { userName = null; };
    
    /**
     * Synchronized method to get the current user.
     *
     * @return current user
     */
    public static synchronized CurrentUser getCurrentUser() {
        if (currentUser == null) {
            currentUser = new CurrentUser();
        }

        return currentUser;
    }
    
    /**
     * 
     * @return userName;
     */
    public String getUserName() {
        return userName;
    }
    
    /**
     * Sets the userName to the input String.
     * @param userName				This is a String
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }
}
