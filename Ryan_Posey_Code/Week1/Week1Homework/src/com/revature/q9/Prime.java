package com.revature.q9;

import java.util.ArrayList;
import java.util.List;

public class Prime {
	// method to test if a given number is prime
	public static boolean isPrime(int n) {
		// flag variable to determine if prime, initially assumed prime
		boolean check = true;
		// 1 is not prime, so flag is set to false
		if(n <= 1) check = false;
		// loop through the list and test if every number before it divides evenly into it.
		// if yes, set the flag to false
		for(int i = 2; i < n; i++) {
			if(n % i == 0) {
				check = false;
			}
		}
		// return the flag variable
		return check;
	}

	public static void main(String[] args) {
		// create a list of integers from 1 to 100
		int n = 100;
		List<Integer> nums = new ArrayList<Integer>();
		
		for(int i = 1; i <= n; i++) {
			nums.add(i);
		}
		System.out.println(nums);
		
		// create another list to hold the prime numbers between 1 and 100
		List<Integer> primes = new ArrayList<Integer>();
		
		// check if each number in original list is prime. If so, add number to prime list.
		for(int i = 0; i < nums.size(); i++) {
			if(isPrime(nums.get(i))) {
				primes.add(nums.get(i));
			}
		}
		// print prime numbers to console
		System.out.println(primes);
	}

}
