package com.revature.week1.Q2;

public class Fibonacci {
	
	public static void main(String[] args) {
		final int n = 25; // number of Fibonacci numbers to display
		// a & b are the previous two Fibonacci numbers, c is the current number
		int a = 0, b = 1, c;
		System.out.print(a + " ");
		System.out.print(b + " ");
		for(int i = 2; i < n; i++) {
			c = a + b;
			a = b;
			b = c;
			System.out.print(c + " ");
		}
		System.out.println();
	}
	
}
