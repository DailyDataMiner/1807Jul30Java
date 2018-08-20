package com.revature.io;

import java.util.Scanner;	
import static java.lang.System.in;
//static imports allow us to access static fields of the class w/o class name

public class ScannerExample {

	public static void main(String[] args) {
		System.out.println("Hello! Welcome! Enter your name");
		Scanner scan = new Scanner(in);
		String name = scan.nextLine();
		System.out.println("Hey, "  + name + "! Please enter your age");
		String age = scan.nextLine();
		int a;
		try {
			a = Integer.parseInt(age);
		} catch(NumberFormatException nfe) {
			nfe.printStackTrace();
			System.out.println("Please enter a valid age");
		}
		System.out.println(age);
		
		
		scan.close();
		
		
	}

}
