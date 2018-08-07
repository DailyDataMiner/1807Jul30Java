package com.revature.week1.Q6;

public class Parity {

	private static boolean isEven(int i) {
		return i == i >> 1 << 1;
	}
	
	//test driver
	public static void main(String[] args) {
		for(int i = -8; i < 8; i++) {
			System.out.println("isEven(" + i + ") == " + isEven(i));
		}
	}

}
