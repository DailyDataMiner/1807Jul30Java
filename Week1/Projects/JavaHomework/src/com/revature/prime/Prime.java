package com.revature.prime;

import java.util.ArrayList;

public class Prime {

	// filter primes
	static void primeList(ArrayList<Integer> myList) {

		for (int i = 0; i < myList.size(); i++) {

			boolean isPrime = true;
			int a = myList.get(i);

			if (a > 1) {
				for (int j = 2; j < a ; j++) { // did a/2 to cut down on values that need to be divided
					if (a % j == 0) {
						isPrime = false;
						break;
					}

				}
			} else {
				if (a == 1) { // cause 1 isn't prime
					isPrime = false;
				}
			}
			if (isPrime == true) {
				System.out.println(a);
			}

		}
	}

	public static void main(String[] args) {

		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 1; i <= 100; i++) {
			list.add(i);
		}
		System.out.println(list);
		primeList(list);
	}

}
