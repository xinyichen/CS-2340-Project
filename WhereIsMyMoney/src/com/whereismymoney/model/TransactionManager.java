package com.whereismymoney.model;

import java.sql.Timestamp;
import java.util.Date;

/**
 * This class handles both types of transactions (withdrawals and deposits)
 * for a given username and account.
 */

public class TransactionManager {
	
	/**
	 * Creates a new withdrawal for the given user's account
	 * @param reason
	 * @param expenseCategory
	 * @param amount
	 * @param effectiveDate
	 * @return
	 */
	public boolean newWithdrawal(String reason, String expenseCategory, double amount, String effectiveDate) {
		//TODO
		
		//Obviously need username and account which can be gotten by calling the currentUser/Account methods
		//I just wrote the currentAccount method, the current account is being set whenever the user selects an account from the menu
		//or whenever a new account is created. It should work but check in those areas if it doesn't 
		
		
		//You need to do a system generated timestamp also.
		//I figured it would be easier to generate in here than in two separate classes
		//This should be the code you need: http://www.mkyong.com/java/how-to-get-current-timestamps-in-java/
		//I've already imported the classes needed for the timestamp
		return false;
	}
	
	
	/**
	 * Creates a new deposit for the given user's account
	 * @param source
	 * @param amount
	 * @param effectiveDate
	 * @return
	 */
	public boolean newDeposit(String source, double amount, String effectiveDate) {
		//TODO
		
		//Obviously need username and account which can be gotten by calling the currentUser/Account methods
		//I just wrote the currentAccount method, the current account is being set whenever the user selects an account from the menu
		//or whenever a new account is created. It should work but check in those areas if it doesn't
		
		//You need to do a system generated timestamp also.
		//I figured it would be easier to generate in here than in two separate classes
		//This should be the code you need: http://www.mkyong.com/java/how-to-get-current-timestamps-in-java/
		//I've already imported the classes need for the timestamp
		return false;
	}
}
