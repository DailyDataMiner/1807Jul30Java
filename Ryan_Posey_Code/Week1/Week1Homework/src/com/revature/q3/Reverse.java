package com.revature.q3;

public class Reverse {
	
	// method to reverse a string
	public static String reverseString(String str) {
		// create string buffer object to hold reversed string
		StringBuffer buffer = new StringBuffer();
		// append character at last index to the beginning of the buffer
		for(int i = str.length()-1; i >= 0; i--) {
			buffer.append(str.charAt(i));
			System.out.println(str.charAt(i));
		}
		return buffer.toString();
	}

	public static void main(String[] args) {
		// test string
		String test = new String("This is a string.");
		
		//reverse and print test string
		String reverseTest = reverseString(test);
		System.out.println(reverseTest);
	}

}
