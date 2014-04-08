package com.whereismymoney.database;

import org.jsoup.nodes.Document;

import com.whereismymoney.model.User;
import com.whereismymoney.service.Date;

/**
 * database interface; contains methods needed for interactions with the db.
 * @author Zhuoming Li
 * 
 */
public interface Idatabase {

    /**
     * This method takes in a username as a string and gets all its accounts.
     * @param   username A string holding the name of the user.
     * @return  returns a Document.
     */
    Document getAllAccounts(String username);

    /**
     * This method creates an account and takes in all the inputs needed to do so.
     * @param username                  String containing the name of the user.
     * @param accountDisplayName      String containing the name of the account display.
     * @param accountFullName         String containing the full name.
     * @param balance                   double containing the balance.
     * @param interestRate             double containing the interest rate.
     * @return                          returns a Document.
     */
    Document createAccount(String username, String accountDisplayName,
            String accountFullName, double balance, double interestRate);

    /**
     * This method takes in a username and password and uses them to login.
     * @param username      String containing the name of the user.
     * @param password      String containing the password of the user.
     * @return              returns a Document.
     */
    Document login(String username, String password);

    Document hashedLogin(String username);

    Document register(String username, String first_name,
            String last_name, String password, String email);

    /**
     * This method takes in a username and star/end date to generate a spending report.
     * @param username      String containing the name of the user.
     * @param start         Date conatining the starting date.
     * @param end           Date containing the ending date.
     * @return              returns a Document.
     */
    Document generateSpendingCategoryReport(String username, Date start,
            Date end);

    /**
     * This method takes in a source and an amount to create a deposit.
     * @param source        String containing the source of the deposit.
     * @param amount        A double with the amount of the deposit.
     * @param effectiveDate String containing the date in which the deposit was effective.
     * @return              returns a Document.
     */
    Document newDeposit(String source, double amount,
            String effectiveDate);

    /**
     * This method takes in a reason, category, amount, and date to make a new withdrawal.
     * @param reason            String containing the reason for this withdraw.
     * @param expenseCategory   String containing the category of the withdraw.
     * @param amount            A double with the amount of the withdraw.
     * @param effectiveDate     String containing the date in which the withdraw was effective.
     * @return                  returns a Document.
     */
    Document newWithdrawal(String reason, String expenseCategory,
            double amount, String effectiveDate);

}
