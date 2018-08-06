package com.revature.inclusivesubtring;

public class InclusiveSubstring {

	// inclusive substring from 0 to int idx-1 that doesn't using methods in the
	// String, StringBuilder, or StringBuffer APIs.

	static String inclusiveSubString(String str, int idx) {

		StringBuilder sb = new StringBuilder();
		char[] chars = str.toCharArray();
		for (int i = 0; i < idx + 1; i++) {
			sb.append(chars[i]);
		}
		return sb.toString();

	}

	public static void main(String[] args) {

		System.out.println(inclusiveSubString("happy", 3));
		System.out.println(inclusiveSubString("happy", 1));
	}

}
