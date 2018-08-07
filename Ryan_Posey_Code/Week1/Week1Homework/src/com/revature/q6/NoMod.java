package com.revature.q6;

public class NoMod {
	
	// method to determine if a given integer is even. Returns true if it is even, false otherwise
	public static boolean isEven(int num) {
		// flag variable
		boolean even = true;
		// flip the flag until i reaches num
		for(int i = 0; i < num; i++) {
			even = !even;
		}
		// return the flag
		return even;
	}
	
	public static void main(String[] args) {
		// test calls for different numbers
		System.out.println(isEven(2));
		System.out.println(isEven(3));
		System.out.println(isEven(4));
	}

}
