package com.revature.q8;

import java.util.ArrayList;

public class Palindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> strs = new ArrayList<String>();
		strs.add("karan");
		strs.add("madam");
		strs.add("tom");
		strs.add("civic");
		strs.add("radar");
		strs.add("sexes");
		strs.add("jimmy");
		strs.add("kayak");
		strs.add("john");
		strs.add("refer");
		strs.add("billy");
		strs.add("did");
		
		ArrayList<String> palindromes = new ArrayList<String>();
		for(String str : strs) {
			Boolean isPalindrome = true;
			int index1 = 0;
			int index2 = str.length()-1;
			while(index2 > index1) {
				if(str.charAt(index1) != str.charAt(index2)) {
					isPalindrome = false;
				}
				++index1;
				--index2;
			}
			if(isPalindrome) {
				palindromes.add(str);
			}
		}
		System.out.println(palindromes);
	}
}
