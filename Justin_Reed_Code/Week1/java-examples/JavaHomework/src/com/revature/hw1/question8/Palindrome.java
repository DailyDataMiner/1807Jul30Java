package com.revature.hw1.question8;

import java.util.ArrayList;

public class Palindrome {
	
	//This boolean will check if words are palidromes
	//If the reverese of the string is equal to the normal string
	//than it must be a palidrome
	public static boolean isPalindrome(String str) {
		
		// reverse the string
		String reverse = "";
		
		for (int i = str.length() - 1; i >= 0; i--) {
			
			reverse = reverse + str.charAt(i);
			
		}
		return str.equals(reverse);
	}

	public static void main(String[] args) {
		//ArrayList that will house list of words
		ArrayList<String> myArr = new ArrayList<String>(); 
		
		//AL that will have palindromes
		ArrayList<String> palindrome = new ArrayList<String>();
		
		myArr.add("karan");
		myArr.add("madam");
		myArr.add("tom");
		myArr.add("civic");
		myArr.add("radar");
		myArr.add("jimmy");
		myArr.add("kayak");
		myArr.add("john");
		myArr.add("refer");
		myArr.add("billy");
		myArr.add("did");
		// loop each element in arr1
		for (int i = 0; i < myArr.size(); i++) {
			
			if (isPalindrome((String) myArr.get(i))) {
				// if palindrome, add to pal arraylist
				palindrome.add((String) myArr.get(i)); 
			}
		}
	
		System.out.println("The Palindrome strings are : " + palindrome);
	}
		
	
	
	

}
