package com.revature.week1q6;

public class isEven {
	
	
	static boolean isEven(int num) {
		
		int temp = num;
		
		temp = (temp / 2);
		temp = (temp * 2);
		
		if(temp == num) {
			return true;
		}
		else {
			return false;
		}
		
	}
	
	
	public static void main(String[] args) {
		
		int num = 6;
		
		
		if(isEven(num)) {
			System.out.println(num + " is even");
		}
		else {
		
			System.out.println(num + " is odd");
			
		}
		
		
		
		
		num = 5;
		
		
		if(isEven(num)) {
			System.out.println(num + " is even");
		}
		else {
		
			System.out.println(num + " is odd");
			
		}
		
		
		
		
	}

}
