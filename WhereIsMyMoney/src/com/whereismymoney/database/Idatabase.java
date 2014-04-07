package com.whereismymoney.database;

import org.jsoup.nodes.Document;

import com.whereismymoney.service.Date;

/**
 * database interface; contains methods needed for interactions with the db
 * @author Zhuoming Li
 * 
 */
public interface Idatabase {

    Document getAllAccounts(String username);

    Document createAccount(String username, String account_display_name,
            String account_full_name, double balance, double interest_rate);

    Document login(String username, String password);
    
    Document hashedLogin(String username);

    Document register(String username, String first_name,
            String last_name, String password, String email);
    
	Document hashedRegister(String username, String first_name,
			String last_name, String password, String email);

    Document generateSpendingCategoryReport(String username, Date start,
            Date end);

    Document newDeposit(String source, double amount,
            String effectiveDate);

    Document newWithdrawal(String reason, String expenseCategory,
            double amount, String effectiveDate);

}
