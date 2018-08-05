package com.revature.q18;

import java.util.ArrayList;

public class ImplementMethods extends AbstractMethods {

	@Override
	public Boolean isUpperCase(String str) {
		// TODO Auto-generated method stub
		boolean upper = false;
		for(int i = 0; i < str.length(); i++) {
			if(Character.isUpperCase(str.charAt(i))) {
				upper = true;
			}
		}
		return upper;
	}

	@Override
	public String toLowerCase(String str) {
		// TODO Auto-generated method stub
		StringBuffer lowerString = new StringBuffer(str.length());
		for(int i = 0; i < str.length(); i++) {
			char newChar = Character.toLowerCase(str.charAt(i));
			lowerString.append(newChar);
		}
		return lowerString.toString();
	}

	@Override
	public int addTen(String str) {
		// TODO Auto-generated method stub
		int stringToNum = Integer.parseInt(str);
		stringToNum += 10;
		return stringToNum;
	}
	
}
