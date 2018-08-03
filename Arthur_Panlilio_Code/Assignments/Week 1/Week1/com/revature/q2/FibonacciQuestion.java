package com.revature.q2;

/**
 * Demonstrated a fibonacci method
 * 
 * @author Arthur Panlilio
 *
 */
public class FibonacciQuestion {

	public static void main(String[] args) {
		System.out.println(fibonacci(25));
	}
	
	/**
	 * The fibonacci method
	 * Every number after the first two is the sum of the previous two.
	 * 
	 * @param int n what fibonacci number the user wants
	 * @return the corresponding fibonacci number
	 */
	public static int fibonacci(int n) {
		//Creates an array the size of n plus 2.
		//Needs space for first 0 and 1 in sequence
		int[] f = new int[n + 2];
		f[0] = 0;
		f[1] = 1;
		//Loops through array. if i is already past the first index, start adding the
		//current index and previous index into the next index
		for(int i = 0; i <= n; i++) {
			if(i > 0) {
				f[i + 1] = f[i] + f[i-1];
			}
		}
		
		return f[n];
	}

}
