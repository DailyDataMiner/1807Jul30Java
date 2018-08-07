package com.revature.week1.Q12;

public class PrintEven {

	public static void main(String[] args) {
		int[] numbers = new int[100];
		for(int i = 0; i < 100; i++) {
			numbers[i] = i + 1;
		}
		for(int i : numbers) {
			if(i % 2 == 0) {
				System.out.println(i);
			}
		}
	}

}
