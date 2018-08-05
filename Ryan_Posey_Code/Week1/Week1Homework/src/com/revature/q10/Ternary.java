package com.revature.q10;

public class Ternary {
	
	static int min(int a, int b) {
		return (a < b) ? a : b;
	}
	
	public static void main(String[] args) {
		int a = 7;
		int b = 5;
		
		int minVal = min(a, b);
		
		System.out.println("The minimum value between " + a + " and " + b + " is " + minVal);
	}
}
