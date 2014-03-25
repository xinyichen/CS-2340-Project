package com.whereismymoney.model;

import org.jsoup.nodes.Document;

import com.whereismymoney.database.DatabaseConnect;

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
		
		Document doc = DatabaseConnect.getDatabaseConnect().newWithdrawal(reason, expenseCategory,  amount,  effectiveDate);
	    		String Result = doc.select("body").first().text();
	    		if (Result.equals("success")) {
	    			return true;
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
		Document doc = DatabaseConnect.getDatabaseConnect().newDeposit( source,  amount,  effectiveDate);
    		String Result = doc.select("body").first().text();
    		if (Result.equals("success")) {
    			return true;
    		}
		return false;
	}
}
