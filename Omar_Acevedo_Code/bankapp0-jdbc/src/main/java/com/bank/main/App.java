package com.bank.main;
import static java.lang.System.in;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.bank.pojos.Account;
import com.bank.pojos.Person;
import com.bank.pojos.User;
import com.bank.userinteractions.AccountUI;
import com.bank.userinteractions.TransactionUI;
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
 * 
 * */

public class App extends HelperFunctions {

	public static void main(String[] args) {
		
		while ( displayMenu() ) {}
		
		print("The program just terminated."); // here?
		
	}
	
	
	private static boolean displayMenu() {

//		init vars
		User userObj = null;
		User newUserObj = null;
		boolean _flag = false;
		boolean _createAccount = false;
		boolean _continueInLogInPage = true;
		String userResponse;
		Scanner readFromUser = new Scanner(in);
		Account accountObj = null;
		
		print(" \nWELCOME TO THE BANK APPLICATION (v0) ");
		print("    Press 1 to Log In");
		print("    Press 2 to Sign Up");
		
		try {
		
//			String option = readFromUser.next();
			int option = readFromUser.nextInt();
		
			do {
				if ( option == 2 ) {	// Sign Up chosen
					
					newUserObj = UserUI.display();	// rethink where this should go.
					
					// stupidiest condition ever .. change this; redefine it
					if (newUserObj.getUserid() > 0) {
						
						print("    WANT TO CREATE ACCOUNT NOW? (y/n)");
						_createAccount = (readFromUser.next().equals("y") ? true : false);
						
						if (_createAccount) {
							
			// 				Retrieve newly created user to use in creation of account
			//				User newUserObj = UserUI.display();
							
							int userId = newUserObj.getUserid();
							accountObj = AccountUI.createAccount(userId);  // returns Account
						
							print("Account has been created");
							print("Account name:  " + newUserObj.getUsername() + " (" + accountObj.getAccount_number() + " )");
							print("Account email: " + newUserObj.getEmail());
							
							_continueInLogInPage = false;
							
						} else {
							print("in the else line... _createAccount -> " + _createAccount); 
							_continueInLogInPage = true;
						}
					}
					
				} else if ( option == 1 ) {
					
	//				Display log in menu options, and this will return a new instance of User object. ?
					userObj = UserUI.logIn(); 
					
					
					if (userObj.getUserid() == 0)  {
						print("Your user does not exist here.\nTry again");
						_continueInLogInPage = true;
	
					} else {
						
						print("\tWelcome " + userObj.getUsername() + " (" + userObj.getUserid() + ") !");
	
	// 					Get account info from the userObj
	//					return a new instance of Account object. ?
	//					Show account info.
						
						accountObj = AccountUI.getAccountInfo(userObj.getUserid());
						
						print("\t---Account Info--------------");
	//					print(accountObj.toString());
						print("\t|  User name:       " + userObj.getUsername());
						print("\t|  Account Number:  " + accountObj.getAccount_number());
						print("\t|  Account Type:    " + accountObj.getAccountTypeName());
						print("\t|  Account Balance: $" + accountObj.getBalance());
						print("\t|  Account Status:  " + accountObj.getStatus());
						print("\t-----------------------------");
						
						_continueInLogInPage = false;
					}
					
				}
				
			} while (_continueInLogInPage);
			
		} catch (InputMismatchException ime) {
			_continueInLogInPage = true;
			print("Try entering only numbers.");
//			ime.printStackTrace();
		} finally {
			
//			_continueInLogInPage = true;
			
//			Go back to start
//			App.main(new String[0]);
		}
		
		
//		Log in and log out(end interaction with the app and have transaction persisted)
		print("\tWhat would you like to do? ");
		print("\t[ select a number ]");
		print("\t---Options---------------------");
// 		if creating user, you can ask if account has been created.
// 		here, part of the account creation is creating a user, which 
//		will also add data to persons table
// 		create one or more account(s) of specified types
		
		try {
				
			if (userObj.getUserid() != 0) {		
				print("\t|  1 - REGISTER NEW ACCOUNT FOR USER " + userObj.getUsername().toUpperCase());
			} else { // if id == 0
				print("\t|  1 - CREATE/REGISTER NEW ACCOUNT ");
			}	
			
		} catch(NullPointerException npe) {
			if (newUserObj.getUserid() != 0) {		
				print("\t|  1 - REGISTER NEW ACCOUNT FOR USER " + newUserObj.getUsername().toUpperCase());
			} else { // if id == 0
				print("\t|  1 - CREATE/REGISTER NEW ACCOUNT ");
			}
		}
	
		
//		User must be able to withdraw and deposit money  (also transfer money...? -for next version
		print("\t|  2 - DO TRANSACTION ( deposit, withdrawal )");

		
//		EXIT application? ... log out --> go back to log in page
		print("\t|  3 - EXIT application? ... (log out)");
		print("\t-----------------------------\n");
		
		
//		Wait for the user to choose an option.
		userResponse = readFromUser.next();
		
		
		switch (userResponse) {
		
			case "1":
				print("\t --> You selected 1.");
/* 				
 * 				- Do stuff like create user (and/or person?)
 *				- Remember, a user can create more than one account. 				
 */
//				AccountUI.display();
				AccountUI.createAccTypeForUser(userObj);
				
				_flag = true;
				break;
				
			
			case "2":

//				Go to the transactions menu UI, and pass account object to interact with user's acct.		
				TransactionUI.doTransactions(accountObj);
				
				_flag = true;
				break;
				
			case "3":
				
				print("You selected 3. you are going to exit/log out the app.");
				_flag = false;

//				Go back to start
				App.main(new String[0]);
				
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
