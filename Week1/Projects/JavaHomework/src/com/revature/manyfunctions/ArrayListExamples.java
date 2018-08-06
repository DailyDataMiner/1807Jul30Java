package com.revature.manyfunctions;

import java.util.ArrayList;

/*
 * Insert integers 1 thru 10 
 * 	-add all even numbers and print
 * 	-add all odd numbers and print
 * 	-remove prime numbers from list
 */

public class ArrayListExamples {

	public static void main(String[] args) {

		ArrayList<Integer> arrList = new ArrayList<Integer>();
		int num = 10; //change this number for the max value of the list from 1 until...num
		int evenSum = 0;
		int oddSum = 0;

		for (int i = 1; i <= num; i++) {
			arrList.add(i);
		}

		System.out.println("Original List: " + arrList);
		for (int i = 0; i < num; i++) { // loop and add even numbers
			if (arrList.get(i) % 2 == 0) {
				evenSum = evenSum + arrList.get(i);
			}
		}
		System.out.println("Sum of all even numbers in the list: " + evenSum);
		for (int i = 0; i < num; i++) { // loop and add odd numbers
			if (arrList.get(i) % 2 == 1) {
				oddSum = oddSum + arrList.get(i);
			}
		}
		System.out.println("Sum of all odd numbers in the list: " + oddSum);
		for (int i = 0; i < arrList.size()-1; i++) { // check if prime and remove if true

			boolean isPrime = true;
			int a = arrList.get(i);

			if (a > 1) {
				for (int j = 2; j < a ; j++) { // did a/2 to cut down on values that need to be divided
					if (a % j == 0) {
						isPrime = false;
						break;
					}

				}
			} else {
				if (a == 1) { // because 1 isn't prime
					isPrime = false;
				}
			}
			if (isPrime == true) {
				arrList.remove(i);
				i--;
			}

		}
		System.out.println("List after removing primes: " + arrList);
	}
}
