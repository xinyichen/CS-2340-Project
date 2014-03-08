package com.whereismymoney.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import android.util.Log;

public class AccountManager {
    
    // return a list of all accounts of a given user
    public List<Account> getAllAccounts(String username) {
        List<Account> accountList = new ArrayList<Account>();
        
        try {
            Document doc = Jsoup.connect("http://192.185.4.36/~zli342/get_account_info.php")
                    .data("username", username)
                    .timeout(15*1000).get();
            // TODO: set up check
            Elements fullNameList = doc.select("full_name");  
            Elements displayNameList = doc.select("display_name");  
            Elements balanceList = doc.select("balance");
            Elements intRateList = doc.select("interest_rate");
            
            // extract and pack the information pertain to the current account
            for (int i = 0; i < fullNameList.size(); i++) {
                String fullName = fullNameList.get(i).text();
                String displayName = displayNameList.get(i).text();
                Double balance = Double.parseDouble(balanceList.get(i).text());
                Double intRate = Double.parseDouble(intRateList.get(i).text());
                accountList.add(new Account(fullName, displayName, balance, intRate));
            }
            return accountList;
        } catch (IOException e) {
            Log.i("fail",e.toString());
            return null;
        }
    }
    
    public boolean createAccount(String username, String account_display_name, String account_full_name, double balance, double interest_rate) {
    	Document doc = null;
    	try {
    		doc = Jsoup.connect("http://192.185.4.36/~zli342/create_account.php")
    				.data("username", username)
    				.data("account_display_name", account_display_name)
    				.data("account_full_name", account_full_name)
    				.data("balance", Double.toString(balance))
    				.data("interest_rate", Double.toString(interest_rate))
    				.timeout(15*1000).get();
    		String loginResult = (doc.text());
    		if (loginResult.equals("account created")) {
    			//setting the current account for transaction purposes
    			CurrentAccount.getCurrentAccount().setAccountName(account_display_name);
    			return true;
    		}
    	} 
    	catch(IOException e) {
    		Log.i("fail",e.toString());
    	}
    	return false;
    }
}
