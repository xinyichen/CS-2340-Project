package com.whereismymoney.model;

import org.jsoup.nodes.Document;

import com.whereismymoney.database.DatabaseConnect;
import com.whereismymoney.service.PasswordHash;

/**
 * This class handles everything associated with logins and user registration.
 */

public class PasswordManager {
    private PasswordHash hasher;

    public PasswordManager() {
        hasher = new PasswordHash();
    }

    /**
     * Checks to see if the login is valid.
     * 
     * @param username username for login 
     * @param password password for login
     *
     * @return Returns true if the login is valid, false otherwise.
     */
    public boolean login(String username, String password) {
        //TODO: get the hash from the server


        Document doc = DatabaseConnect.getDatabaseConnect().login(username,
                password);


        String loginResult = (doc.text());
        if(loginResult.equals("Not found")) {
            return false;
        } else if(hasher.validatePassword(password, loginResult)) {
            CurrentUser.getCurrentUser().setUserName(username);
            return true;
        } else {
            return false
        }
    }

    /**
     * Creates a new user.
     * 
     * @param username new user username
     * @param first_name new user first name
     * @param last_name new user last name
     * @param password new user password
     * @param email new user email address
     *
     * @return True if the user was created, false otherwise
     */

    public boolean register(String username, String first_name,
            String last_name, String password, String email) {
        
        String hashedPassword = hasher.createHash(password);

        Document doc = DatabaseConnect.getDatabaseConnect().hashedRegister(username,
                first_name, last_name, hashedPassword, email);
        String registerResult = (doc.text());
        if (registerResult.equals("registered")) {
            return true;
        }

        return false;
    }
}