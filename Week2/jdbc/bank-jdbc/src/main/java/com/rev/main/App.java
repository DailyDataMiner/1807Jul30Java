package com.rev.main;

import java.math.BigInteger;
import java.sql.SQLSyntaxErrorException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.rev.dao.ClientDao;
import com.rev.dao.UserClientDao;
import com.rev.pojos.Client;
import com.rev.pojos.MoneyAccount;
import com.rev.pojos.UserClient;
import com.rev.service.ClientService;
import com.rev.service.MoneyAccountService;
import com.rev.service.UserClientService;

public class App {

	static Scanner scanner = new Scanner(System.in);
	static UserClientService ucService = new UserClientService();
	static ClientDao cService = new ClientDao();
	static ClientService ccService = new ClientService();
	static MoneyAccountService maService = new MoneyAccountService();
	//static Customer_AccountRefService caService = new Customer_AccountRefService();
	static String username;
	static String password;

	public static void main(String[] args) {

		System.out.println("WELCOME to the Revature Banking App!\n\n"
				+ "Please enter your username and password to log in\n" + "If you're a new user, press 0 to sign up\n");

		login();

		menu();

	}

	static void menu() {//gives user options
		System.out.println("\n---------Welcome, please choose an option--------\n"
				+ "1. View Account Balance\n"
				+ "2. Withdraw\n"
				+ "3. Deposit\n"
				+ "4. Add Accounts\n"
				+ "5. Logout\n"
				);
		
	
		int option = 0;
		try {
			option = Integer.parseInt(scanner.nextLine());
		}
		catch(NumberFormatException e) {
			System.out.println("Please choose option 1 to 5 on the menu");
			menu();
		}
		
		switch(option) {
		case 1: //View all accounts
			maService.getAll();
			goback();
			break;
			
		case 2: //Withdraw
			System.out.println("How much would you like to withdraw?");
			double temp = scanner.nextDouble();
			System.out.println("Select 1 for Checking, 2 for Savings");
			int temp2 = scanner.nextInt();
			withdraw(temp, temp2);
			goback();
			break;
			
		case 3: 
			System.out.println("How much would you like to deposit?");
			double temp3 = scanner.nextDouble();
			System.out.println("How much would you like to deposit?");
			int temp4 = scanner.nextInt();
			deposit(temp3, temp4);
			goback();
			break;
			
		case 4: //Receive list of own accounts, then activates withdraw function, then returns to menu
			MoneyAccount mars = maService.getSession(username);
			goback();
			break;
			
		case 5: 
			login();
			break;
			
		default: //invalid options returns to menu
			System.out.println("Please choose option 1 to 5 on the menu");
			goback();
			break;
		}}

	static void goback() {
		System.out.println("Press 0 to return to the main menu");
		String gomenu = scanner.nextLine();
		if (gomenu.equals("0")) {
			menu();
		} else {
			goback();
		}
	}

	static void login() { // for existing users

		System.out.println("Please enter your username");
		System.out.print("Username: ");
		username = scanner.nextLine();
		if (username.equals("0")) { // press 0 if new user
			System.out.print("\n");
			newUser();

		} else if (ucService.itsnotHere(username) == true) {
			System.out.println("That username does not exist. Please try again.");
			login();
		} else {
			System.out.print("Password: ");
			String password1 = scanner.nextLine();

			if (ucService.belong(password1) == true) {
				password = password1;
				System.out.println("Login Successful");
				menu(); 
			}
			else {System.out.println("Username password combination not found");
				login();}

		}
	}

	// other option after login --> newUser instead for Sign Up
	static void newUser() {

		String password = null;
		System.out.println("To Begin account creation, enter a unique username");
		System.out.print("Username: ");
		String username = scanner.nextLine();

		if (ucService.itsnotHere(username) == false) {
			System.out.println("\nThe username you have entered as already been taken");
			newUser();
		} else {
			boolean flagpass = true;
			while (flagpass) {
				flagpass = false;
				System.out.print("Password: ");
				password = scanner.nextLine();
				if (password.length() < 8) {
					System.out.println("Your password needs to be at least 8 characters");
					flagpass = true;
				}
			}
		}

		System.out.print("Enter your first name: ");
		String firstname = scanner.nextLine();
		
		System.out.print("Enter your last name: ");
		String lastname = scanner.nextLine();
		
		System.out.print("Enter your street address: ");
		String streetaddress = scanner.nextLine();
		
		System.out.print("Enter your city: ");
		String city = scanner.nextLine();

		System.out.print("Enter your state (NA if not applicable): ");
		String state = null;
		boolean flag0 = true;
		while (flag0) {
			flag0 = false;
			state = scanner.nextLine();
			state.toUpperCase();
			if (state.length() != 2) {
				System.out.println("Please enter a valid state format ie. NC");
				System.out.print("Enter your state (NA if not applicable): ");
				flag0 = true;

			}

		}

		System.out.print("Enter your country: ");
		String country = scanner.nextLine();

		System.out.print("Enter your email: ");
		String email = scanner.nextLine();

		Client moi = new Client(firstname, lastname, streetaddress, city, state, country, email);
		moi = ccService.addClient(moi);

		UserClient user = new UserClient(username, password);
		user = ucService.addUserClient(user);
		
		
		
		System.out.println("Your account has been created");
	}

	static void withdraw(double amount, int where) {
		MoneyAccount cash = new MoneyAccount();
		if (amount == 0) {
			goback();
		} else if (amount < 0) {
			System.out.println("Your input must be positive");
			goback();
		} else if (where == 1) {
			MoneyAccount money = new MoneyAccount(cash.getSavingsbalance() - amount, cash.getCheckingbalance());
			money = maService.change(money);
		} else if (where == 2) {
			MoneyAccount money = new MoneyAccount(cash.getSavingsbalance(), cash.getCheckingbalance() - amount);
			money = maService.change(money);
		}

	}

	static void deposit(double amount, int where) {
		MoneyAccount cash = new MoneyAccount();
		if (amount == 0) {
			goback();
		} else if (amount < 0) {
			System.out.println("Your input must be positive");
			goback();
		} else if (where == 1) {
			MoneyAccount money = new MoneyAccount(cash.getSavingsbalance() + amount, cash.getCheckingbalance());
			money = maService.change(money);
		} else if (where == 2) {
			MoneyAccount money = new MoneyAccount(cash.getSavingsbalance(), cash.getCheckingbalance() + amount);
			money = maService.change(money);
		}
	}
}

// menu();

/*
 * static void menu() { System.out.println("---------Menu--------\n" +
 * "1. Deposit\n" + "2. T\n" + "3. View/Update Authors\n" + "4. Add Book\n" +
 * "5. Add Genre\n" + "6. Add Author"); int option = 0; try { //DONT USE
 * SCANNER.NEXT INT!!!!!! option = Integer.parseInt(scanner.nextLine()); }
 * catch(NumberFormatException e) {
 * System.out.println("Sorry, you must enter a number between 1 and 6 :)");
 * menu(); }
 * 
 * switch(option) { case 1: case 2:
 * 
 * break; case 3: break; case 4:
 * 
 * break; // } }
 */

/*
 * List<UserClient> genres = UserClientService.getAll(); for(int i = 0; i <
 * genres.size(); i++) { System.out.println(i+1 + ": " + genres.get(i));
 */

/*
 * static void addBook() { System.out.println("Enter your book's title:");
 * String title = scanner.nextLine();
 * System.out.println("Enter the ISBN (10-digit number):"); String isbn =
 * scanner.nextLine(); System.out.println("Enter the price:"); double price =
 * Double.parseDouble(scanner.nextLine()); //SURROUND IN TRY CATCH FOR NFE
 * System.out.println("Select your Genre(Enter its number)"); List<UserClient>
 * genres = UserClientService.getAll(); for(int i = 0; i < genres.size(); i++) {
 * System.out.println(i+1 + ": " + genres.get(i)); } int genreIndex =
 * Integer.parseInt(scanner.nextLine())-1; int genreID =
 * genres.get(genreIndex).getId(); Book b = new Book(isbn, title, price,
 * genreID); //call book service addBook() which calls dao addBook() //WE HAVE
 * MAINTAINED REFERENTIAL INTEGRITY
 * 
 * } static void viewGenres() { System.out.println("Current Genres:");
 * List<Genre> genres = gService.getAll(); for(Genre g : genres) {
 * System.out.println(g.getName()); } }
 */
