package com.revature.q10;

public class Ternary {
	
	// method to find the minimum of two numbers using ternary operators
	static int min(int a, int b) {
		return (a < b) ? a : b;
	}
	
	public static void main(String[] args) {
		// test numbers
		int a = 7;
		int b = 5;
		
		// find the minimum between a and b
		int minVal = min(a, b);
		
		// print the result to the console
		System.out.println("The minimum value between " + a + " and " + b + " is " + minVal);
	}
}
