package com.revature.week1.Q15;

public class Test {

	public static void main(String[] args) {
		MyInteger one = new MyInteger(32);
		MyInteger two = new MyInteger(8);
		
		System.out.println("addition: " + one.addition(two));
		System.out.println("subtraction: " + one.subtraction(two));
		System.out.println("multiplication: " + one.multiplication(two));
		System.out.println("division: " + one.division(two));
	}

}
