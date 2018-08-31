package com.zero.main;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;
import java.util.Scanner;

import com.zero.pojos.Account;
import com.zero.pojos.User;
import com.zero.service.AccountService;
import com.zero.service.UserService;

public class App {
	
	static Scanner scanner = new Scanner(System.in);
	static UserService uService = new UserService();
	static AccountService aService = new AccountService();

	public static void main(String[] args) {
		System.out.println("***Welcome to Revature Bank!***\n"
				+ "How may we help you today?");
		menu();
	}
	
	static void menu() {
		System.out.print("--------------------\n"
				+ "1) Login\n"
				+ "2) Create Account\n"
				+ "3) Exit\n"
				+ "Please select an option: ");
		int option = 0;
		try {
			option = Integer.parseInt(scanner.nextLine());
		} catch(NumberFormatException e) {
			System.out.println("Invalid option choice. Please enter a number.");
			menu();
		}
		
		switch(option) {
		case 1:
			User session = login();
			newSession(session);
			break;
		case 2:
			createAccount();
			break;
		case 3:
			System.out.println("Thank you for using Revature Bank! Goodbye!");
			System.exit(0);
		default:
			System.out.println("Invalid Option Number. Please try again.");
			menu();
		}
	}
	
	static void newSession(User session) {
		System.out.print("--------------------\n"
				+ "1) List Accounts\n"
				+ "2) Create Banking Account\n"
				+ "3) Logout\n"
				+ "Please select an option: ");
		int option = 0;
		try {
			option = Integer.parseInt(scanner.nextLine());
		} catch (NumberFormatException e) {
			System.out.println("Invalid option choice. Please enter a number.");
			newSession(session);
		}
		
		switch(option) {
			case 1:
				viewAccounts(session.getId());
				transaction(session.getId());
				break;
			case 2:
				createBankAccount(session.getId());
				break;
			case 3:
				System.out.println("Thank you for using Revature Bank. Goodbye!");
				System.exit(0);
			default:
				System.out.println("Invalid Option Number. Please try again.");
				newSession(session);
		}
	}
	
	static void transaction(int id) {
		System.out.print("--------------------\n"
				+ "1) Withdraw Funds\n"
				+ "2) Deposit Funds\n"
				+ "3) Logout\n"
				+ "Please select an option: ");
		int option = 0;
		try {
			option = Integer.parseInt(scanner.nextLine());
		} catch (NumberFormatException e) {
			System.out.println("Invalid Option Choice. Please enter a number.");
			transaction(id);
		}
		
		switch(option) {
			case 1:
				withdraw(id);
				break;
			case 2:
				deposit(id);
				break;
			case 3:
				System.out.println("Thank you for using Revature Bank! Goodbye!");
				System.exit(0);
			default:
				System.out.println("Invalid Option Number. Please try again.");
				transaction(id);
		}
	}
	
	static void withdraw(int id) {
		System.out.print("Select the number of the account you would like to withdraw from: ");
		
		List<Account> accounts = aService.listAccounts(id);
		int accountIndex = Integer.parseInt(scanner.nextLine())-1;
		int accountID = accounts.get(accountIndex).getId();
		
		System.out.print("How much would you like to withdraw?: ");
		double amount = Double.parseDouble(scanner.nextLine());
		
		Account temp = aService.getAccount(accountID);
		if(temp.getBalance() >= amount) {
			Account updated = new Account(temp.getId(), temp.getType(), temp.getBalance()-amount, temp.getUserid());
			
			aService.updateAccount(updated);
			
			System.out.println("Withdrawal Successful. The remaining balance on this account is: $" + updated.getBalance());
			System.out.print("Would you like to make another transaction? Please enter yes or no: ");
			
			String choice = scanner.nextLine();
			if(choice.equals("yes")) {
				viewAccounts(id);
				transaction(id);
			}
			else {
				System.out.println("Thank you for using Revature Bank! Goodbye!");
				System.exit(0);
			}
		}
		else {
			System.out.println("Withdrawal amount is larger than funds available. Transaction aborted.");
			viewAccounts(id);
			transaction(id);
		}
	}
	
	static void deposit(int id) {
		System.out.print("Select the number of the account you would like to deposit into: ");
		
		List<Account> accounts = aService.listAccounts(id);
		int accountIndex = Integer.parseInt(scanner.nextLine())-1;
		int accountID = accounts.get(accountIndex).getId();
		
		System.out.print("How much would you like to deposit?: ");
		double amount = Double.parseDouble(scanner.nextLine());
		
		Account temp = aService.getAccount(accountID);
		
		Account updated = new Account(temp.getId(), temp.getType(), (temp.getBalance()+amount), temp.getUserid());
		
		aService.updateAccount(updated);
		
		System.out.println("Deposit Successful. The remaining balance on this account is: $" + updated.getBalance());
		System.out.print("Would you like to make another transaction? Please enter yes or no: ");
		
		String choice = scanner.nextLine();
		if(choice.equals("yes")) {
			viewAccounts(id);
			transaction(id);
		}
		else {
			System.out.println("Thank you for using Revature Bank! Goodbye!");
			System.exit(0);
		}
	}
	
	static User login() {
		System.out.print("Please enter your username: ");
		String username = scanner.nextLine();
		
		System.out.print("Please enter your password: ");
		String password = scanner.nextLine();
		
		List<User> users = uService.getUsers();
		boolean exists = false;
		for(User u : users) {
			if(u.getUsername().toLowerCase().equals(username.toLowerCase())) {
				exists = true;
				if(u.getPassword().equals(password)) {
					System.out.println("Login successful. Welcome, " + u.getFirstname() + " " + u.getLastname() + "!");
					return u;
				}
				else {
					System.out.println("Password incorrect. Please try again.");
					menu();
					break;
				}
			}
		}
		if(exists == false) {
			System.out.println("Username does not exist. Please try again, or create a new account.");
			menu();
		}
		return null;
	}

	static void createAccount() {
		System.out.print("Enter your first name: ");
		String firstname = scanner.nextLine();
		
		System.out.print("Enter your last name: ");
		String lastname = scanner.nextLine();
		
		System.out.print("Enter your username: ");
		String username = scanner.nextLine();
		
		System.out.print("Enter your password: ");
		String password = scanner.nextLine();
		
		User newUser = new User(firstname, lastname, username, password);
		
		List<User> users = uService.getUsers();
		boolean exists = false;
		for(User u : users) {
			if(u.getUsername().toLowerCase().equals(username.toLowerCase())) {
				exists = true;
				break;
			}
		}
		
		if(exists == false) {
			uService.addUser(newUser);
			
			System.out.println("User account created successfully. Welcome, " + newUser.getFirstname() + " " + newUser.getLastname() + ".");
			System.out.println("For confirmation, your login information is as follows:\n"
					+ "Username: " + newUser.getUsername() + "\n"
					+ "Password: " + newUser.getPassword());
		}
		else {
			System.out.println("Username is taken. Please try again.");
		}
		menu();
	}
	
	static void viewAccounts(int id) {
		System.out.println("Current Accounts");
		List<Account> accounts = aService.listAccounts(id);
		int listNumber = 1;
		NumberFormat formatter = new DecimalFormat("#0.00");
		for(Account a : accounts) {
			System.out.println(listNumber + ") Account Type: " + a.getType() + " -- Account Balance: $" + formatter.format(a.getBalance()));
			listNumber++;
		}
	}
	
	static void createBankAccount(int userID) {
		System.out.print("Please enter the type of account you wish to create (Checking, Savings, or Credit): ");
		String inType = scanner.nextLine();
		
		Account newAccount = new Account(inType, 1000.00, userID);
		
		List<Account> accounts = aService.listAccounts(userID);
		boolean exists = false;
		for(Account a : accounts) {
			if(a.getType().equals(inType)) {
				exists = true;
				break;
			}
		}
		
		if(exists == false) {
			aService.addAccount(newAccount);
			
			NumberFormat formatter = new DecimalFormat("#0.00");
			System.out.println("Account successfully created. Revature Bank has generously deposited $1000.00\n"
					+ "into your new account as our way of saying thanks for banking with us.");
			System.out.println("Your new account is as follows:\n"
					+ "Account type: " + newAccount.getType() + "\n"
							+ "Account Balance: $" + formatter.format(newAccount.getBalance()));
		}
		else {
			System.out.println("Banking Account already exists. Returning to login page.");
		}
		newSession(uService.getUser(userID));
	}
}
