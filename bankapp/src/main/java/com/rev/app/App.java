package com.rev.app;

import java.util.Scanner;
import com.rev.service.UserService;

public class App { 
	
	public static void main(String[] args) {
		System.out.println("Welcome to the bank!");
		menu();
//		UserService.addUser();
//		UserService.userLogin();
	}

	public static void menu() {
		
		System.out.println("----- Main Menu -----\n" + "Enter 1 to log in to your account\n"
				+ "Enter 2 to make a new account\n" + "Enter 3 to close the program\n");
		
		Scanner iceCave = new Scanner(System.in);
		String s = iceCave.nextLine();
		int option = Integer.parseInt(s);

		if(option != 1 && option != 2 && option != 3 || s == null) {
			System.out.println("Sorry, you must enter a number between 1 and 3!");
			menu();
		}

		switch (option) {
		case 1:
			UserService.userLogin();
			break;
		case 2:
			UserService.addUser();
			break;
		case 3:
			closeProgram(option);
			break;
		}
		iceCave.close();
	}
	
	public static void closeProgram(int option) {
		System.out.println("Thank you for using our banking app!");
		System.exit(option);
	}
	
}