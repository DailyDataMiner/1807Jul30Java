package com.rev.test;

import java.util.Scanner;

import com.rev.pojos.Users;
import com.rev.service.UserService;

public class Test {

	static double balance;
	static Users temp;
	public static int accType;
	static Scanner scanner = new Scanner(System.in);
	
	static UserService uService = new UserService();

	public static void main(String[] args) {
		/*
		 * Bank APP DRIVER should NOT interact directly with DAO layer! only the service
		 * layer
		 */
		System.out.println("WELCOME to Municipal Credit Union! Banking Application\n" + "What would you Like to do?");
		menu1();
	}

	static void menu1() {
		System.out.println("---------Login or Sign Up--------\n"

				+ "1. Sign Up New User\n" + "2. Login In to App!\n");
		int option = 0;
		try { // DONT USE SCANNER.NEXT INT!!!!!!

			option = Integer.parseInt(scanner.nextLine());

		} catch (NumberFormatException e) {
			System.out.println("Sorry, you must enter a Valid Number :)");
			menu1();
		}

		switch (option) {
		case 1:
			SignUpUser();
			//CreateAccount();
			break;
		case 2:
			LogIn();
			break;
		default:
			System.out.println("Sorry Please enter a Valid number");
			menu1();// change this to menu2
			break;

		}
	}

	static void SignUpUser() {
		
		int roleID = 2;
		
		System.out.println("Enter your Username:");
		String username = scanner.nextLine();
		System.out.println("Enter your password:");
		String password = scanner.nextLine();
		System.out.println("Enter your firstname:");
		String firstName = scanner.nextLine(); 		
		System.out.println("Enter your lastname:");
		String lastName = scanner.nextLine();
		System.out.println("Enter your email:");
		String email = scanner.nextLine();
		System.out.println("Enter your roleID:");
		roleID = scanner.nextInt();
			
		
		Users u = new Users(username, password,firstName, lastName, email, roleID);
		uService.insert(u);
		//call book service addBook() which calls dao addBook()
		//WE HAVE MAINTAINED REFERENTIAL INTEGRITY
		
	
}
	static void LogIn() {
		  
		System.out.println("Enter your username:");
		String username = scanner.nextLine();
		System.out.println("Enter your password:");
		String password = scanner.nextLine();
		
		
		temp = uService.findOneId(new Users(username, password));
		System.out.println(temp);
		
		
		//menu1();
		
		
		
		  
	}
}
