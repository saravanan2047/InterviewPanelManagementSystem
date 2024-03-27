package com.zsgs.interviewpanel.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {

	public boolean validEmail(String email) {
		if (!Character.isLetter(email.charAt(0)) || !Character.isLetter(email.charAt(email.length() - 1))) {
			return false;
		}
		String[] arr = email.split("@");
		if (arr.length != 2) {
			return false;
		}
		String first = arr[0];
		if (first.charAt(first.length() - 1) == '.') {
			return false;
		}
		for (int j = 0; j < first.length(); j++) {
			char k = first.charAt(j);

			if ((Character.isLetterOrDigit(k) && Character.isLowerCase(k)) || k == '.') {

				if (j < arr[0].length() - 1 && k == '.' && arr[0].charAt(j + 1) == '.') {
					return false;
				}
			}
		}
		String second = arr[1];
		int count = 0;
		if (second == null) {
			return false;
		}
		if (!Character.isLetter(second.charAt(0))) {
			return false;
		}
		for (int i = 0; i < second.length(); i++) {
			char k = second.charAt(i);
			if (k == '.') {
				count++;
			}
			if (Character.isLowerCase(k) || k == '.') {
				if (i < second.length() - 1 && k == '.' && second.charAt(i + 1) == '.') {
					return false;
				}
			} else {
				return false;
			}
		}
		if (count < 1 || count > 2) {
			return false;
		}
		return true;
	}

	public boolean validPhoneNo(String phoneNo) {
//	        String phoneNumber=String.valueOf(phoneNo);
//	        if(phoneNumber.length()==10)
//	            return true;
//	        return false;
		String regex = "^\\(?(\\d{3})\\)?[-]?(\\d{3})[-]?(\\d{4})$";

		// Compile the regular expression into a Pattern object
		Pattern pattern = Pattern.compile(regex);

		// Create a Matcher object to match the phone number against the pattern
		Matcher matcher = pattern.matcher(phoneNo);

		// Return true if the phone number matches the pattern, false otherwise
		return matcher.matches();
	}

	public boolean validName(String name) {
		// Define the regular expression pattern
		String regex = "^[a-zA-Z]{3,20}$";

		// Compile the regular expression into a Pattern object
		Pattern pattern = Pattern.compile(regex);

		// Create a Matcher object to match the input against the pattern
		Matcher matcher = pattern.matcher(name);

		// Return true if the input matches the pattern, false otherwise
		return matcher.matches();
	}

}
