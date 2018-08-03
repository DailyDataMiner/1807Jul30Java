package com.revature.q8;

import java.util.ArrayList;

/**
 * Puts only palindromes in a list.
 * 
 * @author Arthur Panlilio
 *
 */
public class PalindromesQuestion {
	
	public static void main(String[] args) {
		//Creates an array list and adds all the words into the array list
		ArrayList<String> arr = new ArrayList<>();
		arr.add("karan");
		arr.add("madam");
		arr.add("tom");
		arr.add("civic");
		arr.add("sexes");
		arr.add("jimmy");
		arr.add("kayak");
		arr.add("john");
		arr.add("refer");
		arr.add("billy");
		arr.add("did");
		
		//Loops through arraylist to check if each word is a palindrome
		//Adds palindromes to palindrome list
		ArrayList<String> palindromes = new ArrayList<>();
		for(int i = 0; i  < arr.size(); i++) {
			if(checkPalindrome(arr.get(i))) {
				palindromes.add(arr.get(i));
			}
		}
		
		//Prints out palindrome
		printArray(palindromes);
	}
	
	/**
	 * Checks if the word is a palindrome
	 * 
	 * @param String s is the string to check if is a palindrome
	 * @return boolean true or not
	 */
	public static boolean checkPalindrome(String s) {
		//Creates a stringbuilder copy, reverses, lowercases both, and checks if they are equal
		StringBuilder sb = new StringBuilder();
		sb.append(s);
		//if they are equal return true.
		return s.toLowerCase().equals(sb.reverse().toString().toLowerCase());
	}
	

	/**
	 * Prints out the array values in order
	 * 
	 * @param ar is the array to be printed
	 */
	public static void printArray(ArrayList<String> ar) {
		
		for(int i = 0; i < ar.size(); i++) {
			System.out.print(ar.get(i) + " " );
		}
	
	}

}
