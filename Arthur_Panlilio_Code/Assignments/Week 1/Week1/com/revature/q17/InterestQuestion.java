package com.revature.q17;

import java.util.Scanner;

/**
 * Calculates Interest
 * 
 * @author Arthur Panlilio
 *
 */
public class InterestQuestion {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		//checks true if the user doesn't put an integer
		boolean catcher = false;
		//The numbers to calculate
		int principal = 0;
		int rate = 0;
		int time = 0;
		
		//Asks for the principal, if the user doesn't correctly answer, it asks again.
		do {
			System.out.println("Whats the principal?");
			if(scanner.hasNextInt()) {
				principal = scanner.nextInt();
				catcher = false;
			} else {
				scanner.nextLine();
				System.out.println("Enter a number!");
				catcher = true;
			}
		} while(catcher);
		do {
			System.out.println("Whats the rate?");
			if(scanner.hasNextInt()) {
				rate = scanner.nextInt();
				catcher = false;
			} else {
				scanner.nextLine();
				System.out.println("Enter a number!");
				catcher = true;
			}
		} while(catcher);
		
		do {
			System.out.println("Whats the time?");
			if(scanner.hasNextInt()) {
				time = scanner.nextInt();
				catcher = false;
			} else {
				scanner.nextLine();
				System.out.println("Enter a number!");
				catcher = true;
			}
		} while(catcher);
		System.out.println("The simple interest is: " + interestCalc(principal, rate, time));
		scanner.close();

	}
	/**
	 * calculates the interest
	 * 
	 * @param x is the principal
	 * @param y is the rate
	 * @param z is the time
	 * @return all three multiplied
	 */
	public static double interestCalc(int x, int y, int z) {
		return  x*y*z;
	}

}
