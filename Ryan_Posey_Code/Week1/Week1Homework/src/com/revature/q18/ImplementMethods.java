package com.revature.q18;

import java.util.ArrayList;

// class to implement the methods extended from the abstract class
public class ImplementMethods extends AbstractMethods {

	// method to check for any uppercase characters in a given string
	@Override
	public Boolean isUpperCase(String str) {
		boolean upper = false;
		for(int i = 0; i < str.length(); i++) {
			if(Character.isUpperCase(str.charAt(i))) {
				upper = true;
			}
		}
		return upper;
	}

	// method to return a string containing the given string, but all characters are lowercase
	@Override
	public String toLowerCase(String str) {
		StringBuffer lowerString = new StringBuffer(str.length());
		for(int i = 0; i < str.length(); i++) {
			char newChar = Character.toLowerCase(str.charAt(i));
			lowerString.append(newChar);
		}
		return lowerString.toString();
	}

	// method to convert a given string into an integer and add 10 to it
	@Override
	public int addTen(String str) {
		int stringToNum = Integer.parseInt(str);
		stringToNum += 10;
		return stringToNum;
	}
	
}