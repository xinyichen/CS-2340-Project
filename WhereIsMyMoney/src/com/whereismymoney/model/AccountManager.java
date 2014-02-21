package com.whereismymoney.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import android.util.Log;

public class AccountManager {
    
    public List<String> getAccountList() {
        ArrayList<String> ret = new ArrayList<String>();
        ret.add("a");
        ret.add("b");
        ret.add("c");
        ret.add("d");
        ret.add("e");
        ret.add("f");
        return ret;
    }
    
    public Account getAccountInfo(String displayName) {
        return new Account("trial", displayName, 100.00, 0.05);
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
