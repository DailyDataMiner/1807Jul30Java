package com.rev.app;

import java.util.Scanner;
import com.rev.service.UserService;

public class App { 
	
	public static void main(String[] args) {
		System.out.println("Welcome!\n");
		menu();
	}

	public static void menu() {
		
		System.out.println("----- Main Menu -----\n" + "Enter 1 to log in to your account\n"
				+ "Enter 2 to make a new account\n" + "Enter 3 to close the app\n");
		
		Scanner iceCave = new Scanner(System.in);
		String s = iceCave.nextLine();
		int option = 0;
		try{
			option = Integer.parseInt(s);
		}
		catch(NumberFormatException e){
			System.out.println("Sorry, you must enter a number between 1 and 3!\n");
			menu();
		}

		if(option != 1 && option != 2 && option != 3 || s == null) {
			System.out.println("Sorry, you must enter a number between 1 and 3!\n");
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