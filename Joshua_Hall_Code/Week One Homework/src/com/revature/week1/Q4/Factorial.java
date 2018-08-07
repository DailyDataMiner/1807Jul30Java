package com.revature.week1.Q4;

public class Factorial {

	private static int factorialR(int n) {
		// n! = n * (n - 1)!
		return n < 2 ? 1 : n * factorialR(n - 1);
	}
	
	private static int factorialI(int n) {
		int x = 1;
		for(int i = n; i > 0; x *= i--);
		return x;
	}
	
	public static void main(String[] args) {
		final int input = 4;
		System.out.println(factorialR(input));
		System.out.println(factorialI(input));
	}
	
}
