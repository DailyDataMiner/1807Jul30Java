package com.revature.project0.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.revature.project0.projectobjects.Account;
import com.revature.project0.projectobjects.User;
import com.revature.project0.service.AccountService;
import com.revature.project0.service.UserService;
import com.revature.project0.service.UserToAccountService;

public class App {
	/*
	 * BOOK STORE APP AND DRIVER
	 */

	static Scanner scanner = new Scanner(System.in);
	static AccountService accountService = new AccountService();
	static UserService userService = new UserService();
	static UserToAccountService utaService = new UserToAccountService();

	public static void main(String[] args) {
		System.out.println("Welcome to the Logan Smith Virtual Banking App!");
		menu();
	}

	static void menu() {
		System.out.println("Please select a option:");
		System.out.println("1: Login \n" + "2: Sign Up");
		int option = 0;
		while (option == 0) {
			try {
				option = Integer.parseInt(scanner.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("Incorrect input.");
			}
		}
		switch (option) {
		case 1:
			login();
			break;
		case 2:
			break;
		case 3:
			break;
		case 4:
			//addBook();
			break;
		case 5:
			break;
		case 6:
			break;
		default:
			break;
		}
	}
	
	public static void login() {
		System.out.println("Please input your username or input 'Return' to go back.");
		String username = "";
		while (username.equals("")) {
			try {
				username = scanner.nextLine();
			} catch (Exception e) {
				System.out.println("Incorrect input.");
			}
		}
		if (username.equals("Return")) {
			menu();
			return;
		}
		System.out.println("Please input your password:");
		String password = "";
		while (password.equals("")) {
			try {
				password = scanner.nextLine();
			} catch (Exception e) {
				System.out.println("Incorrect input.");
			}
		}
		User currentUser = userService.login(username, password);
		if (currentUser == null) {
			System.out.println("Incorrent Username/Password.");
			login();
		}
		userMenu(currentUser);
	}
	
	public static void userMenu(User currentUser) {
		System.out.println("Hello " + currentUser.getFirstName());
		System.out.println("What would you like to do?");
		System.out.println("1: Access Accounts\n" + 
		"2: Add Account\n" + 
		"3: Change Username\n" +
		"4: Change Password\n" + 
		"5: Change Name\n" + 
		"6: Logout");
		int option = 0;
		while (option == 0) {
			try {
				option = Integer.parseInt(scanner.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("Incorrect input.");
			}
		}
		switch (option) {
		case 1:
			accessAccounts(currentUser);
			break;
		case 2:
			break;
		case 3:
			break;
		case 4:
			//addBook();
			break;
		case 5:
			break;
		case 6:
			break;
		default:
			break;
		}
	}
	
	public static void accessAccounts(User currentUser) {
		System.out.println("Available Accounts:");
		List<Account> accounts = new ArrayList<Account>();
		accounts = utaService.getAllLinkedAccounts(currentUser.getUserID());
		for (Account account : accounts) {
			System.out.println(account);
		}
		System.out.println("Please enter the ID of the account you'd like to sign into.");
		int option = 0;
		while (option == 0) {
			try {
				option = Integer.parseInt(scanner.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("Incorrect input.");
			}
		}
		Account currentAccount = null;
		for (Account account : accounts) {
			if (option == account.getAccountID()) {
				currentAccount = accountService.getOne(option);
			}
		}
		if (currentAccount == null) {
			System.out.println("That account does not exist.");
			accessAccounts(currentUser);
			return;
		}
		accountMenu(currentUser, currentAccount);
	}
	
	public static void accountMenu(User currentUser, Account currentAccount) {
		
		System.out.println("Your account balance is: " + currentAccount.getBalance());
		System.out.println("What would you like to do with this account?");
		System.out.println(
		"1: Deposit Funds\n" +
		"2: Withdraw Funds\n" +
		"3: Transfer Funds\n" + 
		"4: Remove Account\n"+ 
		"5: Add a User to this Account\n" +
		"6: Exit Account");
		int option = 0;
		while (option == 0) {
			try {
				option = Integer.parseInt(scanner.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("Incorrect input.");
			}
		}
		switch (option) {
		case 1:
			System.out.println("How much would you like to deposit?");
			double option2 = 0;
			while (option2 == 0) {
				try {
					option2 = Double.parseDouble(scanner.nextLine());
				} catch (NumberFormatException e) {
					System.out.println("Incorrect input. Enter an amount.");
				}
			}
			accountService.deposit(currentAccount, option2);
			accountMenu(currentUser, currentAccount);
			break;
		case 2:
			break;
		case 3:
			break;
		case 4:
			break;
		case 5:
			break;
		case 6:
			break;
		}
	}
//	public static void getBooks() {
//		System.out.println("Current Books:");
//		List<Book> books = bookService.getAll();
//		for (Book b : books) {
//			System.out.println(b.toString());
//		}
//	}
//	public static void addBook() {
//		System.out.println("Enter your book's title:");
//		String title = scanner.nextLine();
//		System.out.println("Enter the ISBN");
//		String isbn = scanner.nextLine();
//		System.out.println("Enter the price:");
//		double price = scanner.nextDouble();
//		System.out.println("Select your genre(Enter Number):");
//		List<Genre> genres = gService.getAll();
//		for (int i = 0; i < genres.size(); i++) {
//			System.out.println(i+1 + " : " + genres.get(i+1));
//		}
//		int genreIndex = Integer.parseInt(scanner.nextLine())-1;
//		int genreID = genres.get(genreIndex).getId();
//		Book b = new Book(isbn, title, price, genreID);
//	}

}
