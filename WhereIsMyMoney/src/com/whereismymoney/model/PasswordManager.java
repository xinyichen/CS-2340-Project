package com.whereismymoney.model;

import org.jsoup.nodes.Document;

import com.whereismymoney.database.DatabaseConnect;

/**
 * This class handles everything associated with logins and user registration.
 */

public class PasswordManager {

    /**
     * Checks to see if the login is valid.
     * 
     * @param username username for login 
     * @param password password for login
     * @return Returns true if the login is valid, false otherwise.
     */
    public boolean login(String username, String password) {
        Document doc = DatabaseConnect.getDatabaseConnect().login(username,
                password);
        String loginResult = (doc.text());
        if (loginResult.equals("Found")) {
            CurrentUser.getCurrentUser().setUserName(username);
            return true;
        }
        return false;
    }

    /**
     * Creates a new user.
     * 
     * @param username new user username
     * @param firstName new user first name
     * @param lastName new user last name
     * @param password new user password
     * @param email new user email address
     * @return True if the user was created, false otherwise
     */

    public boolean register(String username, String firstName,
            String lastName, String password, String email) {
        Document doc = DatabaseConnect.getDatabaseConnect().register(username,
                firstName, lastName, password, email);
        String loginResult = (doc.text());
        if (loginResult.equals("registered")) {
            return true;
        }

        return false;
    }

}
