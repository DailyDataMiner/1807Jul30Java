package com.revature.io;

import java.util.Scanner;

public class ScannerExample {

	public static void main(String[] args) {
		System.out.println("Enter your name:");
		Scanner scan = new Scanner(System.in);
		String name = scan.nextLine();
		
		System.out.println("Hi, " + name + "! Please enter your age: ");
		String a = scan.nextLine();
		int age;
		try {
			age = Integer.parseInt(a);
		} catch(NumberFormatException nfe) {
			nfe.printStackTrace();
			System.out.println("Please enter a valid number");
			age = 5;
		}
		System.out.println(age);
		scan.close();
	}

}
