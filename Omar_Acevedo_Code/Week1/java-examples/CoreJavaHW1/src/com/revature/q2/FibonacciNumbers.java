package com.revature.q2;
import com.revature.helpers.HelperFunctions;


// Q2. Write a program to display the first 25 Fibonacci numbers beginning at 0.
// (Defined by recurrence relation):	Fn = Fn-1 + Fn-2
// (Seed values): 						F0 = 0 and F1 = 1.

public class FibonacciNumbers extends HelperFunctions {

	static int fn;
	
	public static void main(String[] args) {
		print(fibo(9));
	}
	
	private static int fibo(int n) {
		
		if (n <= 1) return n;
		else {
			fn = fibo(n-1) + fibo(n-2);
			return fn;
		}
	}

}
