package com.revature.q9;

import java.util.ArrayList;

public class Question9 {

	public static void main(String[] args) {
		
		ArrayList<Integer> ar = new ArrayList<Integer>();
		
		for(int i = 1; i <= 100; i++) {
			ar.add(i);
		}
		//determines if element is prime
		for(int i = 1; i < 100; i++) {
			if( isPrime(ar.get(i)) == true) {
				System.out.println(ar.get(i));
			}
		}
				
		
	}
	
	
	
	public static Boolean isPrime(int input) {
		if (input == 0) {
			return true;
		}
		if (input < 0) {
			throw new IllegalArgumentException();
		}

		for (int i = 2; i <= input / 2; i++) {
			if (input % i == 0) {
				return false;
			}
		}
		return true;
	}
	
}
