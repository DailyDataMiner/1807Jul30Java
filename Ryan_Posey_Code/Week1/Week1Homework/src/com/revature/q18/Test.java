package com.revature.q18;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ImplementMethods met = new ImplementMethods();
		
		String testString = "There is an uppercase in this string!";
		System.out.println(testString);
		if(met.isUpperCase(testString)) {
			System.out.println("Indeed there is!");
		}
		else System.out.println("No, there isn't!");
		
		System.out.println(met.toLowerCase(testString));
		System.out.println("Now, they're lowercase!");
		
		String numString = "8";
		
		System.out.println(numString + " + 10 = " + met.addTen(numString));
	}

}
