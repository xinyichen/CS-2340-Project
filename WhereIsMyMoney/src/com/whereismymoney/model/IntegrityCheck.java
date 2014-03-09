package com.whereismymoney.model;

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
}