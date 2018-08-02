package com.revature.q4;

/**
 * Demonstrates a factorial function
 * 
 * @author Arthur Panlilio
 *
 */
public class FactorialQuestion {
	
	public static void main(String[] args) {
		System.out.println(factorial(8));
	}
	
	/**
	 * A recursive method for factorial
	 * 
	 * @param int n is the number to be factorialized
	 * @return the number after being factorialized
	 */
	public static int factorial(int n) {
		//if n is 0 return 1, ending the recursion
		if(n == 0) {
			return 1;
		} else {
			//if not 0, go through factorial method again, but this time -1.
			return(n * factorial(n-1));
		}
	}

}
