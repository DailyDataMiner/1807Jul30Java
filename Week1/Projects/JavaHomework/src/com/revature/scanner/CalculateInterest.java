package com.revature.scanner;

import java.util.Scanner;
import static java.lang.System.in;

//import java.text.DecimalFormat; 

public class CalculateInterest {

	static double calculateInterest(double principal, double r, double time) {

		// DecimalFormat numberFormat = new DecimalFormat("#.00"); //can use this to
		// format answer to 2 decimals
		// System.out.println(numberFormat.format(number));
		return principal * r * time;
	}

	public static void main(String[] args) {
		System.out.println("It's time to calculate some interest!");
		System.out.println("Please Enter your principal");
		Scanner scan = new Scanner(in);
		double p = scan.nextDouble();
		System.out.println("Please enter the interest rate");
		Scanner scan2 = new Scanner(in);
		double r = scan.nextDouble();
		System.out.println("Please enter the number of months");
		Scanner scan3 = new Scanner(in);
		double t = scan.nextDouble();

		System.out.println(calculateInterest(p, r, t));

	}

}
