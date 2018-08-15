package com.rev.main;

import java.util.Scanner;

import com.rev.dao.AccountDao;
import com.rev.dao.CustomerDao;
import com.rev.service.AccountService;
import com.rev.service.CustomerService;

public class Driver {

	static Scanner mainscan = new Scanner(System.in);
	static Scanner logNameScan = new Scanner(System.in);
	static Scanner logPassScan = new Scanner(System.in);
	static Scanner scanner = new Scanner(System.in);
	static Scanner accountmenuscan = new Scanner(System.in);
	static Scanner depositaccountscan = new Scanner(System.in);
	static Scanner depositfundsscan = new Scanner(System.in);

	static String password;
	static String username;
	public static int CustID;

	public static void main(String[] args) {
		System.out.println("Welcome to Chase Citi Bank of America!");

		loginMenu();

	}

	public static void loginMenu() {

//AccountDao AD = new AccountDao();
//Account test = new Account();
//		test.setBalance(500);
//		test.setAccountTypeID(1);
//		AD.save(test);
		System.out.println("");
		System.out.println(
				"---------Login Menu--------\n" + "1. Login in\n" + "2. Create an Account\n" + "Select a Number: ");
		int option = 0;
		try {
			option = Integer.parseInt(scanner.nextLine());
		} catch (NumberFormatException e) {
			System.out.println("Sorry, you must enter enter the number 1 or 2");

			loginMenu();
		}

		switch (option) {
		case 1:
			login();
			break;
		case 2:
			CustomerService.makeNewCustomer();
			loginMenu();
			break;
		default:
			System.out.println("Sorry, you must enter the number 1 or 2");
			loginMenu();
		}
	}

	public static void login() {
		System.out.println("");
		System.out.println("------Login Credentials----");
		System.out.println("Enter Username: ");
		username = logNameScan.nextLine();
		System.out.println("Enter Password: ");
		password = logPassScan.nextLine();

		if (CustomerDao.loginConfirm(username, password) == true) {
			System.out.println("Login Successful!");
			CustID = CustomerDao.getCustID(username, password);
			Menu();
		} else {
			System.out.println("Incorrect Username/Password");
			loginMenu();
		}

	}

	public static void Menu() {
		System.out.println("");
		System.out.println("{---------Main Menu--------}\n" + "---------------------------\n"
				+ "1. View Accounts\n" + "2. Add Account\n"
				+ "3. Deposit Funds\n" + "4. Withdraw Funds\n" + "5. Logout\n" + "Select a Number: ");

		int option = 0;
		try {
			option = Integer.parseInt(mainscan.nextLine());
		} catch (NumberFormatException e) {
			System.out.println("Sorry, you must enter a number between 1 and 5: ");
			Menu();
		}

		switch (option) {
		case 1:
			viewAccountMenu();
			break;
		case 2:
			addAccountMenu();
			break;
		case 3:
			depositFundsAccountMenu();
			Menu();
			break;
		case 4:
			withdrawFundsAccountMenu();
			Menu();
			break;
		case 5:
			loginMenu();
			break;
		default:
			System.out.println("Wrong Input");
			Menu();
		}
	}

	static void viewAccountMenu() {
		System.out.println("");
		System.out.println("------Your Accounts------");
		AccountDao.transactionFindAll(CustID);
		System.out.println("Enter 1 to back");
		int option = 0;
		try {
			option = Integer.parseInt(mainscan.nextLine());
		} catch (NumberFormatException e) {
			System.out.println("Enter 1 to back");
			Menu();
		}
		switch (option) {
		case 1:
			Menu();
			break;
		default:
			Menu();
			break;
		}

	}

	static void addAccountMenu() {
		System.out.println("");
		System.out.println("------Account Selection-------");
		System.out.println("Select Account Type");
		System.out.println("1.Checkings Account");
		System.out.println("2.Savings Account");
		System.out.println("3.Deposit Account");
		System.out.println("4.Back");
		int accountselection = 0;
		try {
			accountselection = Integer.parseInt(accountmenuscan.nextLine());
		}
		catch(NumberFormatException e)
		{
			System.out.println("Enter number between 1 and 4");
			addAccountMenu();
		}

			switch (accountselection) {
			case 1:
				AccountService.createAccount(1);
				Menu();
				break;
			case 2:
				AccountService.createAccount(2);
				Menu();
				break;
			case 3:
				AccountService.createAccount(3);
				Menu();
				break;
			case 4:
				Menu();
				break;
			default:
				System.out.println("Enter number between 1 and 4");
				addAccountMenu();
				break;
			}
		

	}

	public static void depositFundsAccountMenu() {
		double funds = 0;
		int option = 0;
		System.out.println("---------Deposit Funds----------");
		AccountDao.transactionFindAll(CustID);
		System.out.println("\n Select which account to add money to: ");

		try {
			option = Integer.parseInt(depositaccountscan.nextLine());
		} catch (NumberFormatException e) {
			System.out.println("Please enter a valid number");
			depositFundsAccountMenu();
		}
		System.out.println("Enter amount of money to deposit");

		try {
			funds = Integer.parseInt(depositaccountscan.nextLine());
		} catch (NumberFormatException e) {
			System.out.println("Please enter a valid number");
			depositFundsAccountMenu();
		}

		AccountDao.depositselectedaccount(CustID, option, funds);
	}

	public static void withdrawFundsAccountMenu() {
		double funds = 0;
		int option = 0;
		System.out.println("-------Withdraw funds-------");
		AccountDao.transactionFindAll(CustID);
		System.out.println("\n Select which account to withdraw money from : ");

		try {
			option = Integer.parseInt(depositaccountscan.nextLine());
		} catch (NumberFormatException e) {
			System.out.println("Please enter a valid number");
			depositFundsAccountMenu();
		}
		System.out.println("Enter amount of money to withdraw");

		try {
			funds = Integer.parseInt(depositaccountscan.nextLine());
		} catch (NumberFormatException e) {
			System.out.println("Please enter a valid number");
			depositFundsAccountMenu();
		}

		AccountDao.withdrawselectedaccount(CustID, option, funds);
	}

}
