package com.revature.q15;

/**
 * This class implements the interface.
 * 
 * @author Arthur Panlilio
 *
 */
public class q15Class implements InterfaceQuestions{

	/*
	 * These methods do math stuff
	 * 
	 */
	@Override
	public int addition(int x, int y) {
		return x + y;
		
	}

	@Override
	public int subtraction(int x, int y) {
		return x - y;
		
	}

	@Override
	public int multiplication(int x, int y) {
		return x * y;
		
	}

	@Override
	public int division(int x, int y) {
		return x/y;
		
	}

}
