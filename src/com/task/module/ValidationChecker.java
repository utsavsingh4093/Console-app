package com.task.module;

public class ValidationChecker {
	public static boolean checkNameValid(String name) {
		String regexName = "[\\s]{0}[a-zA-Z]+[\\s]{0,1}[a-zA-Z]{0,50}[\\s]*";
		boolean check = name.matches(regexName);
		return check;
	}

	public static boolean checkValidEmail(String emai) {
		String regxEmail = "[\\s]{0}[a-zA-Z0-9._%+-]+@[a-zA-z0-9.-]+\\.[a-zA-Z]{2,3}[\\s]*";
		boolean check = emai.matches(regxEmail);
		return check;
	}

	public static boolean checkValidPhone(String number) {
		String regxPhone = "[\\s]{0}[6-9][0-9]{9}[\\s]*";
		boolean check = number.matches(regxPhone);
		return check;
	}
}
