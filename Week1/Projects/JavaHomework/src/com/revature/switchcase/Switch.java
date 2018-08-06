package com.revature.switchcase;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class Switch {

	/*
	 * Demonstrate the switch case Case1: Find the square root of a number using the
	 * Math class method. Case2: Display today’s date. Case3: Split the following
	 * string and store it in a string array. “I am learning Core Java”
	 *
	 */

	public static void main(String[] args) {

		int x = 3;

		switch (x) {
		case 1:
			double sqrRoot = 100.00;
			System.out.println("The square root of " + sqrRoot + " is " + Math.sqrt(sqrRoot));
			break;

		case 2:
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");
			LocalDateTime now = LocalDateTime.now();
			System.out.println(dtf.format(now));
			break;

		case 3:
			String str = "I am learning Core Java";
			String[] strSplit = str.split("(?!^)");
			for (int i = 0; i < strSplit.length; i++)
				System.out.print(strSplit[i] + "|");
			break;

		}

	}

}
