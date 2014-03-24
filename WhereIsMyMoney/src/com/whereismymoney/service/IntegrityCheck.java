package com.whereismymoney.service;

/**
 * for user input integrity check
 * @author Jesus
 *
 */
public class IntegrityCheck {
	public static boolean checkPasswordLength(String password, int length) {
		return password.matches(".{" + length + ",}");
	}
	public static boolean checkEmail(String email) {
		return email.matches("[a-zA-Z][0-9A-Za-z\\_\\-\\.]*@[a-zA-Z][0-9A-Za-z\\_\\-]*.(com|org|net|edu)");
	}
	public static boolean checkMatch(String firstWord, String secondWord) {
		return firstWord.equals(secondWord);
	}
	public static boolean isInputValid(String input) {
		return !input.matches("\\s*");
	}
	public static boolean validDate(String date) {
//		return date.matches("[0-9]{2}\\\\/[0-9]{2}\\\\/[0-9]{4}");
		return date.matches("\\d{4}-\\d{2}-\\d{2}");
	}
	public static boolean amountFormat(String amount) {
		return amount.matches("[0-9]{0,}.[0-9]{2}");
	}
}