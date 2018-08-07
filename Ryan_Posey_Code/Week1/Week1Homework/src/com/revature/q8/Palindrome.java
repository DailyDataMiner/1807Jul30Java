package com.revature.q8;

import java.util.ArrayList;

public class Palindrome {

	public static void main(String[] args) {
		// ArrayList of strings containing some palindromes
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
		
		//create a new ArrayList to hold palidromes
		ArrayList<String> palindromes = new ArrayList<String>();
		// for each string in the test list
		for(String str : strs) {
			// flag to determine if palindrome
			Boolean isPalindrome = true;
			
			// index of first character in string
			int index1 = 0;
			// index of last character in string
			int index2 = str.length()-1;
			
			//while the indexes have not crossed
			while(index2 > index1) {
				// set flag to false if the characters at opposite indexes are not the same
				if(str.charAt(index1) != str.charAt(index2)) {
					isPalindrome = false;
				}
				// shift indexes
				++index1;
				--index2;
			}
			// if flag is true, add the string to the palindrome list
			if(isPalindrome) {
				palindromes.add(str);
			}
		}
		// print the palindromes
		System.out.println(palindromes);
	}
}
