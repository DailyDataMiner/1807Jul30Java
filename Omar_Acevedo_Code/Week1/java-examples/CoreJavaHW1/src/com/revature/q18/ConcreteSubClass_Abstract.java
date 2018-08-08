package com.revature.q18;

import java.util.HashMap;

/**
 * Q18. Write a program having a concrete subclass that inherits three abstract methods
	from a superclass. Provide the following three implementations in the subclass
	corresponding to the abstract methods in the superclass:
	
	1. Check for uppercase characters in a string, and return ‘true’ or ‘false’ depending
	if any are found.
	2. Convert all of the lower case characters to uppercase in the input string, and
	return the result.
	3. Convert the input string to integer and add 10, output the result to the console.
	
 * @author omaracevedoacevedo
 *
 */

public class ConcreteSubClass_Abstract extends SuperClass {


/*	Start of method definitions/implementations (overriding) from superclass.	*/
	@Override
	HashMap<String, Boolean> checkForUppercase(String p_str) {

		boolean determines = false;
	
//		v4		//
//---------------------------------------------------------------------
		HashMap<String, Boolean> hm = new HashMap<String, Boolean>();
		
		for (int i = 0; i <= p_str.length()-1; i++) if ( determines = ( p_str.charAt(i) == p_str.toUpperCase().charAt(i) ) ? true : false ) break;
		
		if (determines) hm.put(p_str, determines);
		else 			hm.put(p_str, determines);
		
		return hm;
//---------------------------------------------------------------------
		
		
/*		v3
		for (int i=0; i<=p_str.length()-1; i++) if ( determines = ( p_str.charAt(i) == p_str.toUpperCase().charAt(i) ) ? true : false ) break;
		return determines;						// ^ This is awesome ^
*/
/*		v2
		String myValue = p_str;
		String upperValue = myValue.toUpperCase();		
		for (int i=0; i<=myValue.length()-1; i++) {
				if ( determines = ( myValue.charAt(i) == upperValue.charAt(i) ) ? true : false ) break;
		}
*/
/*		v1
		for (int i=0; i<=myValue.length()-1; i++) {
			println( myValue.charAt(i) + " == " + upperValue.charAt(i) + " " + ( myValue.charAt(i) == upperValue.charAt(i) ) );
			if ( myValue.charAt(i) == upperValue.charAt(i) ) {
				determines = ( myValue.charAt(i) == upperValue.charAt(i) );
			}
		}
		return determines; 
*/
	}
	

	@Override
	String lowerToUpper(String strToConvert) {
		
// 	Detect every lowercase character from parameter strToConvert and turn them uppercase, 
//	and return resulting string.
		
		String upperCaseString = "";
		
// 		v2
		for (int i=0; i<=strToConvert.length()-1; i++) {
			
			char letter 			= strToConvert.charAt(i);
			char upperCaseLetter 	= strToConvert.toUpperCase().charAt(i);
			char lowerCaseLetter 	= strToConvert.toLowerCase().charAt(i);
			boolean isLC 			= (letter == lowerCaseLetter);
			boolean isUP			= (letter == upperCaseLetter);
			
			if (isLC)		upperCaseString += upperCaseLetter;
			else if (isUP)	upperCaseString += upperCaseLetter;

			// upperCaseString += (isLC) ? upperCaseLetter : "";

		}
		
		return upperCaseString;

// 		v1: This may be the "simplest" way... ? 
//		return strToConvert.toUpperCase();
		
	}

	@Override
	void convertAndShow(String strToConvert) {
		
		char[] myChar = strToConvert.toCharArray();
		long strToInt = 0L;
		
		String stringOfInts = "";
		
		println("Input string to integer:");
		for (int i = 0; i<=myChar.length-1; i++) {
			
			println("\t" + myChar[i] + " -> " + (int)myChar[i] + ((myChar.length-1 == i) ? " +" : "" ) );
			stringOfInts += Integer.toString((int)myChar[i]); // Concatenation of each integer character value.
			strToInt += (int)myChar[i];
			
		}
		print("\t------------\n\t     " + strToInt + "\n");
		
		println("Sum of each input string character integer value: " + strToInt + " + 10 = " + (strToInt+10));
		
	}
	
}