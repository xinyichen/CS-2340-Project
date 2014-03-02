package com.whereismymoney.model;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import android.util.Log;

/**
 * This class handles both types of transactions (withdrawals and deposits)
 * for a given username and account.
 */

public class TransactionManager {
	
	/**
	 * Creates a new withdrawal for the given user's account. 
	 * current timeStamp automatically added by mysql.
	 * Negative balance not allowed.
	 * @param reason
	 * @param expenseCategory
	 * @param amount
	 * @param effectiveDate
	 * @return
	 */
	public boolean newWithdrawal(String reason, String expenseCategory, double amount, String effectiveDate) {
		
		 	Document doc = null;
	    	try {
	    		doc = Jsoup.connect("http://192.185.4.36/~zli342/create_withdrawal.php")
	    				.data("username", CurrentUser.getCurrentUser().getUserName())
	    				.data("account_name", CurrentAccount.getCurrentAccount().getAccountName())
	    				.data("amount", Double.toString(amount))
	    				.data("reason", reason)
	    				.data("category", expenseCategory)
	    				.data("effective_date", effectiveDate)
	    				.timeout(15*1000).get();
	    		String Result = doc.select("body").first().text();
	    		if (Result.equals("success")) {
	    			return true;
	    		}
	    	} 
	    	catch(IOException e) {
	    		Log.i("fail",e.toString());
	    	}
	    	return false;
	   }
	
	
	/**
	 * Creates a new deposit for the given user's account.
	 * current timeStamp automatically added by mysql.
	 * @param source
	 * @param amount
	 * @param effectiveDate
	 * @return
	 */
	public boolean newDeposit(String source, double amount, String effectiveDate) {
		Document doc = null;
    	try {
    		doc = Jsoup.connect("http://192.185.4.36/~zli342/create_deposit.php")
    				.data("username", CurrentUser.getCurrentUser().getUserName())
    				.data("account_name", CurrentAccount.getCurrentAccount().getAccountName())
    				.data("amount", Double.toString(amount))
    				.data("source", source)
    				.data("effective_date", effectiveDate)
    				.timeout(15*1000).get();
    		String Result = doc.select("body").first().text();
    		if (Result.equals("success")) {
    			return true;
    		}
    	} 
    	catch(IOException e) {
    		Log.i("fail",e.toString());
    	}
		return false;
	}
}
