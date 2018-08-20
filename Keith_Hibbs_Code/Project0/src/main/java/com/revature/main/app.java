package com.revature.main;

import java.sql.SQLException;
import java.util.Scanner;

import com.revature.dao.AccountDao;
import com.revature.dao.UsersDao;
import com.revature.pojos.Account;
import com.revature.pojos.AccountType;
import com.revature.pojos.Users;
import com.revature.service.AccountService;
import com.revature.service.Service;
import com.revature.service.UserService;

	
public class app{
	
	static Service user = new Service();
	static Scanner scan = new Scanner(System.in);
	static Account a = new Account();
	static AccountDao ad = new AccountDao();
	static UsersDao ud = new UsersDao();
	static Users u = new Users();
	static AccountType at = new AccountType();
	static String username;
	static String password;
	
	public static void main(String[] args) {
		System.out.println("Welcome to Lousy Bank");
		menu1();
	}
	public static void menu1() {

		
			System.out.println("\n"
					+ "1: Login\n"
					+ "2: Creaate User Account\n"
					+ "3: Delete Account\n"
					+ "4: Exit\n");
//			menu1();
			
			String input = scan.nextLine();
			int inpt = Integer.parseInt(input);
		switch (inpt) {
		case 1:
			login();
			break;
		case 2:
			createAccount();
			menu1();
			break;
		case 3:
		delete();
		menu1();
		case 4:
//			exitApplication();
		break;
			
		}
		scan.close();
	}
	public static void login() {
		System.out.println("Enter username: ");
		username = scan.nextLine();
		System.out.println("Enter password: ");
		password = scan.nextLine();
		try {
		u =	UserService.onLogin(username, password);
		} catch (SQLException e) {
			System.out.println("Invalid, Please try again");
			app.login();
		}
		userMenu();
	}
	public static void createAccount() {
		System.out.println("Enter First name: ");
		String name = scan.nextLine();
		System.out.println("Enter Last name: ");
		String lname = scan.nextLine();
		System.out.println("Enter Username: ");
		String uname = scan.nextLine();
		System.out.println("Enter Password: ");
		String password = scan.nextLine();
		u.setfName(name);
		u.setLname(lname);
		u.setUsername(uname.toLowerCase());
		u.setPassword(password);
		ud.addOne(u);
		openAccnt(u);
	}
	public static void exitApplication() {
		System.out.println("Are you sure you want to exit? 1 for yes\n"
				+ " 2 for no. ");
		String exitinput = scan.nextLine();
		int extinpt = Integer.parseInt(exitinput);
		if (extinpt == 1) {
			System.exit(extinpt);
		} else {
		}
		scan.close();
	}
	
	public static void userMenu() {
		System.out.println("1: Logout \n"
				+ "2: Withdraw \n"
				+ "3: Deposit \n"
				+ "4: Open new Account\n");
		String input = scan.nextLine();
		if (input == null) {
			System.out.println("Please enter a number between 1 and 4.");
			userMenu();
		} else if (input.equals("1") || input.equals("2") || input.equals("3") || input.equals("4") || input.equals("5")) {
			
			int inpt = Integer.parseInt(input);
			if(inpt==1) {
				logout();
			} else if (inpt == 2) {
				wdOption();
			} else if(inpt== 3) {
				deOption();
			} else if (inpt == 4) {
				openAccnt(u);
			} else if(inpt== 5) {
				System.exit(inpt);
			}
			
		} else {
			System.out.println("Please enter a number between 1 and 4.");	
		} 
		UserService.onLoginAfter(u.getUsername());
	}
	
	public static void logout()  {
System.out.println("Goodbye");
//System.exit();
menu1();
	}

	public static void redoUsername() {
		System.out.println("That user name was invalid. Please enter another one, or select 1 to restart application");
		String uname = scan.nextLine();
		if(uname.equals("1")) {
		} else {
		u.setUsername(uname.toLowerCase());
		ud.addOne(u);
		}
	}
	
	public static void delete() {
		System.out.println("Please enter your username.");
		username = scan.nextLine();
		System.out.println("Now enter your password.");
		password = scan.nextLine();
		try {
		UserService.onDelete(username, password);
		} catch (SQLException e) {
			System.out.println("Those credentials were invalid, please try again");
			app.delete();
		}
		System.out.println("Your account was deleted, please come to the bank to collect your funds.");
	}
	public static void openAccnt(Users u) {
		System.out.println(u.getfName());
		System.out.println("Please select which account you want to open");
		AccountService.onOpenAccount();
		System.out.println("1 for checking, 2 for savings.");
		String atypes = scan.nextLine();
		int accountid = Integer.parseInt(atypes);
		System.out.println("Please deposit an initial ammount or select 0.");
		String depos = scan.nextLine();
		int deposit = Integer.parseInt(depos);
		a = ad.addOne(u.getId(), deposit);
		ad.addJnct(a.getAccountid(), accountid);
		
	}
		
	public static void wdOption() {
		System.out.println("Please select the account # you want to Withdraw from.");
		String aidstr = scan.nextLine();
		int accountid = Integer.parseInt(aidstr);
		System.out.println("How much would you like to withdraw?");
		String amtstr = scan.nextLine();
		int amt = Integer.parseInt(amtstr);
		
		try {
			Service.onWithdraw(accountid, amt);
			} catch (SQLException e) {
				System.out.println("You must have entered an invalid amount or an incorrect character");
				app.wdOption();			
			}
		
	}
	
	public static void deOption() {

		System.out.println("Please select the account # you want to deposit to.");
		String aidstr = scan.nextLine();
		int aid = Integer.parseInt(aidstr);
		System.out.println("How much would you like to deposit?");
		String amtstr = scan.nextLine();
		int amt = Integer.parseInt(amtstr);
		
		try {
			Service.onDeposit(aid, amt);
			} catch (SQLException e) {
				System.out.println("You must have entered an invalid amount or an incorrect character");
				app.deOption();			
			}
		
	}
	
	public void wrongName() {
		System.out.println("That username was incorrect. Please enter a valid username.");
		String uname = scan.nextLine();
		UserService.onLoginAfter(uname);
	}
	
	}
