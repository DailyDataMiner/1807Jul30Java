package com.revature.week1.Q9;

import java.util.ArrayList;

public class PrimeNumbers {
	
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>(100);
		for(int i = 2; i <= 100; i++) {
			list.add(i);
		}
		while(!list.isEmpty()) {
			final int n = list.get(0);
			System.out.print(n + " ");
			list.removeIf((Integer i) -> i % n == 0);
		}
	}

}
