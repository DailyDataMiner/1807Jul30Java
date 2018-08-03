package com.revature.q6;

/**
 * Checks if even without using modulus
 * 
 * @author Arthur Panlilio	
 *
 */
public class IsEvenNoModulusQuestion {

	public static void main(String[] args) {
		System.out.println(isEven(5));

	}
	
	/**
	 * Checks if n is even without modulus
	 * 
	 * @param int n is to be checked if even
	 * @return a boolean saying if even or false
	 */
	public static boolean isEven(int n) {
		//Default is false
		Boolean isEven = false;
		//Divide in half
		int n2 = n/2;
		//If new value multiplied by 2 is equal to original value, it is even. 
		if(n2 * 2 == n) {
			isEven = true;
		}
		
		return isEven;
	}

}
