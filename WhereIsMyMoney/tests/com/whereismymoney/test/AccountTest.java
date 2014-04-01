package com.whereismymoney.test;

import com.whereismymoney.model.Account;

import junit.framework.TestCase;

/**
 * currently test the toString method
 * 
 * @author xinyi
 *
 */
public class AccountTest extends TestCase {
	private Account account;

	protected void setUp() throws Exception {
		account = new Account("full name", "dispname", 10.0, 10.0);
	}

	public void testToStringValidInput() {
		assertEquals(account.toString(10, 10, 10), "dispname  10.0      10.0      ");
	}
	
	public void testToStringFirstColumnTooSmall() {
		try {
			account.toString(3, 10, 10);
			fail("should throw IllegalArgumentException");
		} catch (IllegalArgumentException iae){
			assertEquals(iae.getMessage(), "please define large enough column width for column 1 ");
		}
	}
	
	public void testToStringSecondColumnTooSmall() {
		try {
			account.toString(10, 3, 10);
			fail("should throw IllegalArgumentException");
		} catch (IllegalArgumentException iae){
			assertEquals(iae.getMessage(), "please define large enough column width for column 2 ");
		}
	}
	
	public void testToStringThirdColumnTooSmall() {
		try {
			account.toString(10, 10, 3);
			fail("should throw IllegalArgumentException");
		} catch (IllegalArgumentException iae){
			assertEquals(iae.getMessage(), "please define large enough column width for column 3");
		}
	}

}
