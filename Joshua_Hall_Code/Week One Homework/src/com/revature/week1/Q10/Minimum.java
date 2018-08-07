package com.revature.week1.Q10;

public class Minimum {
	
	public static final float pi = 3.14f;
	public static final float e = 2.718f;

	private static int min(int a, int b) {
		return a < b ? a : b;
	}
	
	//test driver
	public static void main(String[] args) {
		System.out.println(min(314, 2718));
		System.out.println(min(2718, 314));
	}

}
