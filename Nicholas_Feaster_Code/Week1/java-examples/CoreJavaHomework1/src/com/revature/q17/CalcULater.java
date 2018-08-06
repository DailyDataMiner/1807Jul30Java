package com.revature.q17;

import java.util.Scanner;

public class CalcULater {

	public static void main(String[] args) {
		Scanner Ben = new Scanner(System.in);
		System.out.print("Welcome! Please enter the principal: ");
		double p1 = Ben.nextDouble();
		System.out.print("Thank you. Now, please enter the rate of interest: ");
		double rOI = Ben.nextDouble();
		System.out.print("Wonderful. Now, please enter the time that has passed in years: ");
		double years = Ben.nextDouble();
		double simpleP = p1*years*rOI;
		System.out.println("The interest has been deteremined as " + simpleP + " Thank you! Goodbye.");
		
		
	}

}
