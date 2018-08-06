package com.revature.reverse;

public class ReverseString {

	//reverse string without using a temporary variable or reverse() from StringBuffer and StringBuilder

	static String reverseMe(String str) {
		StringBuilder sb = new StringBuilder();
		for (int i = str.length()-1; i>=0; i--) {
			sb.append(str.charAt(i));

		}
		return sb.toString();

	}



	public static void main(String[] args) {

		System.out.println(reverseMe("platypus"));
		System.out.println(reverseMe("madam"));
		System.out.println(reverseMe("aquarium"));
		System.out.println(reverseMe("Tonald Drump"));


	}

}
