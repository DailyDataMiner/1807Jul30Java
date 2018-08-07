package com.revature.q2;

public class Fibonacci {
	
	// method to print the first [limit] fibonacci numbers
	public static void fib(int[] fibs, int limit) {
		// inital condition
		fibs[0] = 0;
		fibs[1] = 1;
		System.out.print(fibs[0] + " " + fibs[1] + " ");
		// add the previous two numbers and assign them to the array
		for(int i = 2; i < limit-1; i++) {
			fibs[i] = fibs[i-1] + fibs[i-2];
			System.out.print(fibs[i] + " ");
		}
	}

	public static void main(String[] args) {
		// initialize array
		int[] sequence = new int[25];
		// calculate fibonacci sequence
		fib(sequence, 25);
	}

}
