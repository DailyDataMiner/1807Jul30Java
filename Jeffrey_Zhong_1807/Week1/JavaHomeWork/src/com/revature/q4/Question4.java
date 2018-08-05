package com.revature.q4;

public class Question4 {

	public static void main(String[] args) {
		
		factorial(5);
		
	}
	
	public static int factorial(int i) {
		if( i == 0 || i == 1) {
			return 1;
		}
		//recursive factorial
		int factNum = i * factorial(i-1);
		
		System.out.println(factNum);
		return factNum;
	}


}
