package com.revature.q19;

import java.util.ArrayList;

public class Question19 {

	public static void main(String[] args) {
//Creates arraylist and adds numbers 1-10
		ArrayList<Integer> AL = new ArrayList<Integer>();

		for (int i = 1; i <= 10; i++) {
			AL.add(i);
		}

		System.out.println(AL);
// checks for even and adds to sum
		int EvenSum = 0;
		for (int i = 0; i < AL.size(); i++) {
			if (isEven(AL.get(i)) == true) {
				EvenSum += AL.get(i);
			}

		}
		
		System.out.println("Sum of all evens is " + EvenSum);
//checks for odd and adds to sum
		int OddSum = 0;
		for (int i = 0; i < AL.size(); i++) {
			if (isEven(AL.get(i)) == false) {
				OddSum += AL.get(i);
			}

		}
		System.out.println("Sum of all odds is "+ OddSum);
		
	//checks for prime number and removes it	
		for(int b = 0; b < AL.size(); b++) {
			if (isPrime(AL.get(b)) == true) {
				AL.remove(b);
			}
		}
		System.out.println("Array List with no prime numbers is " + AL);

	}

	public static boolean isEven(int a) {
		if (a % 2 == 0) {
			return true;
		} else {
			return false;
		}

	}
	
	public static boolean isPrime(int a) {
		for(int i = 2 ; i < a/2; i ++) {
			if(a % i == 0) {
				return false;
			}
		}
		return true;
		
	}
}
