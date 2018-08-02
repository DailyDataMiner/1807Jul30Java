package com.revature.q5;

/**
 * Demonstrates the substring question
 * 
 * @author Arthur Panlilio
 *
 */
public class SubstringQuestion {
	
	public static void main(String[] args) {
		System.out.println(subStringer("Eclipse or Intellij?",7));

	}
	
	/**
	 * Iterates through a string n times, adding to a stringbuilder
	 * 
	 * @param String s is the string the substring
	 * @param int n is index to substring at (inclusive)
	 * @return the new string
	 */
	public static String subStringer(String s, int n) {
		StringBuilder sb = new StringBuilder();
		//Iterates through the string n times
		for(int i = 0; i < n; i++) {
			//Appends chars from 0 index to n
			sb.append(s.charAt(i));
		}
		//Turns StringBuilder into string
		return sb.toString();
	}

}
