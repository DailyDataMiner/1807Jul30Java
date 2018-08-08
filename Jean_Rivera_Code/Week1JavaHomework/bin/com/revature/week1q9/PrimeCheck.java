package com.revature.week1q9;

import java.util.ArrayList;
import java.util.Iterator;

public class PrimeCheck {

	public static boolean checkPrime(Integer num) {

		if (num > 2) {

			for (int i = 2; i <= num / 2; ++i) {

				if (num % i == 0) {
					return false;
				}

			}

		}
		
		if (num == 2) {
			return true;
		}

		if (num == 1) {
			return true;
		}

		return true;

	}

	public static void main(String[] args) {

		// fills array list
		ArrayList<Integer> numbers = new ArrayList<Integer>();

		for (int i = 1; i <= 100; i++) {

			numbers.add(i);

		}

		for (Iterator iterator = numbers.iterator(); iterator.hasNext();) {
			Integer integer = (Integer) iterator.next();
			
			
			if(checkPrime(integer)) {
				System.out.println(integer + " is a prime number");
			}

		}

	}

}
