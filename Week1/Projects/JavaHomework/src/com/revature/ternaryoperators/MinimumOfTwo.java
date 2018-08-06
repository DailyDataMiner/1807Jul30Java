package com.revature.ternaryoperators;

public class MinimumOfTwo {

	public static void main(String[] args) {
		
		int a = 30;
		int b = 50;
		int c;
		
		if (a == b) {
			System.out.println("You literally just put the same value for a and b");
			return;
		}
		else {
			c = (a > b) ? b:a;
			System.out.println("The minimum is: " + c);
		}

	}

}
