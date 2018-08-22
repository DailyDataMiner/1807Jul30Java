package Application;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.PrimitiveIterator.OfDouble;

import javax.swing.text.Style;

import org.omg.CORBA.PUBLIC_MEMBER;

import model.BankAccount;
import model.BankUser;
import oracle.net.aso.i;
import service.AccountService;
import service.UserService;

public class main {
	
	static Scanner scanner = new Scanner(System.in);
	static String first_name;
	static String last_name;
	static String user_name;
	static String pass_word;
	static int user_id;
	static boolean isNew = false;
	static int totalOfAllAccountsBalance = 0;
	public static void main(String[] args) {
		
//		System.out.println(UserService.getTotalUserNumberService());
				
		/*********************************** USER *******************************************/
		
		/* ---------------------------->1 GET User <------------------------------------
		 * GET user#1 data from DB
		 * */
//		System.out.println(UserService.returnBankUser(1));
//		
//		System.out.println("get user with name and password: " + UserService.getUserWithUsernamePassword("byronzy", "123"));

//		/* ---------------------------->2 CREATE  User<------------------------------------
//		 * CREATE NEW user#3 and insert newUser data in DB
//		 * */
//		UserService.getUserService().createNewBankUser(2, "Thor5", "Nova", "thornova2", "123");
//		/*
//		 * get1 user3 data
//		 * */
//		System.out.println(UserService.getUserService().returnBankUser(5));
		

//		/* ---------------------------->3 UPDATE User <------------------------------------
//		 * UPDATE info on specific user from DB
//		 * */
//		UserService.getUserService().updatePassword(3, "update2");
//		/*
//		 * get user3 data
//		 * */
//		System.out.println(UserService.getUserService().returnBankUser(3));
	
		
//		/* ---------------------------->4 DELETE User <------------------------------------
//		 * DELETE specific user from DB
//		 * */
//		UserService.getUserService().deleteUser(16);
//		UserService.getUserService().deleteUser(17);
//		UserService.getUserService().deleteUser(18);
//		UserService.getUserService().deleteUser(19);

//		
//		if(UserService.getUserService().returnBankUser(2) == null) {
//			System.out.println("User doesn't exist!");
//		}
//		

		/*********************************** Account *******************************************/
		
//		System.out.println(AccountService.getGivenUserAccountsListService(1).get(0)) ;
//		System.out.println(AccountService.getGivenUserAccountsListService(1).get(1)) ;	
//		System.out.println(AccountService.getGivenUserAccountsListService(1).get(2)) ;
//		System.out.println(AccountService.getGivenUserAccountsListService(1).get(3)) ;
		
		
//		AccountService.deleteUserBankAccounts(2);
		
		
		/* ---------------------------->1 GET Account <------------------------------------
		 * GET user#1 data from DB
		 * */
//		System.out.println( AccountService.returnBankAccount(100,1));
		
//		System.out.println(UserService.getUserWithUserNamePassWord("byronzy", "123"));
		
		
//		user_id = 2;
//		
//		createNewBankAccount();
		
		
		
		/*********************************** Welcome Menu *******************************************/	
		WelcomeMenu();
	}

	private static void DeleteAccount() {
		// TODO Auto-generated method stub
		
	}

	private static void WithdrawMoney(BankUser bu) {
		System.out.println("\nAccount Overview below: ");
		int givenUserId = bu.getUser_id();
//		System.out.println("b deposit" + givenUserId);
		
		//1.Accounts Overview
		accountOverview( AccountService.getGivenUserAccountsListService(givenUserId) );
//		System.out.println("c deposit");
		//2.display all accounts info(balance, type)
		
		
		System.out.println("choose Account to withdraw, enter account id please: ");
		int whichAccount = 0;
		int moneyDeposit = 0;
		try { //DONT USE SCANNER.NEXT INT!!!!!!
			whichAccount = Integer.parseInt(scanner.nextLine());
		}
		catch(NumberFormatException e) {
			System.out.println("Sorry, you must enter a number:)  \n\n\n\n\n");
			WelcomeMenu();
		}
		System.out.println("Enter how much money to withdraw, enter (-)amount please: ");
		try { //DONT USE SCANNER.NEXT INT!!!!!!
			moneyDeposit = Integer.parseInt(scanner.nextLine());
		}
		catch(NumberFormatException e) {
			System.out.println("Sorry, you must enter a number:) \n\n\n\n\n");
			WelcomeMenu();
		}
		
		
		depositToSpecificAccountWithMoney(whichAccount, moneyDeposit, AccountService.getGivenUserAccountsListService(givenUserId) );
		
		accountOverview( AccountService.getGivenUserAccountsListService(givenUserId) );
		
	}
	
	
	/*
	 * allow user to deposit money in specific bank account
	 * feature:
	 * 1.display total user banks accounts(one or more)
	 * 2.show all accounts info(balance, type)
	 * 3.display total of all accounts and store it to global variable for later use
	 * */
	private static void DepositMoney(BankUser bu) {
		System.out.println("======================== Deposit ================================== ");
		System.out.println("Account Overview below: ");
		int givenUserId = bu.getUser_id();
//		System.out.println("b deposit" + givenUserId);
		
		//1.Accounts Overview
		accountOverview( AccountService.getGivenUserAccountsListService(givenUserId) );
//		System.out.println("c deposit");
		//2.display all accounts info(balance, type)
		
		
		System.out.println("choose Account to deposit, enter account id please: ");
		int whichAccount = 0;
		int moneyDeposit = 0;
		try { //DONT USE SCANNER.NEXT INT!!!!!!
			whichAccount = Integer.parseInt(scanner.nextLine());
		}
		catch(NumberFormatException e) {
			System.out.println("Sorry, you must enter a number between 1 to 9 \n\n\n\n\n:)");
			WelcomeMenu();
		}
		System.out.println("Enter how much money to deposit, enter amount please: ");
		try { //DONT USE SCANNER.NEXT INT!!!!!!
			moneyDeposit = Integer.parseInt(scanner.nextLine());
		}
		catch(NumberFormatException e) {
			System.out.println("Sorry, you must enter a number between 1 to 9 \n\n\n\n\n:)");
			WelcomeMenu();
		}
		
		
		depositToSpecificAccountWithMoney(whichAccount, moneyDeposit, AccountService.getGivenUserAccountsListService(givenUserId) );
		
		accountOverview(AccountService.getGivenUserAccountsListService(givenUserId));
		//3.display total of all accounts and store it to global variable for later use
	}

	private static void depositToSpecificAccountWithMoney(int whichAccount, int moneyDeposit, ArrayList<BankAccount> mlist) {
		
			int totalBalance = 0;
			int userId = 0;
			for(int i = 0; i < mlist.size(); i++) {
				
				totalOfAllAccountsBalance += mlist.get(i).getBalance();
				if(mlist.get(i).getAccount_id() == whichAccount) {
					//update date money += moneyDeposit
					totalBalance = mlist.get(i).getBalance() + moneyDeposit;
					userId = mlist.get(i).getUser_id();
				}
				
			} 
			
			//display message to console
			System.out.println("Account " + whichAccount + " has total balance: " + totalBalance);
			//update balance to db
			AccountService.updateBalanceOfUserAccountService(whichAccount, userId, totalBalance);
			
			accountOverview( AccountService.getGivenUserAccountsListService(userId) );
			
			//check if user want to continue or not
			returnCustomerMenu(getReturningUserAccount(user_name, pass_word));
	}

	private static void accountOverview( ArrayList<BankAccount> mlist) {

		int s = mlist.size();
		totalOfAllAccountsBalance = 0;
		if(mlist.isEmpty() ) {
			
			System.out.println("\n\nYou don't have any bank account yet, create one today!\n\n");
			createNewBankAccount();
			
		} else {
			for(int i = 0; i < s; i++) {
				System.out.println(mlist.get(i));
				totalOfAllAccountsBalance += mlist.get(i).getBalance();
			} 
			System.out.println("Your Total balance of all accounts: " + totalOfAllAccountsBalance + "\n\n");
		}
		
		
	}


	
	

	private static BankUser getReturningUserAccount(String user_name2, String pass_word2) {
		return UserService.getUserWithUserNamePassWord(user_name2, pass_word2);
		
	}

	private static void Quit() {
		System.out.println("Thanks for visiting Zheng's Bank, Have a nice day!");
		System.exit(0);
	}

	private static void CreateNewUserAccount() {
		
		// TODO Auto-generated method stub
		System.out.println("Enter your First Name:");
		first_name = scanner.nextLine();
		System.out.println("Enter your Last Name:");
		last_name = scanner.nextLine();
		

		System.out.println("Enter your Username:");
		user_name = scanner.nextLine();
			
		compareUserName(user_name);
		
		if(pass_word == null) {
			System.out.println("Enter your Password: ");
			pass_word = scanner.nextLine();
			isNew = true;
		} 
		
		System.out.println("before new");
		
		if(isNew) {
			System.out.println("after new");
			
			//assign new userId 
			getUniqueUserId();
			System.out.println("after new");
			CreateNewUser();
			System.out.println("Congratulations! You have successfully created new user Account in Zheng's Bank! ");
			System.out.println(" Here's your Info:  " + first_name + " " + last_name+ " " +user_name + " " + pass_word + ",and Your unique user ID is : " + user_id);
			
			//=================================================
			returnCustomerMenu(getReturningUserAccount(user_name, pass_word));
			//=================================================
		}
//		System.out.println(isNew);
	}
	
	
	/*
	 * in order to assign new bank account, we need to assign unique 
	 * account id to customer
	 * */
	private static void createNewBankAccount() {
		
//		System.out.println(AccountService.getTotalBankAccountNumberService());
		
		int uniqueNewAccountId = getUniqueNewAccountId();
		
		
		String acctype = userInputAcctype();
		
		int depositAmout = depositToday();
		
//		System.out.println(uniqueNewAccountId);
//		System.out.println(user_id);
//		System.out.println(acctype);
		
		AccountService.createNewBankAccount(uniqueNewAccountId, user_id, depositAmout, acctype);
		System.out.println("Congratulations here's your new account info:\n " + AccountService.returnBankAccount(uniqueNewAccountId, user_id));
		
		
	}
	
	
	
	private static int depositToday() {
		
		System.out.println("How much do you want to deposit today? ");
		int option = 0;
		try { //DONT USE SCANNER.NEXT INT!!!!!!
			option = Integer.parseInt(scanner.nextLine());
		}
		catch(NumberFormatException e) {
			System.out.println("Sorry, you must enter number 1,2,3  \n\n\n\n\n:)");
			depositToday();
		}
		return option;
	}

	private static int getUniqueAccoutId() {
		// TODO Auto-generated method stub
		return 0;
	}

	private int getAccountBalance() {
		
		return 0;
	}
	
	
	
	private static String userInputAcctype() {
		
		System.out.println(" Which Account do you want?");	
		System.out.println("1. saving  ");
		System.out.println("2. checking");	
		System.out.println("3. credit");	
		int option = 0;
		String acctype = "";
		try { //DONT USE SCANNER.NEXT INT!!!!!!
			option = Integer.parseInt(scanner.nextLine());
		}
		catch(NumberFormatException e) {
			System.out.println("Sorry, you must enter number 1,2,3  \n\n\n\n\n:)");
			userInputAcctype(); 
		}
		switch(option) {
		case 1: 
			acctype = "saving";
			break;
		case 2:
			acctype = "checking";
			break;
		case 3:
			acctype = "credit";
			break;
		}
		return acctype;
	}

	/*
	 * get Unique new Account Id 
	 * */
	private static int getUniqueNewAccountId() {
		return AccountService.getTotalBankAccountNumberService() + 1;
		
	}

	private static void CreateNewUser() {
		UserService.getUserService().createNewBankUser(user_id, first_name,last_name,user_name,pass_word);
		/*
		 * reset 
		 * */
		isNew = false;
	}

	//assign new userId 
	private static void getUniqueUserId() {
		user_id = UserService.getTotalUserNumberService() + 5;
		System.out.println("user id: " + user_id);
	}
	
	private static int getTotalUserNumber() {
		return UserService.getTotalUserNumberService();
	}


	/*
	 *compare user name, if exist, ask for login
	 *if that's not him, ask to choose another username
	 * */
	private static void compareUserName(String user_name) {

		String[] arr= new String[getTotalUserNumber()];
		arr = UserService.userNameList();
		for(int i = 0; i <arr.length; i++ ) {
			
			if(user_name.equals(arr[i])) {
				isNew = false;
				System.out.println("username exist ");
				System.out.println("1. Create New Account ");
				System.out.println("2. Login");	
				int option = 0;
				try { //DONT USE SCANNER.NEXT INT!!!!!!
					option = Integer.parseInt(scanner.nextLine());
				}
				catch(NumberFormatException e) {
					System.out.println("Sorry, you must enter number 1 or 2 \n\n");
					CreateNewUserAccount(); 
				}
				switch(option) {
				case 1: 
					CreateNewUserAccount(); 
					break;
				case 2:
					Login();
					break;
				}
			} 
		}	
	}
	

	




	/*
	 * login
	 * */
	private static void Login() {
		isNew = false;
		
		String temp_username = user_name;
		String temp_password = pass_word;
		
		System.out.println("=========Login Menu==========");
		System.out.println("Enter your Username:");
		user_name = scanner.nextLine();
		
		if(pass_word == null) {
			System.out.println("Enter your Password: ");
			pass_word = scanner.nextLine();
		}
		
		
		
		
		
		if(getReturningUserAccount(user_name, pass_word) != null) {
			
//			System.out.println(getReturningUserAccount());
			//update current user id
			user_id = getReturningUserAccount(user_name, pass_word).getUser_id();
			System.out.println(" Welcome back to Zheng's Bank!, " + getReturningUserAccount(user_name, pass_word).getFirst_name() + "! Customer ID: " + user_id);
			
			returnCustomerMenu(getReturningUserAccount(user_name, pass_word));
			
		} else {
			user_name = temp_username;
			pass_word = temp_password;
			System.out.println("Oops, info doesn't match our record, try again! ");
			Login();
		}

		
	} // end of login
	
	/*
	 * return customer menu
	 * */
	private static void returnCustomerMenu(BankUser bankUser) {
		System.out.println( "=================== return Customer Menu ===================");
		System.out.println("\nNext, please select from below:");	
		System.out.println("1. deposit  ");
		System.out.println("2. withdraw");	
		System.out.println("3. create New BankAccount");	
		System.out.println("4. sign out\n\n");	
		System.out.println("5. delete bank account\n\n");	
		
		int option = 0;
		try { //DONT USE SCANNER.NEXT INT!!!!!!
			option = Integer.parseInt(scanner.nextLine());
		}
		catch(NumberFormatException e) {
			System.out.println("Sorry, you must enter number 1,2,3  \n\n\n\n\n:)");
			returnCustomerMenu(bankUser); 
		}
		switch(option) {
		case 1: 
			DepositMoney(bankUser);
			break;
		case 2:
			WithdrawMoney(bankUser);
			break;
		case 3:
			createNewBankAccount();
			break;
		case 4:
			Quit();
			break;
		case 5:
			deleteAllBankAccounts(bankUser);
			break;
		}
		
	} //end of  return customer menu
	
	private static void deleteAllBankAccounts(BankUser bankUser) {
		 AccountService.deleteUserBankAccounts(bankUser.getUser_id());
		 System.out.println( "Sorry to see you go, we will miss you! come back anytime!");
		 returnCustomerMenu( bankUser);
	}

	/*
	 * welcome menu
	 * */
	private static void WelcomeMenu() {
		// TODO Auto-generated method stub
		System.out.println( "=================== Welcome to Zheng's Bank ===================");
		System.out.println("---------Main Menu--------\n"
				+ "1. Create New UserAccount\n"
				+ "2. Return customer Login\n"
				+ "9. Quit\n"
				);
		
		int option = 0;
		try { //DONT USE SCANNER.NEXT INT!!!!!!
			option = Integer.parseInt(scanner.nextLine());
		}
		catch(NumberFormatException e) {
			System.out.println("Sorry, you must enter a number:) \n\n");
			WelcomeMenu();
		}
		
		switch(option) {
		case 1: 
			CreateNewUserAccount(); 
			break;
		case 2:
			Login();
			break;

		case 9:
			 Quit();
			break;
		}
	} // end of welcome menu
}
