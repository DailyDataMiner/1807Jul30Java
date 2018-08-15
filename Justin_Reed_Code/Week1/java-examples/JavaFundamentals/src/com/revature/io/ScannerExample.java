package com.revature.io;

import java.util.Scanner;
import static java.lang.System.in;
// ^ static imports allows us to access static fields of a class w/o class

public class ScannerExample {
	
	public static void main(String[] args) {
		
		System.out.println("Hello welcome to my app, enter your name");
		Scanner scan = new Scanner(System.in);
		String name = scan.nextLine();
		System.out.println("Hello, " + name + "Please enter your age");
		String age = scan.nextLine();
		int a;
		try {
			a = Integer.parseInt(age);
		} catch(NumberFormatException nfe) {
			nfe.printStackTrace();
			System.out.println("You didn't enter a valid number");
			a = 5;
		}
		System.out.println(a);
		scan.close();
		
	}

}
