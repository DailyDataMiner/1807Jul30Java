package com.rev.main;

import java.util.List;
import java.util.Scanner;

import com.rev.dao.AccountDAO;
import com.rev.dao.AccountIDDAO;
import com.rev.pojos.Account;
import com.rev.pojos.AccountID;
import com.rev.pojos.BankUser;
import com.rev.service.BankUserService;



public class App {

	static double balance;
	static BankUser temp;
	public static int accType;
	static Scanner scanner = new Scanner(System.in);
	
	static BankUserService bService = new BankUserService();

	public static void main(String[] args) {
		/*
		 * Bank APP DRIVER
		 * should NOT interact directly with DAO layer!
		 * only the service layer
		 */
		System.out.println("WELCOME to Municipal Credit Union! Banking Application\n"
				+ "What would you Like to do?");
		menu1();
	}

	static void menu1() {
		System.out.println("---------Login or Sign Up--------\n"
				
				+ "1. Sign Up New User\n"
				+ "2. Login In to App!\n"
				);
		int option = 0;
		try { //DONT USE SCANNER.NEXT INT!!!!!!
			option = Integer.parseInt(scanner.nextLine());
		}
		catch(NumberFormatException e) {
			System.out.println("Sorry, you must enter a Valid Number :)");
			menu1();
		}
		
		switch(option) {
		case 1:
			SignUpUser();
			CreateAccount();
			break;
		case 2:
			LogIn();
			break;
		default:
			System.out.println("Sorry Please enter a Valid number");
			menu1();//change this to menu2
			break;
			
			//
		}
	}
	
	   static void LogInCreateAccount() {
		   
		   
		   LogIn();
		   if (temp != null) {
			   
			   CreateAccount();
			   
			   
		   }
		   
		   
		// TODO Auto-generated method stub
		
	}

	static void CreateAccount() {
		
		System.out.println("What type of Account do you want to create?\n"
				+ "1. Checkings \n" 
				+ "2. Savings \n");
		int option = 0;
		try { 
			option = Integer.parseInt(scanner.nextLine());
			if (option > 2) {
				System.out.println("Please input a valid number");
				menu2();
			}
			else if(option < 1) {
				System.out.println("Please input a valid number");
				menu2();
			}
				
		}
		catch(NumberFormatException e) {
			System.out.println("Sorry, you must 1 or 2 :)");

		}
		System.out.println("Enter Account Name: ");
		String acName = scanner.nextLine();
		AccountID acId = new AccountID(acName,option);
		AccountIDDAO accDao = new AccountIDDAO();
		accDao.save(acId);
		System.out.println();
		
		System.out.println("Enter your username:");//new 
		String userName = scanner.nextLine();
		System.out.println("Enter your password:");
		String password = scanner.nextLine();
		
		
		temp = bService.findOneId(new BankUser(userName, password));//to new 
		
		
		
		System.out.println(temp.getUserID());
		Account acc = new Account(temp.getUserID(), option);
		
		AccountDAO accountDao = new AccountDAO();
		accountDao.save(acc);
		
		System.out.println("Your account ID is displayed above, please remember it for all transactions ");
		System.out.println("Would you like to make a transaction? \n");
		menu2();
		


		
	}

	static void LogIn() {
		  
		System.out.println("Enter your username:");
		String userName = scanner.nextLine();
		System.out.println("Enter your password:");
		String password = scanner.nextLine();
		
		
		temp = bService.findOneId(new BankUser(userName, password));
		
		menu2();
		
		
		
		  
	}
	
	 

	private static void menu2() {
		System.out.println("---------Main Menu--------\n"
				+ "1. Create a New Account\n"
				+ "2. Withdraw from Account\n"
				+ "3. Deposit to Account\n"
				+ "4. Log Out \n"
				);
		int option = 0;
		try { //DONT USE SCANNER.NEXT INT!!!!!!
			option = Integer.parseInt(scanner.nextLine());
		}
		catch(NumberFormatException e) {
			
			menu2();
		}
		
		switch(option) {
		case 1:
			CreateAccount();
			break;
		case 2:
			WithdrawFromAccount();
			break;
		case 3:
			DepositToAccount();
			break;
		case 4:
			LogOut();
			break;
		default:
			System.out.println("Sorry Please enter a Valid number");
			menu2();//change this to menu2
			break;
			
			//
		}
	}

	private static void LogOut() {
		
		
		temp = null;
		System.out.println("Log Out Successful");
		menu1();
		
	}

	private static void WithdrawFromAccount() {
		System.out.println("Withdraw from Checkings or Savings: \n"
				+ "Checkings(Input 1)\n"
				+ "Savings (Input 2)\n");
		int accDeposite = scanner.nextInt();
		
		System.out.println("Enter your Account Number: ");
		int accID = scanner.nextInt();
		
		System.out.println("How much do you want to withdraw? ");
		double depositeAmt  = scanner.nextDouble();
		
		

		Account withdraw = new Account(temp.getUserID(),accDeposite,accID,depositeAmt);
		AccountDAO aDao = new AccountDAO();

		aDao.update(withdraw, depositeAmt,1);
		System.out.println("Would you like to make another Transaction?");
		menu2();
		
		
		

	}

	private static void DepositToAccount() {
		System.out.println("Deposit to Checkings or Savings: \n"
				+ "Checkings(Input 1)\n"
				+ "Savings (Input 2)\n");
		int accDeposite = scanner.nextInt();
		
		System.out.println("Enter your Account Number: ");
		int accID = scanner.nextInt();
		
		System.out.println("How much do you want to deposit? ");
		double depositeAmt  = scanner.nextDouble();
		
		

		Account withdraw = new Account(temp.getUserID(),accDeposite,accID,depositeAmt);
		AccountDAO aDao = new AccountDAO();

		aDao.update(withdraw, depositeAmt,2);
		System.out.println("Would you like to make another Transaction?");
		menu2();
		
	}

	static void BalanceInquiry() {
		 
		System.out.println("Which Account you like to Check? ");
		int checkThis = scanner.nextInt();
		
		
		Account withdraw = new Account(temp.getUserID(),checkThis);
		AccountDAO aDao = new AccountDAO();

		balance = aDao.findOne(withdraw);
		System.out.println("Balance: " + balance);		 
		
	}

	static void SignUpUser() {
		
			System.out.println("Enter your First Name:");
			String firstName = scanner.nextLine();
			System.out.println("Enter your Last Name:");
			String lastName = scanner.nextLine();
			System.out.println("Enter your email:");
			String email = scanner.nextLine(); 		
			System.out.println("Enter your username:");
			String userName = scanner.nextLine();
			System.out.println("Enter your password:");
			String password = scanner.nextLine();
				
			
			BankUser b = new BankUser(firstName, lastName, email, userName, password);
			bService.insert(b);
			//call book service addBook() which calls dao addBook()
			//WE HAVE MAINTAINED REFERENTIAL INTEGRITY
			
		
	}
	static void viewBankUsers() {
		System.out.println("Current Users:");
		List<BankUser> BankUser = BankUserService.getAll();
		for(BankUser u : BankUser) {
			System.out.println(u.getFirstName());
		}
	}

}