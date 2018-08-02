package com.revature.q4;
import com.revature.helpers.HelperFunctions;

// Q4.Write a program to compute N factorial.
// n = n * n - 1

public class ComputeNFactorial extends HelperFunctions {

	public static void main(String[] args) {
		print(n(3));
	}
	
	private static int n(int n) {
		return (n >= 1) ? n * n(n-1) : 1;
	}

}
