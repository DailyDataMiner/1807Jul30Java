package com.revature.q14;

import java.util.Scanner;
import java.math.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Switch {

	public static void functions(String choice) {
		switch(choice) {
			case "root":
				Scanner c = new Scanner(System.in);
				System.out.print("Enter a number: ");
				double num = c.nextDouble();
				double square = Math.sqrt(num);
				System.out.println("The square root of " + num + " is " + square);
				break;
			case "date":
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/DD");
				LocalDate local = LocalDate.now();
				System.out.println("Today's date: " + dtf.format(local));
				break;
			case "split":
				String str = "I am learning Core Java";
				String[] strArr = str.split(" ", 5);
				
				for(String string : strArr) {
					System.out.println(string);
				}
				break;
			default:
				System.out.println("Not valid.");
				break;
		}	
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		functions("root");
		functions("date");
		functions("split");
	}

}
