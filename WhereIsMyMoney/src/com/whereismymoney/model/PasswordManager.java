package com.whereismymoney.model;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import com.whereismymoney.service.persistence.DatabaseConnect;

import android.util.Log;

/**
 * This class handles everything associated with logins
 * and user registration.
 */

public class PasswordManager {
	
    
    /**
     * Checks to see if the login is valid.
     * @param userName 
     * @param password
     * @return Returns true if the login is valid, false otherwise.
     */
    public boolean login(String username, String password){
        	Document doc = DatabaseConnect.getDatabaseConnect().login(username, password);
			String loginResult = (doc.text());
			if (loginResult.equals("Found")) {
			    CurrentUser.getCurrentUser().setUserName(username);
				return true;
			}
			return false;
	}
    
    /**
     * Creates a new user
     * @param username
     * @param password
     * @param email
     * @return True if the user was created, false otherwise
     */
    
    public boolean register(String username, String first_name, String last_name, String password, String email){
    		Document doc = DatabaseConnect.getDatabaseConnect().register( username,  first_name,  last_name,  password,  email);
			String loginResult = (doc.text());
			if (loginResult.equals("registered")) {
				return true;
			}
		
		return false;
	}
    
}
