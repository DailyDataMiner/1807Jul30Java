package com.revature.week1q3;

public class reverseString {

	static String reverseString(String word) {

		if (word.length() == 1) {

			return word;

		} else {

			return reverseString(word.substring(1)) + word.substring(0, 1);

		}

	}

	public static void main(String[] args) {

		String word = "Reverse String 1 2 3";

		reverseString obj = new reverseString();

		System.out.println(obj.reverseString(word));

	}

}
