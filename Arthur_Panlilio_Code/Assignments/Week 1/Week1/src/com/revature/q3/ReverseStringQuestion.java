package com.revature.q3;

/**
 * Reverses a string using stringbuilder
 * 
 * @author Arthur Panlilio
 *
 */
public class ReverseStringQuestion {

	public static void main(String[] args) {
		System.out.println(reverse("Reverse this string"));
	}
	
	/**
	 * Reverses a string
	 * 
	 * @param String s is the string to be reversed
	 * @return the reversed string
	 */
	public static String reverse(String s) {
		//Creates a new string builder for the reversed string
		StringBuilder sb = new StringBuilder();
		//Loop through each character on the string backwards
		for(int i = s.length()-1; i >= 0; i--) {
			//append the character at index onto the string builder
			sb.append(s.charAt(i));
		}
		//Return stringbuilder as string
		return sb.toString();
	}
}
