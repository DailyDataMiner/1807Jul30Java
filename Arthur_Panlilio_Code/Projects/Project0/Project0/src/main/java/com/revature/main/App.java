package com.revature.main;



import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import java.util.List;
import java.util.Scanner;

import com.revature.art.AsciiArt;
import com.revature.pojo.Account;
import com.revature.pojo.User;
import com.revature.service.AccountService;
import com.revature.service.UserService;
import com.revature.util.LessThanZeroException;
import com.revature.util.WithdrawException;


/**
 * This is main application for the bank project
 * It houses the console interface and its different branching paths
 * 
 * @author Arthur Panlilio
 *
 */
public class App {
	//Same scanner is used throughout this class
	static Scanner scan = new Scanner(System.in);
	//These service objects are used for logic and talking to the Dao
	static UserService uService = new UserService();
	static AccountService aService = new AccountService();
	
	static NumberFormat defaultFormat = NumberFormat.getCurrencyInstance();
	
	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMM-dd-yyyy");  
	static LocalDate currentDate = LocalDate.now();
	public static void main(String[] args) {
		//prints ascii art
		AsciiArt.draw();
		initBank();

	}
	
	/**
	 * This presents the user with 3 options
	 * This asks if they want to login, sign up, or exit the application.
	 */
	public static void initBank() {
		
		int response = 0;

		System.out.println("--------------------------------Main Menu----------------\n"
				+ "1. Login\n"
				+ "2. Sign Up\n"
				+ "3. Exit Application");
		
		response = getInput(3);
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
			case 3:
				System.exit(0);
				break;
		}
		
	}
	
	/**
	 * Asks the user questions and creates a user account based on the user's response.
	 */
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
		int reg = uService.registrationCheck(new User(fn, ln, un, pw));
		if(reg == 0) {
			System.out.println("Registration Failed!");	
		} else if (reg == 1) {
			System.out.println("Username Already Taken!");			
		} else if (reg == 2) {
			System.out.println("Registration Succsesful!");
		}
		initBank();
	}
	
	/**
	 * Register an account
	 * User can designate what account type they want
	 * 
	 */
	public static void registerAcc() {
		System.out.println("--------Creating new Account-------------\n\n\n");
		System.out.println("What account type shall be created?");
		int i = 1;
		for(i = 1; i < 4; i++) {
			System.out.println(i + ". " + aService.getAccType(i));
		}
		System.out.println(i + ". Return to User Menu");
		int response = getInput(4);
		if(response == 0) {
			registerAcc();
		}
		if(response == 4) {
			initUserOptions();
		}
		System.out.println("What would you like to name this account?");
		String name = scan.nextLine();
		Account account = new Account();
		account.setName(name);
		account.setUserId(uService.getCurrentUser().getId());
		account.setBalance(0.0);
		account.setAccountTypeId(response);
		java.util.Date utilDate = new java.util.Date();
		account.setLastUpdate(new java.sql.Date(utilDate.getTime()));
		Account temp= aService.save(account);
		if(temp == null) {
			System.out.println("Account already exists!");
		}
		else if(temp.getAccountId() > 0) {
			System.out.println("Account Creation Succsesful!");
		} else {
			System.out.println("Account Creation Failed!");
		}
		initUserOptions();
		
	}
	
	/**
	 * User inputs a username and password
	 * and checks the database to see if they match
	 */
	public static void login() {
		System.out.println("What is your username?");
		String un = scan.nextLine();
		System.out.println("What is you password?");
		String pw = scan.nextLine();
		switch(uService.loginCheck(un, pw)) {
			case 0:
				System.out.println("Username not found");
				initBank();
			break;
			case 1:
				System.out.println("Password incorrect");
				initBank();
			break;
			case 2:
				System.out.println("Logged in!");
				User u = uService.getOne(un);
				uService.setCurrentUser(u);
				clearGUI();
				initUserOptions();
			break;
		}
	}
	
	
	/**
	 * Prints out 10 lines to give the gui some space
	 */
	public static void clearGUI() {
		for(int i = 0; i < 10; i++) {
			System.out.println();
		}
	}
	
	
	/**
	 * The initial options for a user
	 */
	public static void initUserOptions() {
		System.out.println("=================User Menu========================\n"
				+ "What would you like to do today, " + uService.getCurrentUser().getFirstName() + "?\n"
						+ "Current date: " + dtf.format(currentDate) + "\n\n\n");
		
		System.out.println("1. Create New Account \n"
				+ "2. View Accounts \n"
				+ "3. Change Time \n"
				+ "4. Logout");
		
		int response = getInput(4);
		switch(response) {
			case 0:
				initUserOptions();
			break;
			case 1:
				clearGUI();
				registerAcc();
				break;
			case 2:
				initMyAccounts();
				break;
			case 3:
				changeTime();
				break;
			case 4:
				initBank();
				break;
		}			
	}
	
	/**
	 * Generates a list of the user's accounts
	 * User can select which account they want to access
	 */
	public static void initMyAccounts() {
		List<Account> acc = aService.getAllMine(uService.getCurrentUser().getId(), currentDate, 4);
		double total = 0;
		for(Account a: acc) {
			if(!aService.getAccType(a.getAccountTypeId()).equals("Communal"))			
				total += a.getBalance();
		}
		System.out.printf("\n=================My Accounts========================\n"
				+ "Total Balance: $%.2f (Excluding Communal Accounts)\n"
				+ "Select an Account:\n", total);
		int i = 0;
		for(i = 0; i < acc.size(); i++) {
			System.out.println(i+1+". My " + aService.getAccType(acc.get(i).getAccountTypeId()) + " Account"
					+ ": " + acc.get(i).getName());
		}
		System.out.println(i+1+". Return to User Menu");
		int response = getInput(acc.size() + 1);
		if(response == 0) {
			initMyAccounts();
		} else if(response == acc.size() + 1){
			initUserOptions();
		}else {
			initMyAccountOptions(acc.get(response - 1));
		}

	}
	
	/**
	 * Creates a list of options for the accounts
	 * 
	 * @param a is an account that is
	 */
	public static void initMyAccountOptions(Account a) {
		System.out.println("\"=================My " + aService.getAccType(a.getAccountTypeId()) +  " Account: " + a.getName() +"=="
				+ "======================\n");	
		if(!aService.getAccType(a.getAccountTypeId()).equals("Communal")) {
			System.out.printf("Current Balance: $%.2f\n", aService.getBalance(a));
		} else {
			double totalBalance = 0;
			List<Account> accs = aService.getAllofType(a.getAccountTypeId());
			for(Account ca: accs) {
				totalBalance += ca.getBalance();
			}
			System.out.printf("Current Balance: $%.2f\n", totalBalance);
		}
		System.out.println("1. Deposit \n"
				+ "2. Withdraw \n"
				+ "3. Information \n"
				+ "4. Delete \n"
				+ "5. Return");
		int response = getInput(5);
		switch(response) {
		case 0:
			initMyAccountOptions(a);
			break;
		case 1:
			deposit(a);
			break;
		case 2:
			withdraw(a);
			break;
		case 3:
			showInformation(a.getAccountTypeId(), a);
			break;
		case 4:
			delete(a);
			break;
		case 5:
			initMyAccounts();
			break;
		}
	}
	
	/**
	 * Deposits amount into an account
	 * @param a is the account to be deposited into
	 */
	public static void deposit(Account a) {
		a = aService.update(a);
		System.out.println("How much?");
		double dep = 0;
		try {
			dep = Double.parseDouble(scan.nextLine());
		} catch(NumberFormatException e){
			System.out.println("Sorry! You must enter a number!");
			deposit(a);
		}
		int response = aService.deposit(dep, a);
		switch (response) {
		case 0:
			System.out.println("Deposit failed.");
			break;
		case 1:
			System.out.printf("Successfully deposited $%.2f\n",dep);
			break;
		case 2:
			System.out.printf("It's your lucky day! You deposited $%.2f as well as an extra $%.2f!\n", dep, (dep/2));
			break;
		case 3:
			System.out.printf("Sorry..you lost. You deposited $%.2f and lost $%.2f\n", dep/2, dep/2);
			break;
		}
		initMyAccountOptions(a);
		
	}
	
	/**
	 * Withdraws amount from an account
	 * @param a is the account to be withdrawn from
	 */
	public static void withdraw(Account a) {
		a = aService.update(a);
		System.out.println("How much?");
		double wit = 0;
		try {
			wit = Double.parseDouble(scan.nextLine());
		} catch(NumberFormatException e) {
			System.out.println("Sorry! You must enter a number!");
			withdraw(a);
		}
		try {
			aService.withdraw(wit, a);
			if(!aService.getAccType(a.getAccountTypeId()).equals("Savings")) {
				System.out.printf("\nSuccesfully withdrawn $%.2f.\n", wit);
			} else {
				System.out.printf("You have withdrawn $%.2f. (25%% withdrawal fee was applied)\n", (wit - (wit * .25)));
			}
			initMyAccountOptions(a);
		} catch(WithdrawException e) {
			System.out.printf("\nSorry! You need at least $%.2f more to withdraw that amount.\n", e.getAmount());
			withdraw(a);
		} catch (LessThanZeroException e) {
			System.out.println("\nSorry! Number must be more than zero.");
			withdraw(a);
		}
	}
	
	
	public static void showInformation(int accType, Account a) {
		switch (aService.getAccType(accType)) {
		case "Checking":
			System.out.println("This a normal checking account. You put money in, you can get money out.");
			break;
		case "Savings":
			System.out.println("Money saved here increases by 4% everyday. Includes a 25% withdrawal fee.");
			break;
		case "Communal":
			System.out.println("All communal accounts share a balance.");
			break;
		case "Gambling":
			System.out.println("When you deposit money, there is a 50% chance you'll gain money, 50% chance you'll lose money.");
			break;
		}
		System.out.println("1. Return");
		int response = getInput(1);
		if(response == 1) {
			initMyAccountOptions(a);
		} else {
			showInformation(accType, a);
		}
	}
	
	/**
	 * Deletes an account
	 * 
	 * @param a is the account to be deleted
	 */
	public static void delete(Account a) {
		System.out.print("\nAre you sure you want to delete " + a.getName() + " Account?"); 
		if(!aService.getAccType(a.getAccountTypeId()).equals("Communal")) {
			System.out.printf(" It has $%.2f", aService.getBalance(a));
		}
		System.out.println("\n1. Yes \n"+ "2. No \n");	
		int response = getInput(2);
		if(response == 1) {
			if(aService.delete(a)) {
				System.out.println("Account Deleted.");
			} else {
				System.out.println("Something went wrong.");
			}
			initMyAccounts();
		} else {
			initMyAccountOptions(a);
		}
	}
	
	/**
	 * Asks the user to change the date
	 */
	public static void changeTime() {
		System.out.println("What is today's date? Format: 'MMM-dd-YYYY' ex: Jun-21-2020" );
		String d = scan.nextLine();
		LocalDate newDate = null;
		try {
			newDate = LocalDate.parse(d, dtf);
			currentDate = newDate;
		} catch (DateTimeParseException e) {
			System.out.println("Error.Input the correct date format.");
		} catch (Exception e) {
			System.out.println("Something went wrong.");
		}
		initUserOptions();
	}
	
	
	/**
	 * Gets an input and checks if its an int and within
	 * the desired range
	 * 
	 * @param potential is the amount of options there can be
	 * @return an int. 0 = error.
	 */
	public static int getInput(int potential) {
		int response = 0;
		try {
			response = Integer.parseInt(scan.nextLine());
		} catch(NumberFormatException e){
			System.out.println("Sorry! You must enter a number bewteen 1 and " + potential);
			return response;
		}
		if(response <= 0 || response > potential) {
			System.out.println("Sorry! You must enter a number bewteen 1 and " + potential);
			response = 0;
		}
		return response;
	}
	


}
