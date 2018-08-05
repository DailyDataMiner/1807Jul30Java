package com.revature.q13;

public class Question13 {

	public static void main(String[] args) {
		triangle(4);
	}

	//prints out triangle using nested for loop. Has counter to
	//determine 1 and 0
	public static void triangle(int n) {
		int counter = 1;
		for (int i = 0; i < n; i++) {
			for (int a = 0; a <= i; a++) {
				if (counter % 2 == 0) {
					System.out.print("1 ");
				} else {
					System.out.print("0 ");
				}
				counter++;
			}
			System.out.println("");
		}

	}

}
