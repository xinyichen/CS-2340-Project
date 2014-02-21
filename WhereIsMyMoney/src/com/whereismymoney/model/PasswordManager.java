package com.whereismymoney.model;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

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
		Document doc = null;
		try {
			doc = Jsoup.connect("http://192.185.4.36/~zli342/login.php")
					.data("username", username)
					.data("password", password)
					.timeout(15*1000).get();
			String loginResult = (doc.text());
			if (loginResult.equals("Found")) {
			    CurrentUser.getCurrentUser().setUserName(username);
				return true;
			}
		} 
		catch (IOException e) {
			Log.i("fail",e.toString());
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
		Document doc = null;
		try {
			doc = Jsoup.connect("http://192.185.4.36/~zli342/register.php")
					.data("username", username)
					.data("first_name", first_name)
					.data("last_name", last_name)
					.data("password", password)
					.data("email",email)
					.timeout(15*1000).get();
			String loginResult = (doc.text());
			if (loginResult.equals("registered")) {
				return true;
			}
		} 
		catch(IOException e) {
			Log.i("fail",e.toString());
		}
		return false;
	}
}
