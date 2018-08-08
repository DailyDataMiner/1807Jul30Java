package com.revature.q18;

public class TestClass extends ConcreteSubClass_Abstract {

	public static void main(String[] args) {

//		Create instance of concrete class to access and use functions.
		ConcreteSubClass_Abstract concreteClass = new ConcreteSubClass_Abstract();

		
//		"Input string"
		String myStr = "Omar Acevedo";

		
		if (concreteClass.checkForUppercase(myStr).get(myStr)) {


/*	 	1. 	Check for uppercase characters in a string, and return ‘true’ or ‘false’ depending
 			if any are found. 																	*/
			String strToConvert = concreteClass.checkForUppercase(myStr).keySet().toArray()[0].toString();
			println("Input string to convert -> " + strToConvert + " has uppercase characters.");


/*		2. 	Convert all of the lower case characters to uppercase in the input string, and
			return the result.																	*/
			strToConvert = concreteClass.lowerToUpper(strToConvert);
			
			
/*		3. 	Convert the input string to integer and add 10, output the result to the console.	*/
			concreteClass.convertAndShow(strToConvert);
			
		}	// If End
		
	}	// Main End

}
