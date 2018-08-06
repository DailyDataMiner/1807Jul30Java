package com.revature.triangle;

public class Triangle {

	/*Outputs
	 * 0
	 * 1 0
	 * 0 1 0
	 * 1 0 1 0
	 * 
	 */
	public static void main(String[] args) {

		int numberofRows = 4;

		for (int i = 1; i <= numberofRows; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print(((i + j) % 2) + " ");
			}
			System.out.print("\n");
		}

	}

}
