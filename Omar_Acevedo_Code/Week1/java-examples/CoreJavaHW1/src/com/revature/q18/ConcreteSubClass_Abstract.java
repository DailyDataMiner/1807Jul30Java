package com.revature.q18;
import com.revature.q6.DetermineEvenIntNoMod;

import java.util.ArrayList;
import java.util.List;

//import com.revature.helpers.HelperFunctions;

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

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ConcreteSubClass_Abstract thisClass = new ConcreteSubClass_Abstract();
		
		String myStr = "omAr";
		println(thisClass.checkForUppercase(myStr));
		
		
	}

	@Override
	boolean checkForUppercase(String p_str) {
		
// 		1. 	Check for uppercase characters in a string, and 
//			return ‘true’ or ‘false’ depending if any are found.
		
		boolean determines = false;
		
//		v3
		for (int i=0; i<=p_str.length()-1; i++) if ( determines = ( p_str.charAt(i) == p_str.toUpperCase().charAt(i) ) ? true : false ) break;
		return determines;						// ^ This is awesome ^


//		v2
//		String myValue = p_str;
//		String upperValue = myValue.toUpperCase();		
//		for (int i=0; i<=myValue.length()-1; i++) {
//				if ( determines = ( myValue.charAt(i) == upperValue.charAt(i) ) ? true : false ) break;
//		}
		
//		v1		
//		for (int i=0; i<=myValue.length()-1; i++) {
//			println( myValue.charAt(i) + " == " + upperValue.charAt(i) + " " + ( myValue.charAt(i) == upperValue.charAt(i) ) );
//			if ( myValue.charAt(i) == upperValue.charAt(i) ) {
//				determines = ( myValue.charAt(i) == upperValue.charAt(i) );
//			}
//		}
//		return determines;		
	}

	@Override
	void m2() {
		
	}

	@Override
	void m3() {
		
	}
	
}