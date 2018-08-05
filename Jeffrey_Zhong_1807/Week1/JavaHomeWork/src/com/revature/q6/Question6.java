package com.revature.q6;

public class Question6 {

	public static void main(String[] args) {
		
		evendetec(4);

	}

	public static boolean evendetec(int i) {
		//used bitwise operator to determine even or odd. All bit values of even numbers end in 0
		if((i & 1) == 0) {
			System.out.println("Number is even");
			return true;
		}
		else {
			System.out.println("Number is odd");
			return false;
		}
		
	}

}
