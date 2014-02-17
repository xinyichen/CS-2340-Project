package com.whereismymoney.model;

public class CurrentUser {
    private static CurrentUser currentUser;
    private String userName;
    
    // make constructor private to bar external classes from creating new CurrentUser
    private CurrentUser() { userName = null; };
    
    public static synchronized CurrentUser getCurrentUser()
    {
        if (currentUser == null)
            currentUser = new CurrentUser();

        return currentUser;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
