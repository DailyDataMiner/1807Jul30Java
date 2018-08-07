package com.revature.q15;

public class Test {

	public static void main(String[] args) {
		// test integers to demonstrate functionality
		int num1 = 25;
		int num2 = 5;
		
		// initialize object containing functionality
		ImpArith arithmetic = new ImpArith();
		
		// print the results of each method to the console
		System.out.println(num1 + " + " + num2 + " = " + arithmetic.addition(num1, num2));
		System.out.println(num1 + " - " + num2 + " = " + arithmetic.subtraction(num1, num2));
		System.out.println(num1 + " * " + num2 + " = " + arithmetic.mulitplication(num1, num2));
		System.out.println(num1 + " / " + num2 + " = " + arithmetic.division(num1, num2));
	}

}
