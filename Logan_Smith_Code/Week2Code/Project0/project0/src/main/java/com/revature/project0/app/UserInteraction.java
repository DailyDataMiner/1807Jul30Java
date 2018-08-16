package com.revature.project0.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.revature.project0.myexceptions.InvalidUsernameException;
import com.revature.project0.myexceptions.NotEnoughMoneyException;
import com.revature.project0.myexceptions.UsernameTakenException;
import com.revature.project0.projectobjects.Account;
import com.revature.project0.projectobjects.AccountType;
import com.revature.project0.projectobjects.User;
import com.revature.project0.service.AccountService;
import com.revature.project0.service.AccountTypeService;
import com.revature.project0.service.UserService;
import com.revature.project0.service.UserToAccountService;

public class UserInteraction {

	App app;
	
	static Scanner scanner = new Scanner(System.in);
	static AccountService accountService = new AccountService();
	static UserService userService = new UserService();
	static UserToAccountService utaService = new UserToAccountService();
	static AccountTypeService atService = new AccountTypeService();
	
	public UserInteraction(App newApp) {
		app = newApp;
	}
	
	public void createUser() {
		System.out.println("\nHello new user!");
		System.out.println("Please set a username:");
		String username = "";
		for (String attempt = ""; username.equals("");) {
			attempt = scanner.nextLine();
			try {
				userService.newUsername(attempt);
				username = attempt;
			} catch (UsernameTakenException e) {
				System.out.println(e.getMessage());
			} catch (InvalidUsernameException e) {
				System.out.println(e.getMessage());
			}
		}
		System.out.println("Please enter a password:");
		String password = scanner.nextLine();
		System.out.println("What is your first name?");
		String firstname = scanner.nextLine();
		System.out.println("What is your last name?");
		String lastname = scanner.nextLine();
		User user = new User(username, password, firstname, lastname);
		userService.saveUser(user);
		app.userMenu(user);
	}
	
	public void createAccount(User currentUser) {
		{
			System.out.println("Which type of account would you like to create?\n");
			List<AccountType> accountTypes = new ArrayList<AccountType>();
			accountTypes = atService.getAll();
			for (AccountType accountType : accountTypes) {
				System.out.println(accountType);
			}
			System.out.println("\nPlease enter the id of the account you would like to create:");
			System.out.println("Or enter 'return' if you'd like to go back.");
			int option2 = 0;
			while (option2 == 0) {
				try {
					String input = scanner.nextLine();
					if (input.equals("return")) {
						app.userMenu(currentUser);
					}
					option2 = Integer.parseInt(input);
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
			if (currentAT == null) {
				System.out.println("Not a valid account type.");
				createAccount(currentUser);
				return;
			}
			System.out.println("How much money would you like to start this account with?");
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
			return;
		}
	}
	public void login() {
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
			//app.menu();
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
			return;
		}
		app.userMenu(currentUser);
	}
	public void changeUsername(User currentUser) {
		System.out.println("Are you sure you want to change the username of this account?");
		System.out.println("Input 'confirm' if so. Otherwise, enter anything else.");
		String option2 = scanner.nextLine();
		if (!option2.equals("confirm")) {
			return;
		}
		System.out.println("Please enter your new username:");
		String iusername = "";
		for (String attempt = ""; iusername.equals("");) {
			attempt = scanner.nextLine();
			try {
				userService.updateUsername(currentUser, attempt);
				iusername = attempt;
			} catch (InvalidUsernameException e) {
				System.out.println(e.getMessage());
			} catch (UsernameTakenException e) {
				System.out.println(e.getMessage());
			}
		}
		System.out.println("Username updated.");
		return;
	}
	
	public void changePassword (User currentUser) {
		System.out.println("Are you sure you want to change the password of this account?");
		System.out.println("Input 'confirm' if so. Otherwise, enter anything else.");
		String option2 = scanner.nextLine();
		if (!option2.equals("confirm")) {
			return;
		}
		System.out.println("Please enter your new password:");
		String iusername = scanner.nextLine();
		userService.updatePassword(currentUser, iusername);
		System.out.println("Password updated.");
		return;
	}
	public void changeName(User currentUser) {
		System.out.println("Are you sure you want to change the name of this account?");
		System.out.println("Input 'confirm' if so. Otherwise, enter anything else.");
		String option2 = scanner.nextLine();
		if (!option2.equals("confirm")) {
			return;
		}
		System.out.println("Please enter your new First Name:");
		String ifirstname = scanner.nextLine();
		System.out.println("Please enter your new Last Name:");
		String ilastname = scanner.nextLine();
		userService.updateName(currentUser, ifirstname, ilastname);
		System.out.println("Name updated.");
		return;
	}
	
	public void accessAccounts(User currentUser) {
		System.out.println("\nAvailable Accounts:");
		List<Account> accounts = new ArrayList<Account>();
		accounts = utaService.getAllLinkedAccounts(currentUser.getUserID());
		for (Account account : accounts) {
			System.out.println(account);
		}
		System.out.println("\nPlease enter the ID of the account you'd like to sign into.");
		System.out.println("Enter 'return' to go back.");
		int option = 0;
		while (option == 0) {
			try {
				String checker = scanner.nextLine();
				if (checker.equals("return")) {
					return;
				}
				option = Integer.parseInt(checker);
				if (option <= 0) {
					System.out.println("Incorrect Input");
					option = 0;
				}
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
		app.accountMenu(currentUser, currentAccount);
	}
	public void deposit(User currentUser, Account currentAccount) {
		System.out.println("How much would you like to deposit?");
		double option2 = -1;
		while (option2 < 0) {
			try {
				option2 = Double.parseDouble(scanner.nextLine());
				if (option2 < 0) {
					System.out.println("You cannot deposit a negative amount.");
				}
			} catch (NumberFormatException e) {
				System.out.println("Incorrect input. Enter an amount.");
			}
		}
		accountService.deposit(currentAccount, option2);
		return;
	}
	public void withdraw(User currentUser, Account currentAccount) {
		System.out.println("How much would you like to withdraw?");
		double option2 = -1;
		while (option2 < 0) {
			try {
				option2 = Double.parseDouble(scanner.nextLine());
				if (option2 < 0) {
					System.out.println("You cannot withdraw a negative amount.");
				}
			} catch (NumberFormatException e) {
				System.out.println("Incorrect input. Enter an amount.");
			}
		}
		try {
			accountService.withdraw(currentAccount, option2);
		} catch (NotEnoughMoneyException e) {
			System.out.println(e.getMessage());
			withdraw(currentUser, currentAccount);
			return;
		}
		return;
	}
	public void transfer(User currentUser, Account currentAccount) {
		System.out.println("Which account would you like to transfer funds to?\n");
		List<Account> accounts = new ArrayList<Account>();
		accounts = utaService.getAllLinkedAccounts(currentUser.getUserID());
		for (Account account : accounts) {
			System.out.println(account);
		}
		System.out.println("\nPlease enter the account ID");
		System.out.println("Or enter 'return' to go back.");
		Account nextAccount = null;
		int option2 = 0;
		while (option2 == 0) {
			try {
				String attempt = scanner.nextLine();
				if (attempt.equals("return")) {
					return;
				}
				option2 = Integer.parseInt(attempt);
			} catch (NumberFormatException e) {
				System.out.println("Incorrect input. Enter an accountid.");
			}
		}
		for (Account account : accounts) {
			if (option2 == account.getAccountID()) {
				nextAccount = accountService.getOne(option2);
			}
		}
		if (nextAccount == null) {
			System.out.println("That account does not exist.");
			transfer(currentUser, currentAccount);
			return;
		}
		System.out.println("How much would you like to transfer?");
		double option3 = -1;
		while (option3 < 0) {
			try {
				option3 = Double.parseDouble(scanner.nextLine());
				if (option3 < 0) {
					System.out.println("You cannot transfer a negative amount.");
				}
			} catch (NumberFormatException e) {
				System.out.println("Incorrect input. Enter an amount.");
			}
		}
		try {
			accountService.transfer(currentAccount, nextAccount, option3);
		} catch (NotEnoughMoneyException e) {
			System.out.println(e.getMessage());
		}
		return;
	}
	public void deleteAccount(User currentUser, Account currentAccount) {
		System.out.println("Are you sure you want to delete this account?");
		System.out.println("Input 'confirm' if so. Otherwise, enter anything else.");
		String option2 = scanner.nextLine();
		if (option2.equals("confirm")) {
			accountService.deleteAccount(currentAccount);
			app.userMenu(currentUser);
		} else {
			return;
		}
	}
	public void addUserToAccount(User currentUser, Account currentAccount) {
		System.out.println("Enter the username of the user you'd like to add to this account.");
		System.out.println("Or enter 'return' to go back.");
		String option2 = scanner.nextLine();
		if (option2.equals("return")) {
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
			app.accountMenu(currentUser, currentAccount);
			return;
		}
		utaService.saveUserToAccount(nextUser, currentAccount);
		System.out.println("New user added to account.");
		app.accountMenu(currentUser, currentAccount);
	}
	public void removeUserFromAccount(User currentUser, Account currentAccount) {
		System.out.println("These users are linked to this account.\n");
		List<User> users = utaService.getAllLinkedUsers(currentAccount.getAccountID());
		for (User user : users) {
			System.out.println(user);
		}
		if (users.size() == 1) {
			System.out.println("You are the only user attached to this account.");
			System.out.println("If you wish to remove the account, please use the remove account option.");
			app.accountMenu(currentUser, currentAccount);
		}
		System.out.println("\nEnter the username of the user you would like to remove.");
		System.out.println("Otherwise, enter 'return'.");
		String userToDelete = scanner.nextLine();
		if (userToDelete.equals("return")) {
			app.accountMenu(currentUser, currentAccount);
		}
		User nextUser = null;
		for (User user : users) {
			if (userToDelete.toLowerCase().equals(user.getUsername())) {
				nextUser = user;
			}
		}
		if (nextUser == null) {
			System.out.println("That user does not exist.");
			app.accountMenu(currentUser, currentAccount);
		}
		utaService.deleteUserToAccount(nextUser, currentAccount);
		System.out.println("User removed from account.");
		if (nextUser.equals(currentUser)) {
			app.userMenu(currentUser);
			return;
		}
		app.accountMenu(currentUser, currentAccount);
	}
	
}
