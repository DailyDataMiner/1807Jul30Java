package com.revature.q12;

/**
 * Enhanced for loop even checker
 * 
 * @author Arthur Panlilio
 *
 */
public class EnhancedForLoopQuestion {

	public static void main(String[] args) {
		//Populates an array 1-100
		int arr[] = new int[100];
		for(int i = 0; i < arr.length; i++) {
			arr[i] = i + 1;
		}
		//For loop, checks if n is even, if it is print it out. 
		for(int n : arr) {
			if(n%2 == 0) {
				System.out.println(n);
			}
		}
	}

}
