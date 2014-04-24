package com.whereismymoney.database;

import java.util.HashMap;
import java.util.Map;

public class DbUmlHelper {
	
	public enum UmlType {
		GET_ALL_ACCOUNTS, CREATE_ACCOUNT, LOGIN, HASHEDLOGIN,
		REGISTER, GENERATE_SPENDING_CATEGORY_REPORT, CREATE_WITHDRAWAL,
		CREATE_DEPOSIT
	}
	
	public static final DbUmlHelper INSTANCE = new DbUmlHelper();
	
	private DbUmlHelper () {
		
	}
	
	private static final String ROOT_ADDRESS = "http://192.185.4.36/~zli342/";
	
	private static final Map<UmlType, String> umlLookupTable;
	
	static {
		umlLookupTable = new HashMap<UmlType, String>();
		umlLookupTable.put(UmlType.GET_ALL_ACCOUNTS, "get_account_info.php");
		umlLookupTable.put(UmlType.CREATE_ACCOUNT, "create_account.php");
		umlLookupTable.put(UmlType.LOGIN, "login.php");
		umlLookupTable.put(UmlType.HASHEDLOGIN, "hashed_login.php");
		umlLookupTable.put(UmlType.REGISTER, "register.php");
		umlLookupTable.put(UmlType.GENERATE_SPENDING_CATEGORY_REPORT, "get_withdraw_summary.php");
		umlLookupTable.put(UmlType.CREATE_WITHDRAWAL, "create_withdrawal.php");
		umlLookupTable.put(UmlType.CREATE_DEPOSIT, "create_deposit.php");
	}	
	
	public String getUml(UmlType type) {
		return ROOT_ADDRESS + umlLookupTable.get(type);
	}
}
