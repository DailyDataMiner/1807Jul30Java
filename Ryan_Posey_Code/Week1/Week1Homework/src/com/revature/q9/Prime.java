package com.revature.q9;

import java.util.ArrayList;
import java.math.*;

public class Prime {
	
	static ArrayList<Integer> printPrimes(int size) {
		ArrayList<Boolean> isPrime = new ArrayList<Boolean>(size);
		ArrayList<Integer> primes = new ArrayList<Integer>(size/2);
		for(int index = 0; index < size; index++) {
			isPrime.add(true);
		}
		for(int i = 2; i <= size; i++) {
			if(isPrime.get(i)) {
				for(int j = i; j < size; j++) {
					isPrime.set(j, false);
				}
			}
		}
		System.out.println(isPrime);
		for(int index = 2; index < size; index++) {
			if(isPrime.get(index)) {
				primes.add(index);
			}
		}
		return primes;
	}

	public static void main(String[] args) {
		int size = 10;
		System.out.println(printPrimes(size));
	}

}
