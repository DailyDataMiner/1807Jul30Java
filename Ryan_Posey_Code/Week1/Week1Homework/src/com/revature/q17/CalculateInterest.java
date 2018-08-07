package com.revature.q17;

import java.util.Scanner;

public class CalculateInterest {

	public static void main(String[] args) {
		// define a scanner object and accept the principal value from the console, assigning it to a double variable
		System.out.print("Enter the prinicpal: ");
		Scanner c = new Scanner(System.in);
		
		double principal = c.nextDouble();
		System.out.println("");
		
		// accept the interest rate from the console, assigning it to a double variable
		System.out.print("Enter the interest rate: " );
		double rate = c.nextDouble();
		System.out.println("");
		
		// accept the number of years from the console, assigning it to an integer
		System.out.print("Enter the number of years: ");
		int time = c.nextInt();
		System.out.println("");
		
		// calculate interest and display it to the console
		double interest = principal*rate*time;
		System.out.println("Your simple interest is: " + interest);
	}

}
