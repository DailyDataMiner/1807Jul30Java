package com.revature.q3;

public class Reverse {
	
	public static String reverseString(String str) {
		StringBuffer buffer = new StringBuffer();
		for(int i = str.length()-1; i >= 0; i--) {
			buffer.append(str.charAt(i));
			System.out.println(str.charAt(i));
		}
		return buffer.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String test = new String("This is a string.");
		
		String reverseTest = reverseString(test);
		System.out.println(reverseTest);
	}

}
