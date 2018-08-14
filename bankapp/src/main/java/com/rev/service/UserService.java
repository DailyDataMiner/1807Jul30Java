package com.rev.service;

import java.util.List;
import java.util.Scanner;

import com.rev.app.App;
import com.rev.dao.AccountDao;
import com.rev.dao.UserDao;
import com.rev.pojos.Account;
import com.rev.pojos.User;

public class UserService {
	
	public static void userLogin() {
		System.out.println("Login\n");
		
		Scanner loginScanner = new Scanner(System.in);

		System.out.println("Please enter your username: ");
		String uname = loginScanner.nextLine();
		System.out.println("Please enter your password: ");
		String pword = loginScanner.nextLine();

		User foundUser = UserDao.findForLogin(uname, pword);
				
		if(foundUser == null) {
			System.out.println("Login failed. Please try again.");
			userLogin();
		}
		else if(foundUser != null) {
			System.out.println("Login successful!");
			welcomeUserMenu(foundUser);
		}
		loginScanner.close();
	}

	static User addedUser = new User();
	static Scanner userScanner = new Scanner(System.in);
	
	public static void addUser() {

		System.out.println("Please enter your first name: ");
		String fname = userScanner.nextLine();

		System.out.println("Please enter your last name: ");
		String lname = userScanner.nextLine();

		System.out.println("Please enter your desired username: ");
		String uname = userScanner.nextLine();

		System.out.println("Please enter a password: ");
		String upass = userScanner.nextLine();

		addedUser.setFirstname(fname);
		addedUser.setLastname(lname);
		addedUser.setUsername(uname);
		addedUser.setUserpassword(upass);

		User checkedUser = UserDao.save(addedUser);
		
		if(checkedUser == null) {
			System.out.println("Username taken! Please make another selection: ");
			addUser();
		}
		else if(checkedUser != null) {
			System.out.println("Your Account has been created!\n");
			userLogin();
		}
	}
	
	public static void welcomeUserMenu(User loggedInUser) {
		
		int loggedInUsersID = loggedInUser.getUserid();
		List<Account> accounts = AccountDao.findAllOfUsersAccounts(loggedInUsersID);
		int numberOfAccounts = accounts.size();
		
		System.out.println("\nHello " + loggedInUser.getFirstname() + "\n");
		System.out.println("Your Accounts: \n");
		for (Account a : accounts) {
			System.out.println("|Account ID: " + a.getAccountid() + "| Account Type: " 
					+ a.getAccounttype() + "| Your Balance: $" + a.getAmount() + "0");
		}
		
		System.out.println("\nWhat would you like to do?\n" + "Enter 1 to make a deposit\n"
				+ "Enter 2 to make a withdrawal\n" + "Enter 3 to open a new account\n" + "Enter 4 to log out\n");
		
		Scanner iceCave = new Scanner(System.in);
		String s = iceCave.nextLine();
		int option = 0;
		try {
			option = Integer.parseInt(s);
		}
		catch(NumberFormatException e){
			System.out.println("Sorry, you must enter a number between 1 and 4!\n");
			welcomeUserMenu(loggedInUser);
		}

		if(option != 1 && option != 2 && option != 3 && option != 4 || s == null) {
			System.out.println("Sorry, you must enter a number between 1 and 4!");
			welcomeUserMenu(loggedInUser);
		}

		switch (option) {
		case 1:
			if(numberOfAccounts != 0) {
				AccountService.makeDeposit(loggedInUser);
			}
			else if(numberOfAccounts == 0) {
				System.out.println("You have no accounts!");
				welcomeUserMenu(loggedInUser);
			}
			break;
		case 2:
			if(numberOfAccounts != 0) {
				AccountService.makeWithdrawal(loggedInUser);
			}
			else if(numberOfAccounts == 0) {
				System.out.println("You have no accounts!");
				welcomeUserMenu(loggedInUser);
			}
			break;
		case 3:
			AccountService.openAccount(loggedInUser);
			break;
		case 4:
			String[] args = new String[1];
			App.main(args);
			break;
		}
		iceCave.close();
	}
}