package com.revature.q14;

import java.util.Scanner;
import java.math.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

// class to demonstrate the switch statement using multiple functionalities
public class Switch {

	public static void functions(String choice) {
		switch(choice) { //executes a different function depending on string argument passed in
			case "root": // calculates the square root of any double value given by the user
				// create a scanner object and accept input from the console
				Scanner c = new Scanner(System.in);
				System.out.print("Enter a number: ");
				double num = c.nextDouble();
				// calculate the square root of the input using the Math class and print the result to the console
				double square = Math.sqrt(num);
				System.out.println("The square root of " + num + " is " + square);
				break;
			case "date": // print the current date to the console
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/DD");
				LocalDate local = LocalDate.now();
				System.out.println("Today's date: " + dtf.format(local));
				break;
			case "split": // split a predefined string
				String str = "I am learning Core Java";
				String[] strArr = str.split(" ", 5);
				
				for(String string : strArr) {
					System.out.println(string);
				}
				break;
			default: // immediately terminates if argument is not a valid input
				System.out.println("Not valid.");
				break;
		}	
	}
	
	public static void main(String[] args) {
		// test calls to demonstrate the function
		functions("root");
		functions("date");
		functions("split");
	}

}
