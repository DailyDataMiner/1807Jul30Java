package homework1.q14;

import static java.lang.System.in;


import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class SwitchCaseDemonstration {
	
	//static scanner declaration
	static Scanner scan = new Scanner(in);
	
	public static void main(String[] args) {
		System.out.println(ReturnInfo());
		
	}

	
	
	//Contains switch case statement, which checks String input from console and returns corresponding case.
	public static String ReturnInfo() {
		
		Date today = Calendar.getInstance().getTime();
		
		System.out.println("Please enter 'square root', 'display date', or 'split string'");
		String response = scan.nextLine();
		switch(response.toLowerCase()) {
		case "square root": return findSqrt();
		case "display date": return today.toString();
		case "split string": return splitString().toString();
		default: return "entered text not valid";
		}
	}
	//Finds square root of number and returns result
	public static String findSqrt() {
		System.out.println("Please enter the number you wish to find the square root of: ");
		int numResponse = scan.nextInt();
		double sqrt = Math.sqrt(numResponse);
		return Double.toString(sqrt);
	}
	//Splits string using .split
	public static String[] splitString() {
		String str = "I am learning Core Java";
		String[] strArr = str.split(" ");
		
		return strArr;
	}
}
