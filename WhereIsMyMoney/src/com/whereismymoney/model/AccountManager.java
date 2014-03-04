package com.whereismymoney.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import android.util.Log;

public class AccountManager {
    
    public List<String> getAccountList() {
        ArrayList<String> ret = new ArrayList<String>();
        try {
            Document doc = Jsoup.connect("http://192.185.4.36/~zli342/get_account_list.php")
                    .data("username", CurrentUser.getCurrentUser().getUserName())
                    .timeout(15*1000).get();
            Elements nameList = doc.select("display_name");  // select by tag name    
            for(Element name : nameList) {
                if(name.hasText() ) {
                    ret.add(name.text());
                }
            }
        } catch (IOException e) {
            Log.i("fail",e.toString());
        }
        return ret;
    }
    
    public Account getAccountInfo(String displayName) {
        try {
            Document doc = Jsoup.connect("http://192.185.4.36/~zli342/get_account_info.php")
                    .data("username", CurrentUser.getCurrentUser().getUserName())
                    .data("account_display_name", displayName)
                    .timeout(15*1000).get();
            // TODO: set up check
            String fullName = doc.select("full_name").first().text();  
            Double balance = Double.parseDouble(doc.select("balance").first().text());
            Double intRate = Double.parseDouble(doc.select("interest_rate").first().text());
            return new Account(fullName, displayName, balance, intRate);
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
