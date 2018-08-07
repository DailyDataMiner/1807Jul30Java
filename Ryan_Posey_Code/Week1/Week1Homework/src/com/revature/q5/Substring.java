package com.revature.q5;

public class Substring {
	// DONE!
	
	// method to return a substring from 0 to idx-1 inclusive
	public static String sub(String str, int idx) {
		// initialize an array of characters containing the characters in str
		char[] strArray = str.toCharArray();
		// create a buffer to place the substring
		StringBuffer buffer = new StringBuffer();
		// append the character at index i to buffer
		for(int i = 0; i < idx-1; i++) {
			buffer.append(strArray[i]);
		}
		// return the string representation of buffer
		return buffer.toString();
	}
	
	public static void main(String[] args) {
		// test string
		String test = new String("This is a test.");
		System.out.println(test);
		
		// print the substring of test from index 0 to 5 inclusive
		String subTest = sub(test, 6);
		System.out.println(subTest);
	}

}
