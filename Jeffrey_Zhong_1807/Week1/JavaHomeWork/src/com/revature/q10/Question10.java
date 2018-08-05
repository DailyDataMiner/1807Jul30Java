package com.revature.q10;

public class Question10 {
	
	
	
	public static void main(String[] args) {
	
		findMin(5,3);
	}
	
	public static int findMin(int a, int b) {
		//if a < b then min value is a. If a > b min value is b
		int minValue = a < b ? a : b;
		
		System.out.println(minValue);
		return minValue;
	}

}
