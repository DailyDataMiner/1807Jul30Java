package com.revature.q15;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num1 = 25;
		int num2 = 5;
		
		ImpArith arithmetic = new ImpArith();
		
		System.out.println(num1 + " + " + num2 + " = " + arithmetic.addition(num1, num2));
		System.out.println(num1 + " - " + num2 + " = " + arithmetic.subtraction(num1, num2));
		System.out.println(num1 + " * " + num2 + " = " + arithmetic.mulitplication(num1, num2));
		System.out.println(num1 + " / " + num2 + " = " + arithmetic.division(num1, num2));
	}

}
