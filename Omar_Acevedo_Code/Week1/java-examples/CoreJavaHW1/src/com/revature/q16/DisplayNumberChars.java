package com.revature.q16;
import com.revature.helpers.HelperFunctions;

/**
 * Q16. Write a program to display the number of characters for a string input. 
 * The string should be entered as a command line argument using (String [ ] args).
 * @author omaracevedoacevedo
 *
 */

public class DisplayNumberChars extends HelperFunctions {

	public static void main(String[] args) {
		
		println(" Number of characters in '" + args[0] + "' is " + args[0].length());
		
		
	}

}
