package com.revature.q18;

public class Test {

	public static void main(String[] args) {
		// test class to demonstrate implementation of the abstract methods
		
		// instantiate an object containing the implementation
		ImplementMethods met = new ImplementMethods();
		
		// create a test string for the first two methods
		String testString = "There is an uppercase in this string!";
		System.out.println(testString);
		
		// inform the user that the string contains an uppercase character or not
		if(met.isUpperCase(testString)) {
			System.out.println("Indeed there is!");
		}
		else System.out.println("No, there isn't!");
		
		// change all characters in the string to lowercase and display it to the console
		System.out.println(met.toLowerCase(testString));
		System.out.println("Now, they're lowercase!");
		
		// test string for the final method
		String numString = "8";
		
		// convert test string to an integer, add 10, then display it to the console 
		System.out.println(numString + " + 10 = " + met.addTen(numString));
	}

}