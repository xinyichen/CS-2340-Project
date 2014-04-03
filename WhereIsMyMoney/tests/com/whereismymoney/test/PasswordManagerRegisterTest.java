package com.whereismymoney.test;

import junit.framework.TestCase;

import com.whereismymoney.model.PasswordManager;


public class PasswordManagerRegisterTest extends TestCase {
	
	/**
	 * This unit test tests if the user information has been registered or not
	 * @author Faye Yining Zhang
	 *
	 */
	
	private PasswordManager manager;

	@Override
	protected void setUp() throws Exception {
		manager = new PasswordManager();
	}

	
	public void accounthasnotbeencreated(){
		assertTrue(manager.register("johns","john","smith","123","js@gmail.com"));
	}


	public void accounthasbeencreated(){
		assertFalse(manager.register("johns","john","smith","123","js@gmail.com"));
	}
}
	