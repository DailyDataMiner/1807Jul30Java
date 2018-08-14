package com.bank.main;
import static java.lang.System.in;

import java.util.Scanner;

import com.bank.pojos.Account;
import com.bank.pojos.Person;
import com.bank.pojos.User;
import com.bank.userinteractions.AccountUI;
import com.bank.userinteractions.UserUI;
import com.bank.utils.HelperFunctions;

/*
 * 
 * 	### Requirements
	* Create a Banking app where your user communicates with your app through the console 
	* A user must be able to create an account
	* A user must be able to log in and log out(end interaction with the app and have transaction persisted)
	* A user must be able to create one or more account(s) of specified types
	* A user must be able to withdraw and deposit money 
	* There should be validation to make sure that usernames are unique, 
	* users aren't withdrawing more money than they have in the particular account, 
	* and that the application will not stop running if a user enters an incompatible data type 
	* with what your application expects
 * 
 * */

public class App extends HelperFunctions {

	public static void main(String[] args) {
		
		while ( displayMenu() ) {}
		
		print("The program just terminated."); // here?
		
	}
	
	private static boolean displayMenu() {
		
		User userObj;
		boolean _flag = false;
		boolean _createAccount = false;
		boolean _continueInLogInPage = true;
		String userResponse;
		Scanner readFromUser = new Scanner(in);
		
		print(" WELCOME TO MY PROGRAM ");
//		print("LOGIN ? -> YES/NO");
// 		ASK FOR USER LOGIN CREDENTIALS
		
		print("    1) Log In | 2) Sign Up ");
		
		String option = readFromUser.next();
		
		do {
			if ( option.equals("2") ) {	// Sign Up chosen
				
				User newUserObj = UserUI.display();	// rethink where this should go.
				
				// stupidiest condition ever .. change this; redefine it
				if (newUserObj.getUserid() > 0) {
					
					print("    WANT TO CREATE ACCOUNT NOW? (y/n)");
					_createAccount = (readFromUser.next().equals("y") ? true : false);
					
					if (_createAccount) {
						
						Account accountObj;
						
		// 				Retrieve newly created user to use in creation of account
		//				User newUserObj = UserUI.display();
						
						int userId = newUserObj.getUserid();
						accountObj = AccountUI.createAccount(userId);  // returns Account
					
						print("Account has been created");
						print("account name -> " + newUserObj.getUsername() + " (" + accountObj.getAccount_number() + " )" );
						print(newUserObj.toString() + "\n");
						
						_continueInLogInPage = false;
						
					} else {
						print("in the else line... _createAccount -> " + _createAccount); 
						_continueInLogInPage = true;
					}
				}
				
			} else if ( option.equals("1") ) {
				
				userObj = UserUI.logIn(); // this will return a new instance of User object. ?
				
				print(" Welcome " + userObj.getUsername() + "!");
				print(" " + userObj.toString());
				
				if (userObj.getUserid() == 0)  {
					print("Your user does not exist here.\nTry again");
					_continueInLogInPage = true;

				} else {
					print("\nYou can now continue...");
					
					Account accountObj = null;
					
// 					here I get the account info from the userObj
//					accountObj = AccountUI... // this will return a new instance of Account object. ?
					
					accountObj = AccountUI.getAccountInfo(userObj.getUserid());
					
					//	Show account info.
					print(accountObj.toString());
					print("  Accounttypesid -> " + accountObj.getAccounttypesid());
					print("  Account Type -> " + accountObj.getAccountTypeName());
					print("  Balance -> $" + accountObj.getBalance() + "\n");
					
					_continueInLogInPage = false;
				}
				
			}
			
		} while (_continueInLogInPage);
		
		// log in and log out(end interaction with the app and have transaction persisted)
		print(" These are the options: ");
		
		// if creating user, you can ask if account has been created.
		// here, part of the account creation is creating a user, which will also add data to persons table
		// create one or more account(s) of specified types
		print(" 1 - CREATE/REGISTER NEW ACCOUNT ");
		
		// user must be able to withdraw and deposit money 
		print(" 2 - DO TRANSACTION ( deposit, withdrawal, transfer money  ");

		// EXIT application? ... log out
		print(" 3 - EXIT application? ... (log out)");
		
		userResponse = readFromUser.next();
//		userResponse = readFromUser.nextLine();
		
		switch (userResponse) {
			case "1":
				print("\t --> You selected 1.");
				// do stuff like create user...person
				AccountUI.display();
				_flag = true;
				break;
			case "2":
				print("You selected 2; let's do a transaction");
				print("What type of transaction do you want to make ( 1.deposit, 2.withdrawal, 3.transfer money ) ?");
				// read from user to see what transaction the user wants to make
				// call function and pass accountObj as argument to a TransactionUI; which uses TransactionDao
				print("What type of transaction do you want to make ( 1.deposit, 2.withdrawal, 3.transfer money ) ?");
				// line above will go insie doTransaction() ... ?
//				TransactionUI.doTransaction();
				_flag = true;
				break;
			case "3":
				print("You selected 3. you are going to exit/log out the app.");
				// do stuff like create user...person
				_flag = false;
				break;
			default:
				print("continue?");
				break;
		}
		
		return _flag;
	}
	
	private static void createPerson(Person obj) {
		
//		Scanner readFromUser = new Scanner(in);
//		
//		principal = readFromUser.nextDouble();
//
//		print("Rate of Interest: ");
//		rate = readFromUser.nextDouble();
//
//		print("Number of Years: ");
//		time = readFromUser.nextInt();		
		
		
	}

}
