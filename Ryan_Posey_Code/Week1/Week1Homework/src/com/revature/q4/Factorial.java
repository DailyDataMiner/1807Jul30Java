package com.revature.q4;

public class Factorial {
	public static int factorial(int n) {
		if (n <= 1) return 1;
		else return n * factorial(n-1);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int fac = factorial(5);
		System.out.println(fac);
	}

}
