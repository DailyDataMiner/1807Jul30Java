package com.revature.jUnit;

public class NotJUnit {
	
	/*
	 * Don't confuse assert methods in  JUnit with
	 * Java assertions. These are lines of code that
	 * will be ignored without changing vm arguments
	 * to enable them, but will thrown an AssertionError
	 * and halt the execution of your code if assert
	 * condition is not met. 
	 */

	public static void main(String[] args) {
		assert(args.length > 0): "no args";
		System.out.println("assert worked");

	}

}
