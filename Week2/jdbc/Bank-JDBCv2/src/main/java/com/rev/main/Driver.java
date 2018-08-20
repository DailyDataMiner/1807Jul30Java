package com.rev.main;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.rev.pojo.Account;
import com.rev.pojo.Client;
import com.rev.service.AccountService;
import com.rev.service.ClientService;
import com.rev.util.InsufficientFundsException;

public class Driver {

	static Scanner scanner = new Scanner(System.in);
	
	
	static ClientService cService = new ClientService();
	static AccountService aService = new AccountService();
	
	static int usid;
	static String username;
	static String password;
	
	public static void menu() {
	
		System.out.println("\n");
		System.out.println("-------Welcome to Revature Bank------\n"
						+ " 1. Login As Existing User\n"
						+ " 2. Create New User\n"
						+ " 3. Exit\n"
						+  "-------------------------------------\n");

		int option = 0;
		try {
			option = Integer.parseInt(scanner.nextLine());
		}
		catch(NumberFormatException e) {
			System.out.println("Please choose option 1-3 on the menu");
			menu();
		}
		
		switch(option) {
		
		case 1:
			menuLogged();
			break;
		case 2:
			menuNew();
			break;
		case 3:
			System.out.println("Exited Application");
			System.exit(0);
			break;
		default:
			System.out.println("Please choose option 1-3 on the menu");
			menu();
			break;
		}
	}
	

	
	// this is the login menu
	static void menuLogged() {
		//it is case sensitive
		System.out.println("\nUsername");
		String input = scanner.nextLine();
		System.out.println("Password");
		String input2 = scanner.nextLine();
		try {
			if (cService.verifyClient(input, input2) == true) {
				username = input;
				password = input2;
				usid = cService.pullAccount(input,input2).getUserid();
				System.out.println("Login Successful\n");
				menu2();
			}
				else {
					System.out.print("\nThis Username and Password Combination is Invalid!\n");
					menu();
					}
			}
			catch (NullPointerException e) {
				System.out.print("\nThis Username and Password Combination is Invalid!\n");
				menu();
		}
		
	}


	static void menuNew() {
		System.out.println("\n-------------------------------------\n"
						+  "Create New User (Press 0 anytime to exit)\n"
						+  "-------------------------------------\n");
		
		String fn = null;
		String ln = null;
		String u = null;
		String p = null;
		
		
		boolean flag1 = false;
		while(!flag1) {
			System.out.println("First Name");
			fn = scanner.nextLine();
			if (fn.equals("0")) {menu();}
			flag1 = fn.matches("[a-zA-Z].*$");
			if (flag1 == true) {break;}
			System.out.println("\nPlease input a real first name\n");
		}

		boolean flag2 = false;
		while(!flag2) {
			System.out.println("Last Name");
			ln = scanner.nextLine();
			if (ln.equals("0")) {menu();}
			flag2 = ln.matches("[a-zA-Z].*$");
			if (flag2 == true) {break;}
			System.out.println("\nPlease input a real last name\n");
		}

		boolean flag3 = false;
		while(!flag3) {
			System.out.println("Username (should be unique and at least 3 characters)");
			u = scanner.nextLine();
			if (u.equals("0")) {menu();}
			if (u.length() < 3) {flag3 = false;}
			else if (cService.isOnly(u) != true) {flag3 = false;}
			if (flag3 = true) {break;}
			System.out.print("\nYour username must be at least 3 characters and unique\n");
		}

		boolean flag4 = false;
		while(!flag4) {
			System.out.println("Password (must be at least 8 characters)");
			p = scanner.nextLine();
			if (p.equals("0")) {menu();}
			if (p.length() < 8) { flag4 = false;} else {flag4 = true;}
			if (flag4 == true) {break;}
			System.out.println("\nPassword must be at least 8 characters\n");
		}

		Client user = new Client(fn, ln, u, p);
		user = cService.add(user);
		username = u;
		password = p;
		usid = cService.pullAccount(u,p).getUserid();
		System.out.println("User Created!");
		System.out.println("Login Successful\n");
		menu2();
	
	}

	static void menu2() {
		
		Scanner pip = new Scanner(System.in);
		
		System.out.println("----------------Main Menu------------\n"
						+ " 1. View Balance\n"
						+ " 2. Deposit\n"
						+ " 3. Withdraw\n"
						+ " 4. Create New Account\n"
						+ " 5. Logout\n"
						+ " 9. Nuke User\n"
						+ "--------------------------------------\n");

		
		int option = 0;
		try {
			option = Integer.parseInt(pip.nextLine());
		} 
		catch(NumberFormatException e) {
			System.out.println("Please choose option 1-5 or 9 on the menu");
			menu2();
		}
			switch(option) {
			case 1:
				if (aService.checkAccount(usid).isEmpty()) {
					System.out.println("You don't have any accounts. Please first create a new account");
					menu2();
				} else {
					displayAcc();
				}
			
				break;
			case 2:
				if (aService.checkAccount(usid).isEmpty()) {
					System.out.println("You don't have any accounts. Please first create a new account");
					menu2();
				}
				deposit();
				break;
			case 3:
				if (aService.checkAccount(usid).isEmpty()) {
					System.out.println("You don't have any accounts. Please first create a new account");
					menu2();}
				try {
					withdraw();
				} catch (InsufficientFundsException e) {
					System.out.println("Insufficient Funds!");
					menu2();
					break;
				}
				menu2();
				break;
			case 4:
				createAcc();
				
				break;
			case 5:
				menu();
				break;
			case 9:
				System.out.println("Are you sure you want to delete this User and related accounts? Type yes or no");
				String wow = scanner.nextLine().toUpperCase();
				System.out.println(wow);
				if (wow.equals("YES")) {cService.nuke(usid); menu();}
				
				
				break;
			default:
				System.out.println("Please choose option 1-5 or 9 from the main menu");
				menu2();
				break;
			}



		}
			
			
			static void createAcc() {
				System.out.print("-------------New Account-------------\n"
						+ "1. Checking Account\n"
						+ "2. Savings Account\n"
						+ "3. Exit\n"
						+"-------------------------------------\n");
				String accType = null;
				int option = 0;
				try {
					option = Integer.parseInt(scanner.nextLine());
				}
				catch(NumberFormatException e) {
					System.out.println("Please choose option 1-3");
					createAcc();
				}
				switch(option) {
				case 1:
					accType = "Checking";
					break;
				case 2:
					accType = "Saving";
					break;
				case 3:
					menu2();
					break;
				default:
					System.out.println("Please choose option 1-3");
					createAcc();
					break;
				}

				System.out.println("Name your Account");
				String accName = scanner.nextLine();
				for (Account s : aService.checkAccount(usid)) { 
					if (s.getAccname().equals(accName)){
						System.out.println("You already have an account with this name. Going back to Main Menu...\n");
						createAcc();
					}
				}
					aService.createAccount(usid, accName, accType);
					menu2();
			}
			
			
			static void displayAcc() {
				
				int count = 0;
			    for (Account s : aService.checkAccount(usid)) { 
			    	count++;
			    	System.out.println(count + ". " + s.toString()); 
			    }
			    System.out.println("\n");
				menu2();
	
				
				
	}

	static void deposit() {
		int count = 0;
		for (Account s : aService.checkAccount(usid)) {
			count++;
			System.out.println(count + ". " + s.toString());
		}
		System.out.print("\n");

		System.out.println(
				"Please enter the name of the Account you wish to deposit (Press 0 anytime to return to the Main Menu");
		String acname = scanner.next();
		goback(acname);
		
		double amount = 0;
		1
		for (Account k : aService.checkAccount(usid)) {
			if (k.getAccname().equals(acname)) {
				
				
				System.out.println("Please enter the amount you wish to deposit");
				try {
					amount = scanner.nextDouble();
				} catch (InputMismatchException ime) {
					System.out.println("Has to be a positive number");
				}
				if (amount < 0) {
					System.out.println("You got to be 'Positive'\n");
					deposit();
				} else {
					aService.change(usid, acname, k.getAcctype(), amount + k.getBalance());
					System.out.print(amount + " has been deposited in your account\n");
					menu2();
				}


				

			} //else {
				//System.out.println("There is no account with this name1\n");
				//menu2();
			//}
		
		}
	}







			static void withdraw() throws InsufficientFundsException  {
				int count = 0;
				for (Account s : aService.checkAccount(usid)) { 
					count++;
					System.out.println(count + ". " + s.toString()); 
				}
				System.out.print("\n");

				System.out.println("Please enter the name of the Account you wish to withdraw (Press 0 anytime to return to the Main Menu");
				String acname = scanner.next();	goback(acname);
				for (Account h : aService.checkAccount(usid)) { 

					if (h.getAccname().equals(acname)){

						System.out.println("Please Enter the amount you wish to withdraw");
						double amount = scanner.nextDouble();	goback(amount);
						if (h.getBalance()-amount < 0) throw new InsufficientFundsException();
						else {
							aService.change(usid, acname,h.getAcctype() ,h.getBalance() - amount);
							System.out.print(amount + " has been withdrawn form your account\n");
							menu2();
						}
						System.out.println("There is no account with this namew\n");
						menu2();
					}
					//System.out.println("There is no account with this name2\n");
					//menu2();
				}
			}




			//takes you back to main menu
			static void goback(double amount) {
				if (amount == 0.0) {
					menu2();

				}
			}
			static void goback(String git ) {
				if (git.equals("0")) {
					menu2();
				}
			}
			static void goback(int amount) {
				if (amount == 0.0) {
					menu2();

				}
			}
			
}



