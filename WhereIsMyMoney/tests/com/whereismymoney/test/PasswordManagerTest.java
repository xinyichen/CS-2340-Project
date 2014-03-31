package com.whereismymoney.test;
import junit.framework.TestCase;

import com.whereismymoney.model.PasswordManager;


public class PasswordManagerTest extends TestCase {

/**
 * This unit test tests the login feature with a test case of wrong password (request denied) and a case of right password (request confirmed)
 * NOTE: excluded the Strict Mode settings to avoid noClassDefFoundException
 * @author Zhuoming Li (Ming)
 *
 */
	private PasswordManager manager;
	
	@Override
	protected void setUp() throws Exception {
		manager = new PasswordManager();
	}
	
	/**
	 * login denied with wrong password
	 */
	public void testLoginWithWrongPassword(){
		assertFalse(manager.login("admin","wrongpassword"));
	}
	
	
	/**
	 * login accepted with right password
	 */
	public void testLoginWithRightPassword(){
		assertTrue(manager.login("admin","pass123"));
	}
}
