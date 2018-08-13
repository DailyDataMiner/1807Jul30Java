package com.revature.main;
	import java.util.List;
	import java.util.Scanner;

import com.revature.pojos.Account_Type;
import com.revature.pojos.Accounts;
import com.revature.pojos.Users;
import com.revature.service.AccountTypeService;
import com.revature.service.AccountsService;
public class App {


		static Scanner scanner = new Scanner(System.in);
		static AccountsService aService = new AccountsService();
static AccountTypeService atService = new AccountTypeService();
		
		public static void main(String[] args) {

			System.out.println("WELCOME!");
			menu1();
		}

			
		
		static void menu1() {
			
			
			System.out.println("---------Menu 1--------\n"
					+ "1. Login\n"
					+ "2. Create Account\n"
					+ "3. Exit\n"
					);
			int option = 0;
			try { //DONT USE SCANNER.NEXT INT!!!!!!
				option = Integer.parseInt(scanner.nextLine());
			}
			catch(NumberFormatException e) {
				System.out.println("Sorry, you must enter a number between 1 and 3 :)");
				menu1();
			}
			
			switch(option) {
			case 1:viewAccounts();
			//select 
			break;
			case 2:addUser();
				break;
			case 3: System.exit(option); 
				break;
				//
			}
		}
		static void menu2() {
			System.out.println("---------Menu 2--------\n"
					+ "1. Check Balance\n"
					+ "2. Withdrawl\n"
					+ "3. Deposit\n"
					+ "4. Exit\n"
					);
			int option = 0;
			try { //DONT USE SCANNER.NEXT INT!!!!!!
				option = Integer.parseInt(scanner.nextLine());
			}
			catch(NumberFormatException e) {
				System.out.println("Sorry, you must enter a number between 1 and 6 :)");
				menu2();
			}
			
			switch(option) {
			case 1:
			case 2:
				break;
			case 3: 
				break;
				//
			}
		}
		
		
		static void addUser() {
			System.out.println("Enter your First Name:");
			String fname = scanner.nextLine();
			System.out.println("Enter your Lastt Name:");
			String lname = scanner.nextLine();
			System.out.println("Enter a Username: ");
			String username = scanner.nextLine();
			System.out.println("Enter a super secure password: ");
			String password = scanner.nextLine();
			System.out.println("Enter your date of birth (DD-Mon-YY): ");
			String dob = scanner.nextLine();
			
			Users u = new Users(fname, lname, username, password, dob);
			
		}
		
		static void addAccount() {
			System.out.println("Enter Routing #: ");
			int routing_numb = Integer.parseInt(scanner.nextLine());
			System.out.println("Enter how much you will put into your account: ");
			double bal = Double.parseDouble(scanner.nextLine());
//			System.out.println("Enter 1 for Checking or 2 for Savings: ");
//			int account_type_id = Integer.parseInt(scanner.nextLine());
			List<Account_Type> account_type_id = atService.getAll();
			for (int i = 0; i < Account_Type.size();i++) {
				System.out.println(i+1 + ": " + Account_Type.get(i));
			}
			int AccountTypeIndex = Integer.parseInt(scanner.nextLine())-1;
			int AccountTypeID = ((Account_Type) AccountTypeService.get(AccountTypeIndex)).getAccountTypeId();
			Accounts a = new Accounts(routing_numb, bal, AccountTypeID);
		}
		static void viewAccounts() {
			System.out.println("Current Account:");
			List<Accounts> accounts = aService.getAll();
			for(Accounts a : accounts) {
				System.out.println(a.getBal());
			}
		}

	}
	

