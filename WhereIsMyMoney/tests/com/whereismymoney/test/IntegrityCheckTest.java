package com.whereismymoney.test;

import junit.framework.TestCase;

import com.whereismymoney.service.IntegrityCheck;

/**
 * This class tests all the methods in IntegrityCheck.java
 * using JUnit 3.
 * 
 * @author andrew
 */

public class IntegrityCheckTest extends TestCase {
	
	private IntegrityCheck check;
	
	@Override
	protected void setUp() throws Exception {
		check = new IntegrityCheck();
	}
	
	/**
	 * Checking the checkPasswordLength method
	 * which takes in a string and an int value
	 * and makes sure the string is at least 
	 * as many characters as the value.
	 */
	public void testCheckPasswordLength() {
		assertEquals(check.checkPasswordLength("pass123", 7), true);		//string.length = int
		assertEquals(check.checkPasswordLength("test", 10), false);			//string.length < int
		assertEquals(check.checkPasswordLength("thisisastring", 5), true);	//string.length > int
	}
	
	/**
	 * Checking the checkEmail method which accepts
	 * emails with the following characteristics:
	 * 1) any word character, digit, underscore, dash and period combination,
	 *    but must start with a letter
	 * 2) the @ symbol
	 * 3) any word character, digit, underscore and dash combination, but must
	 *    start with a letter
	 * 4) a single period
	 * 5) must end in com, org, net or edu
	 */
	public void testCheckEmail() {
		assertEquals(check.checkEmail("gpburdell@gatech.edu"), true);		//valid email address
		assertEquals(check.checkEmail("3333@test.com"), false);				//invalid email address
	}
	
	/**
	 * Checks the checkMatch method which
	 * checks if two strings are equal
	 */
	public void testCheckMatch() {
		assertEquals(check.checkMatch("Supercalifragilisticexpialidocious", 
				"Supercalifragilisticexpialidocious"), true);				//should match
		assertEquals(check.checkMatch("teetertotter", "teeterteeter"), false);	//shouldn't match
	}
	
	/**
	 * Checks the isInputValid method
	 * which checks if a string has characters in it
	 * or if just has spaces or not characters at all
	 */
	public void testIsInputValid() {
		assertEquals(check.isInputValid("    "), false);					//A string of spaces
		assertEquals(check.isInputValid("password"), true);					//A valid string
		assertEquals(check.isInputValid("    test"), true);					//Spaces and then a string
		assertEquals(check.isInputValid(""), false);						//An empty string
	}
	
	/**
	 * Checks the validDate method
	 * which checks if a date has format
	 * ####-##-##
	 */
	public void testValidDate() {
		assertEquals(check.validDate("12345-21-32"), false);				//5-2-2 format
		assertEquals(check.validDate("4324-234-43"), false);				//4-3-2 format
		assertEquals(check.validDate("4534-34-543"), false);				//4-2-3 format
		assertEquals(check.validDate("32423423"), false);					//string of digits
		assertEquals(check.validDate("2014-23-12"), true);					//4-2-2 format
	}
	
	/**
	 * Checks the amountFormat method
	 * which checks if a string has format
	 * #...##.## or #..##
	 */
	public void testAmountFormat() {
		assertEquals(check.amountFormat(".93"), true);						// .## format
		assertEquals(check.amountFormat("12345.432"), false);				//Too many trailing digits
		assertEquals(check.amountFormat("53453345.00"), true);				//##...#.## format
		assertEquals(check.amountFormat("3423"), true);						//No digits after decimal
	}
}