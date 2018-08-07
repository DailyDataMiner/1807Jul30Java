package com.revature.q19;

import java.util.ArrayList;

public class ArrayListStuff {
	// demonstration of operations on ArrayLists of integers

	public static void main(String[] args) {
		// create a list of integers from 1 to 10
		ArrayList<Integer> nums = new ArrayList<Integer>();
		for(int i = 0; i < 10; i++) {
			nums.add(i+1);
		}
		System.out.println(nums.toString());
		
		// add all the even integers and print the sum to the console
		int evenSum = 0;
		for(Integer i : nums) {
			if(i % 2 == 0) {
				evenSum += i.intValue();
			}
		}
		System.out.println("The sum of the even numbers: " + evenSum);
		
		// add all the odd integers and print the sum to the console
		int oddSum = 0;
		for(Integer i : nums) {
			if(i % 2 == 1) {
				oddSum += i.intValue();
			}
		}
		System.out.println("The sum of the odd numbers: " + oddSum);
		
		// find the prime numbers in the list and print them to the console
		System.out.print("The prime numbers are: ");
		
		for(int i = 0; i < nums.size(); i++) {
			if(isPrime(nums.get(i))) {
				System.out.print(nums.get(i) + " ");
			}
		}
		
	}
	
	// method to test if a given integer is prime
	public static boolean isPrime(int n) {
		boolean check = true;
		if(n <= 1) check = false;
		for(int i = 2; i < n; i++) {
			if(n % i == 0) {
				check = false;
			}
		}
		return check;
	}

}
