package com.revature.IO;

import java.util.Scanner;
import static java.lang.System.in; // static import

public class ScannerExample {

	public static void main (String args[]) {
		
		System.out.println("Hello! Welcome to the WORLD! What's your name?");
		Scanner scan = new Scanner(in);
		String name = scan.nextLine();
		System.out.println("Hi, " + name +"! If you don't me asking, what's your age?");
		String age = scan.nextLine();
		int a;
		try {
		a = Integer.parseInt(age);
		}
		catch (NumberFormatException e) {
			System.out.println("LOOK WHAT YOU'VE DONE. Fine. You want to play cute? Enter your name. Or else.");
			
		}
		//System.out.println("Oh! So you're " + a + " years old?");
		scan.close();
	}
	
}
