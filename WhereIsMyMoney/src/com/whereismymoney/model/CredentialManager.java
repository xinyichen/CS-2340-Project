package com.whereismymoney.model;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import com.whereismymoney.database.DatabaseConnect;
import com.whereismymoney.service.PasswordHash;

/**
 * This class handles everything associated with logins and user registration.
 */

public class CredentialManager {

	/**
     * Checks to see if the login is valid.
     * 
     * @param username username for login 
     * @param password password for login
     *
     * @return Returns true if the login is valid, false otherwise.
     */
    public boolean login(String username, String password) {
        Document doc = DatabaseConnect.getDatabaseConnect().hashedLogin(username);

        Elements storedPw = doc.select("hashed_password");
        if(storedPw != null) {
        	try {
				if (PasswordHash.validatePassword(password, storedPw.text())) {
					CurrentUser.getCurrentUser().setUserName(username);
		            return true;
				} else {
					return false;
				}
			} catch (NoSuchAlgorithmException e) {
				return false;
			} catch (InvalidKeySpecException e) {
				return false;
			}
        } else {
        	return false;
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
        
        String hashedPassword;
		try {
			hashedPassword = PasswordHash.createHash(password);
	        Document doc = DatabaseConnect.getDatabaseConnect().register(username,
	                first_name, last_name, hashedPassword, email);
	        String registerResult = (doc.text());
	        return registerResult.equals("registered");
		} catch (NoSuchAlgorithmException e) {
			return false;
		} catch (InvalidKeySpecException e) {
			return false;
		}
    }
}
