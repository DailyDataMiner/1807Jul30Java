package com.revature.main;


import java.util.List;
import java.util.Scanner;

import com.revature.art.AsciiArt;
import com.revature.pojo.Account;
import com.revature.pojo.User;
import com.revature.service.AccountService;
import com.revature.service.UserService;



public class App {
	
	static Scanner scan = new Scanner(System.in);
	static UserService uService = new UserService();
	static AccountService aService = new AccountService();

	public static void main(String[] args) {
		//List<User> u = uService.getAll();
		AsciiArt.draw();
		initBank();

	}
	
	public static void initBank() {
		
		int response = 0;

		System.out.println("--------------------------------Main Menu----------------\n"
				+ "1. Login\n"
				+ "2. Sign Up\n");
		
		response = getInput(2);
		switch(response) {
			case 0:
				initBank();
			break;
			case 1:
				login();
				break;
			case 2:
				register();
				break;
		}
		
	}
	
	public static void register() {
		clearGUI();
		System.out.println("What is your first name?");
		String fn = scan.nextLine();
		System.out.println("What is your last name?");
		String ln = scan.nextLine();
		System.out.println("What will be your username?");
		String un = scan.nextLine();
		System.out.println("What will your password be?");
		String pw = scan.nextLine();
		User user = uService.save(new User(fn, ln, un, pw));
		if(user.getId() > 0) {
			System.out.println("Registration Succsesful!");
		} else {
			System.out.println("Registration Failed!");			
		}
		initBank();
	}
	
	public static void registerAcc(User u) {
		System.out.println("--------Creating new Account-------------\n\n\n");
		System.out.println("What account type shall be created?");
		int response = getInput(5);
		if(response == 0) {
			registerAcc(u);
		}
		Account account = new Account();
		account.setUserId(u.getId());
		account.setBalance(0.0);
		account.setAccountTypeId(response);
		java.util.Date utilDate = new java.util.Date();
		account.setLastUpdate(new java.sql.Date(utilDate.getTime()));
		Account temp= aService.save(account);
		if(temp.getAccountId() > 0) {
			System.out.println("Account Creation Succsesful!");
		} else {
			System.out.println("Account Creation Failed!");
		}
		initUserOptions(u);
		
	}
	
	public static void login() {
		System.out.println("What is your username?");
		String un = scan.nextLine();
		System.out.println("What is you password?");
		String pw = scan.nextLine();
		switch(uService.loginCheck(un, pw)) {
			case 0:
				System.out.println("Username not found");
				login();
			break;
			case 1:
				System.out.println("Password incorrect");
				login();
			break;
			case 2:
				System.out.println("Logged in!");
				initUserOptions(uService.getOne(un));
			break;
		}
		
	}
	
	
	public static void guiHeader() {
		clearGUI();

		System.out.println("============================================================================================================");
		System.out.println("Logout(0)");
	
	}
	
	public static void clearGUI() {
		for(int i = 0; i < 10; i++) {
			System.out.println();
		}
	}
	
	
	public static void initUserOptions(User u) {
		clearGUI();
		System.out.println("=================User Menu========================\n"
				+ "What would you like to do today, " + u.getFirstName() + "?\n\n\n\n");
		
		System.out.println("1. Create New Account \n"
				+ "2. View Accounts");
		
		int response = getInput(2);
		switch(response) {
			case 0:
				initUserOptions(u);
			break;
			case 1:
				clearGUI();
				registerAcc(u);
				break;
			case 2:
				initMyAccounts(u);
				break;
		}			
	}
	
	public static void initMyAccounts(User u) {
		List<Account> acc = aService.getAllMine(u.getId());
		System.out.println("\"=================My Accounts========================\n"
				+ "Select an Account:");
		for(int i = 0; i < acc.size(); i++) {
			System.out.println(i+1+". My " + aService.getAccType(acc.get(i).getAccountTypeId()) + " Account");
		}
		int response = getInput(acc.size());
		if(response == 0) {
			initMyAccounts(u);
		} else {
			initMyAccountOptions(u,acc.get(response));
		}

	}
	
	public static void initMyAccountOptions(User u, Account a) {
		System.out.println("\"=================My " + aService.getAccType(a.getAccountTypeId()) +  " Account=="
				+ "======================\n");	
		System.out.println("Current Balance: $" + a.getBalance());
		System.out.println("1. Deposit \n"
				+ "2. Withdraw \n"
				+ "3. Information \n"
				+ "4. Return");
	}
	
	
	
	public static int getInput(int potential) {
		int response = 0;
		try {
			response = Integer.parseInt(scan.nextLine());
		} catch(NumberFormatException e){
			System.out.println("Sorry! You must enter a number bewteen 1 and " + potential);
		}
		if(response <= 0 || response > potential) {
			System.out.println("Sorry! You must enter a number bewteen 1 and " + potential);
			response = 0;
		}
		return response;
	}
	
	
	

}
