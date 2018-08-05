package com.revature.q8;

import java.util.ArrayList;

public class Question8 {
	
	
	

	static ArrayList<String> al = new ArrayList<String>();
	static ArrayList<String> palinAl = new ArrayList<String>();

	public static Boolean isPalindrome(String input) {

		if (input == null) {
			return false;
		}
		//checks for palindrome and returns true/false
		input = input.replaceAll("\\W", "");
		int a = input.length();
		for (int i = 0; i <= input.length() / 2; i++) {

			if (!(input.charAt(i) == input.charAt(a - 1))) {
				return false;
			}
			a--;
		}
		return true;
	}

	public static void palinAdd(String str) {

		if (isPalindrome(str) == true) {
			al.add(str);
			palinAl.add(str);
		} else {
			al.add(str);
		}

	}

	public static void main(String[] args) {

		palinAdd("karan");
		palinAdd("madam");
		palinAdd("tom");
		palinAdd("civic");
		palinAdd("radar");
		palinAdd("sexes");
		palinAdd("jimmy");
		palinAdd("kayak");
		palinAdd("john");
		palinAdd("refer");
		palinAdd("billy");
		palinAdd("did");
		
		System.out.println(al);
		System.out.println(palinAl);
	}
	

}
