package com.revature.project0.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.revature.project0.projectobjects.Account;
import com.revature.project0.projectobjects.AccountType;
import com.revature.project0.projectobjects.User;
import com.revature.project0.service.AccountService;
import com.revature.project0.service.AccountTypeService;
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
	static AccountTypeService atService = new AccountTypeService();

	public static void main(String[] args) {
		System.out.println("Welcome to the Logan Smith Virtual Banking App!\n");
		menu();
	}

	static void menu() {
		System.out.println("Please select an option:");
		System.out.println("1: Login \n" + "2: Sign Up\n" + "3: Exit");
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
			System.out.println("Hello new user!");
			System.out.println("Please set a username:");
			String username = scanner.nextLine();
			while (!userService.newUsername(username)) {
				System.out.println("Username already in use.");
				username = scanner.nextLine();
			}
			System.out.println("Please enter a password:");
			String password = scanner.nextLine();
			System.out.println("What is your first name?");
			String firstname = scanner.nextLine();
			System.out.println("What is your last name?");
			String lastname = scanner.nextLine();
			User user = new User(username, password, firstname, lastname);
			userService.saveUser(user);
			userMenu(user);
			break;
		case 3:
			System.out.println("\nThank you for using the banking app!");
			System.out.println("Goodbye!");
			return;
		default:
			System.out.println("Not a valid input.");
			menu();
			break;
		}
	}
	
	public static void login() {
		System.out.println("\nPlease input your username or input 'return' to go back.");
		String username = "";
		while (username.equals("")) {
			try {
				username = scanner.nextLine();
			} catch (Exception e) {
				System.out.println("Incorrect input.");
			}
		}
		if (username.equals("return")) {
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
		case 2: {
			System.out.println("Which type of account would you like to create?");
			List<AccountType> accountTypes = new ArrayList<AccountType>();
			accountTypes = atService.getAll();
			for (AccountType accountType : accountTypes) {
				System.out.println(accountType);
			}
			System.out.println("Please enter the id of the account you would like to create:");
			int option2 = 0;
			while (option2 == 0) {
				try {
					option2 = Integer.parseInt(scanner.nextLine());
				} catch (NumberFormatException e) {
					System.out.println("Incorrect input.");
				}
			}
			AccountType currentAT = null;
			for (AccountType accountType : accountTypes) {
				if (accountType.getAccountTypeID() == option2) {
					currentAT = accountType;
				}
			}
			System.out.println("How much money would you like to to start this account with?");
			double ibalance = -1;
			while (ibalance < 0) {
				try {
					ibalance = Double.parseDouble(scanner.nextLine());
				} catch (NumberFormatException e) {
					System.out.println("Incorrect input.");
					continue;
				}
				if (ibalance < 0) {
					System.out.println("You cannot start with a negative balance.");
				}
			}
			Account newAccount = new Account(currentAT.getAccountTypeID(), ibalance);
			accountService.saveAccount(newAccount);
			utaService.saveUserToAccount(currentUser, newAccount);
			System.out.println("Created new account.");
			userMenu(currentUser);
			break;
		}
		case 3: {
			System.out.println("Are you sure you want to change the username of this account?");
			System.out.println("Input 'confirm' if so. Otherwise, enter anything else.");
			String option2 = scanner.nextLine();
			if (!option2.equals("confirm")) {
				userMenu(currentUser);
			}
			System.out.println("Please enter your new username:");
			String iusername = scanner.nextLine();
			while (userService.updateUsername(currentUser, iusername) == null) {
				System.out.println("Username already in use.");
				iusername = scanner.nextLine();
			}
			System.out.println("Username updated.");
			userMenu(currentUser);
			break;
		}
		case 4: {
			System.out.println("Are you sure you want to change the password of this account?");
			System.out.println("Input 'confirm' if so. Otherwise, enter anything else.");
			String option2 = scanner.nextLine();
			if (!option2.equals("confirm")) {
				userMenu(currentUser);
			}
			System.out.println("Please enter your new password:");
			String iusername = scanner.nextLine();
			userService.updatePassword(currentUser, iusername);
			System.out.println("Password updated.");
			userMenu(currentUser);
			break;
		}
		case 5: {
			System.out.println("Are you sure you want to change the name of this account?");
			System.out.println("Input 'confirm' if so. Otherwise, enter anything else.");
			String option2 = scanner.nextLine();
			if (!option2.equals("confirm")) {
				userMenu(currentUser);
			}
			System.out.println("Please enter your new First Name:");
			String ifirstname = scanner.nextLine();
			System.out.println("Please enter your new Last Name:");
			String ilastname = scanner.nextLine();
			userService.updateName(currentUser, ifirstname, ilastname);
			System.out.println("Name updated.");
			userMenu(currentUser);
			break;
		}
		case 6:
			menu();
			break;
		default:
			System.out.println("Not a valid option.");
			userMenu(currentUser);
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
		System.out.println("Enter 'return' to go back.");
		int option = 0;
		while (option == 0) {
			try {
				String checker = scanner.nextLine();
				if (checker.equals("return")) {
					userMenu(currentUser);
				}
				option = Integer.parseInt(checker);
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
		"6: Remove a User from this Account\n" +
		"7: Exit Account");
		int option = 0;
		while (option == 0) {
			try {
				option = Integer.parseInt(scanner.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("Incorrect input.");
			}
		}
		switch (option) {
		case 1: {
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
		}
		case 2: {
			System.out.println("How much would you like to withdraw?");
			double option2 = 0;
			while (option2 == 0) {
				try {
					option2 = Double.parseDouble(scanner.nextLine());
				} catch (NumberFormatException e) {
					System.out.println("Incorrect input. Enter an amount.");
				}
			}
			accountService.withdraw(currentAccount, option2);
			accountMenu(currentUser, currentAccount);
			break;
		}
		case 3: {
			System.out.println("Which account would you like to transfer funds to?");
			List<Account> accounts = new ArrayList<Account>();
			accounts = utaService.getAllLinkedAccounts(currentUser.getUserID());
			Account nextAccount = null;
			double option2 = 0;
			while (option2 == 0) {
				try {
					option2 = Double.parseDouble(scanner.nextLine());
				} catch (NumberFormatException e) {
					System.out.println("Incorrect input. Enter an accountid.");
				}
			}
			for (Account account : accounts) {
				if (option2 == account.getAccountID()) {
					nextAccount = accountService.getOne(option);
				}
			}
			if (nextAccount == null) {
				System.out.println("That account does not exist.");
				accountMenu(currentUser, currentAccount);
				return;
			}
			System.out.println("How much would you like to transfer?");
			double option3 = 0;
			while (option3 == 0) {
				try {
					option3 = Double.parseDouble(scanner.nextLine());
				} catch (NumberFormatException e) {
					System.out.println("Incorrect input. Enter an amount.");
				}
			}
			accountService.transfer(currentAccount, nextAccount, option3);
			accountMenu(currentUser, currentAccount);
			break;
		}
		case 4: {
			System.out.println("Are you sure you want to delete this account?");
			System.out.println("Input 'confirm' if so. Otherwise, enter anything else.");
			String option2 = scanner.nextLine();
			if (option2.equals("confirm")) {
				accountService.deleteAccount(currentAccount);
				userMenu(currentUser);
			}
			else {
				accountMenu(currentUser, currentAccount);
			}
			break;
		}
		case 5: {
			System.out.println("Enter the username of the user you'd like to add to this account.");
			System.out.println("Or enter 'return' to go back.");
			String option2 = scanner.nextLine();
			if (option2.equals("return")) {
				accountMenu(currentUser, currentAccount);
				return;
			}
			User nextUser = null;
			List<User> users = new ArrayList<User>();
			users = userService.getAll();
			for (User user : users) {
				if (option2.equals(user.getUsername())) {
					nextUser = userService.getOne(user.getUserID());
				}
			}
			if (nextUser == null) {
				System.out.println("That user does not exist.");
				accountMenu(currentUser, currentAccount);
				return;
			}
			utaService.saveUserToAccount(nextUser, currentAccount);
			System.out.println("New user added to account.");
			accountMenu(currentUser, currentAccount);
			break;
		}
		case 6: {
			System.out.println("These users are linked to this account.");
			List<User> users = utaService.getAllLinkedUsers(currentAccount.getAccountID());
			for (User user : users) {
				System.out.println(user);
			}
			System.out.println("Enter the username of the user you would like to remove.");
			System.out.println("Otherwise, enter 'return'.");
			String userToDelete = scanner.nextLine();
			User nextUser = null;
			for (User user : users) {
				if (userToDelete.toLowerCase().equals(user.getUsername())) {
					nextUser = user;
				}
			}
			if (nextUser == null) {
				System.out.println("That user does not exist.");
				accountMenu(currentUser, currentAccount);
			}
			utaService.deleteUserToAccount(nextUser, currentAccount);
			System.out.println("User removed from account.");
			accountMenu(currentUser, currentAccount);
			break;
		}
		case 7:
			userMenu(currentUser);
			break;
		}
	}
}
