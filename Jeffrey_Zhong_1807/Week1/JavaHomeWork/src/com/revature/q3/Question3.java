package com.revature.q3;

public class Question3 {
//uses stringer builder to add the last value first
	public static void reverseString(String orig) {
		StringBuilder SB = new StringBuilder();
		for (int i = orig.length(); i > 0; i--) {
			String a = orig.substring(i - 1, i);
			SB.append(a);
		}
		System.out.println(SB);

	}

	public static void main(String[] args) {

		reverseString("abcdefg12345,./;");
	}
}
