package com.revature.projectZero.UI;

import java.sql.SQLException;
import java.util.Scanner;

import com.revature.projectZero.Exceptions.InsufficientFundsException;
import com.revature.projectZero.POJO.Account;
import com.revature.projectZero.POJO.User;
import com.revature.projectZero.Service.Service;

public class UI {
	private static final Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		User u = null;
		do {
			u = firstMenu() == 1 ? createUser() : login();
		}while(u == null);
		int i = 0;
		while (true) {
			switch (mainMenu(u)) {
			case 1:
				createAccount(u);
				break;
			case 2:
				i = chooseAccount(u);
				System.out.println("Balance = " + u.getAccounts().get(i-1).getBalance());
				break;
			case 3:
				deposit(u);
				break;
			case 4:
				withdraw(u);
				break;
			case 5:
				System.out.println("Logging Out");
				return;
			}
		}
	}

	private static int getInput(int max) {
		int input = -1;
		do {
			try {
				System.out.print("Enter Command: ");
				input = Integer.parseInt(scan.nextLine());
			} catch (NumberFormatException e) {
				input = -1;
			}
		} while (input < 0);
		return input;
	}

	private static int firstMenu() {
		System.out.println("----------This is Bank----------");
		System.out.println("1) Create New User");
		System.out.println("2) Login to Existing User");
		System.out.println("--------------------------------");
		return getInput(2);
	}

	private static User login() {
		User u = null;
		do {
			System.out.print("Enter Username: ");
			String username = scan.nextLine();
			System.out.print("Enter Password: ");
			String password = scan.nextLine();
			try {
				u = Service.login(username, password);
				System.out.println("Login Successful");
			} catch (SQLException e) {
				System.out.println("Login failed, please try again.");
			}
		} while (u == null);
		return u;
	}

	private static User createUser() {
		User u = null;
		System.out.println("--------------------------------");
		System.out.print("Enter First Name: ");
		final String fn = scan.nextLine();
		System.out.print("Enter Last Name: ");
		final String ln = scan.nextLine();
		System.out.print("Choose Username: ");
		final String usr = scan.nextLine();
		System.out.print("Choose Password: ");
		final String pwd = scan.nextLine();
		u = Service.createUser(fn, ln, usr, pwd);
		if(u.getUserId() <= 0) {
			u = null;
			System.out.println("Account Creation Failed: Username Already Taken.\n\n");
		}
		return u;
	}

	private static int mainMenu(User u) {
		System.out.println("\n");
		System.out.println("-------This is Main Menu--------");
		System.out.println("1) Open a New Account");
		System.out.println("2) View Balance");
		System.out.println("3) Deposit");
		System.out.println("4) Withdraw");
		System.out.println("5) Log Out");
		System.out.println("--------------------------------");
		return getInput(5);
	}

	private static void createAccount(User u) {
		System.out.print("Choose Account Name: ");
		String accName = scan.nextLine();
		System.out.println("------Choose Account Type-------");
		System.out.println("1) Checking Account");
		System.out.println("2) Savings Account");
		System.out.println("--------------------------------");
		int accType = getInput(2);
		Account a = Service.createAccount(u.getUserId(), accType, accName);
		u.getAccounts().add(a);
		System.out.println("Account Created Sucessfully");
	}

	private static int chooseAccount(User u) {
		final int numAccounts = u.getAccounts().size();
		System.out.println("---------Choose Account---------");
		for(int i = 0; i < numAccounts; i++) {
			System.out.println((i+1) + ") " + u.getAccounts().get(i).getAccountName());
		}
		System.out.println("--------------------------------");
		return getInput(numAccounts);
	}
	
	private static void deposit(User u) {
		final int accNum = chooseAccount(u);
		final Account acc = u.getAccounts().get(accNum - 1);
		double amount = 0.0;
		System.out.print("Choose Amount to Deposit: ");
		try {
			amount = Double.parseDouble(scan.nextLine());
			if(amount < 0) {
				throw new NumberFormatException();
			}
		}catch(NumberFormatException e) {
			amount = 0.0;
		}
		Service.deposit(acc, amount);
		System.out.println("$" + amount + " Deposited");
	}
	
	private static void withdraw(User u) {
		final int accNum = chooseAccount(u);
		final Account acc = u.getAccounts().get(accNum - 1);
		double amount = 0.0;
		System.out.print("Choose Amount to Withdraw: ");
		try {
			amount = Double.parseDouble(scan.nextLine());
			if(amount < 0) {
				throw new NumberFormatException();
			}
		}catch(NumberFormatException e) {
			amount = 0.0;
		}
		try {
			Service.withdraw(acc, amount);
		} catch (InsufficientFundsException e) {
			amount = 0.0;
			System.out.println("Insufficient Funds");
		}
		System.out.println("$" + amount + " Withdrawn");
	}

}
