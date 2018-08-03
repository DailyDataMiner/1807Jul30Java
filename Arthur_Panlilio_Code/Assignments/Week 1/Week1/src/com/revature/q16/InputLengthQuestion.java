package com.revature.q16;
/**
 * Counts amount of characters in a string input from command line
 * 
 * @author Arthur Panlilio
 *
 */
public class InputLengthQuestion {

	public static void main(String[] args) {
		int count = 0;
		//Each word is separated into its own element in array, so we must count each element 
		for(String s: args) {
			count++;
		}
		System.out.println(count);

	}

}
