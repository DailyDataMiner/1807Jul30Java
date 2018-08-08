package com.revature.week1q8;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListNames {
	
	//Reusing Reverse string method from previous example to check if word is a palindrome
	
	static String reverseString(String word) {

		if (word.length() == 1) {

			return word;

		} else {

			return reverseString(word.substring(1)) + word.substring(0, 1);

		}

	}
	

	public static void main(String[] args) {
		
		String[] nameInput = {"karan", "madam", "tom", "civic", "radar", "sexes", "jimmy", "kayak", "john", "refer", "billy",
		"did"};
		
		ArrayList wordList1 = new ArrayList();//all word list
		ArrayList wordList2 = new ArrayList();//palindrome list
		
		String word1 = new String();
		String word2 = new String();
		
		for (int i = 0; i < nameInput.length; i++) {
			 
				word1 = nameInput[i];
				word2 = reverseString(nameInput[i]);
				
				wordList1.add(word1);
							
			 
			 if (word1.equals(word2)) {
				 wordList2.add(word2); //adds to list of palindrome
				
			}
			 
			 
		}
		
		
		
		//prints out palindrome list
		for (Iterator iterator = wordList2.iterator(); iterator.hasNext();) {
			Object object = (Object) iterator.next();
			System.out.println(object);
		}
		
		
		
		
		
	}

}
