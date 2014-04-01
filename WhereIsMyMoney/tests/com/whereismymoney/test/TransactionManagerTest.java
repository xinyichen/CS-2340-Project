package com.whereismymoney.test;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;
import junit.framework.TestCase;

import android.annotation.SuppressLint;
import com.whereismymoney.model.TransactionManager;

/**
 *
 * @author Jason Libbey
 * @author Jesus Carrillo
 *
 * This JUnit test checks the transaction manager's withdraw and deposit methods.
 *
 */
public class TransactionManagerTest extends TestCase {
	
	private TransactionManager transactionManager;
	private Date date = new Date();
	@SuppressLint("SimpleDateFormat")
	private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
	
	@Override
	protected void setUp() {
		this.transactionManager = new TransactionManager();
	}
	
	@Test
	public void testNewDeposit() {
		assertTrue(transactionManager
				.newDeposit("username", "account", "TransactionManagerTest", 0.00, this.simpleDateFormat.format(date)));
	}
	
	@Test
	public void testNewWithdraw() {
		assertTrue(transactionManager
				.newWithdrawal("username", "account", "TransactionManagerTest", "Test", 0.00, this.simpleDateFormat.format(date)));
	}
}
