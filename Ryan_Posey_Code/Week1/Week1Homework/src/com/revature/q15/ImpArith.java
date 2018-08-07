package com.revature.q15;

// class that implements the Arithmetic interface, overriding the methods defined
public class ImpArith implements Arithmetic {

	@Override
	public int addition(int num1, int num2) {
		return num1 + num2;
	}

	@Override
	public int subtraction(int num1, int num2) {
		// TODO Auto-generated method stub
		return num1 - num2;
	}

	@Override
	public int mulitplication(int num1, int num2) {
		// TODO Auto-generated method stub
		return num1 * num2;
	}

	@Override
	public int division(int num1, int num2) {
		// TODO Auto-generated method stub
		return num1 / num2;
	}
	
}
