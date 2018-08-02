package com.revature.q9;

import java.util.ArrayList;
/**
 * Checks a list of 100 numbers if they are prime
 * 
 * @author Arthur Panlilio
 *
 */
public class ArrayListPrimeQuestion {

	public static void main(String[] args) {
		//Creates and populates a list of numbers, 1-100
		ArrayList<Integer> arr = new ArrayList<>();
		for(int i = 1; i <= 100; i++) {
			arr.add(i);
		}
		//Checks numbers 2-100 if they are prime
		//This loop starts at index 1 since 1 is not a prime number
		for(int i = 1; i < arr.size(); i++) {
			if(checkIfPrime(arr.get(i))) {
				System.out.println(arr.get(i));
			}
		}

	}
	
	/**
	 * Checks if the integer is prime
	 * 
	 * @param int n is the number to check
	 * @return a boolean true if prime
	 */
	public static boolean checkIfPrime(int n){
		//divide n by all numbers>1 below it to check if leaves a 0 remainder. If it does return false, if not return true.
	    for (int i = 2; i < n; i++) {
	        if (n % i == 0) {
	            return false;
	        }
	    }
	    return true;
	}

}
