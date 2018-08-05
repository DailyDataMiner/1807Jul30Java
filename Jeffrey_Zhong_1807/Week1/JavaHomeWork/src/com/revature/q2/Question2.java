package com.revature.q2;

public class Question2 {
	
	public static Integer termInFibonacciSequenceIteratively(int a) {
//checks for invalid values
		if (a == 0) {
			return 0;
		}
		if (a < 0) {
			throw new IllegalArgumentException();
		}
		if (a == 1) {
			return 1;
		}
		if (a == 2) {
			return 1;
		}

		int value = 0;
		int value1 = 0;
		int value2 = 1;
// prints fibonacci by saving previous values
		for (int i = 0; i < a; i++) {
			System.out.print(value + ", ");

			value = value1 + value2;
			value2 = value1;
			value1 = value;

		}
		return value;
	}
	
	public static void main(String[] args) {
		
		termInFibonacciSequenceIteratively(25);
		
	}

}
