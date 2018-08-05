package com.revature.junit;

public class NotJunit {
	/*
	 * Don't confuse assert methods in JUnit with
	 * Java assertions. These are lines of code that
	 * will be ignored without changing vm arguments
	 * to enable them, but will throw an assertionError
	 * and halt the execution of your code if assert
	 * condition is not met.
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		assert(args.length>0): "no args";
		System.out.println("assert worked");
	}

}
