package com.revature.nomoduluseven;

public class NoModulusEven {

	//Determines if integer is even without using the modulus operator (%)
	static void isEven (int k) {
		
		int half = k /2;
		if (k == half*2) {
			System.out.println(k + " is even");
		}
		else {
			System.out.println(k + " is odd");
		}
		
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		
		//size of integer is limited because it is of type int
		isEven(21);
		isEven(24);
		isEven(28322095);
	}

}
