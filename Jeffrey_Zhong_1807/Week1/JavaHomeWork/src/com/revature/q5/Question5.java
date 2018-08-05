package com.revature.q5;

public class Question5 {

	public static void main(String[] args) {
		System.out.println(substring("abcdefg", 5));
	}

	//uses toCharArray and adds the character to the value
	public static String substring(String str, int idx) {
		String value ="";
		char[] tca = str.toCharArray();
		for (int i = 0; i < idx; i++) {
			value += tca[i];
		}
		return value;
	}

}
