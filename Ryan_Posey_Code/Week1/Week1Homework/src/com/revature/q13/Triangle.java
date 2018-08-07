package com.revature.q13;

public class Triangle {

	public static void main(String[] args) {
		// print a cool triangle to the console
		for(int i = 0; i < 4; i++) {
			for(int j = i; j >= 0; j--) {
				System.out.print(j % 2);
			}
			System.out.println();
		}
	}

}
