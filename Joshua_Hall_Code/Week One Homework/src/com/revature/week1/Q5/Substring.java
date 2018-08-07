package com.revature.week1.Q5;

public class Substring {

	private static String substring(String str, int idx) {
		char[] chars = new char[idx];
		for(int i = 0; i < idx; i++) {
			chars[i] = str.charAt(i);
		}
		return String.copyValueOf(chars);
	}
	
	// test driver
	public static void main(String[] args) {
		String str = "The quick brown fox jumps over the lazy dogs.";
		System.out.println(substring(str, 8));
		System.out.println(substring(str, 16));
		System.out.println(substring(str, 32));
	}

}
