package com.bank.userinteractions;
import static java.lang.System.in;

import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

import com.bank.daos.AccountAccountTypeDao;
import com.bank.daos.AccountDao;
import com.bank.pojos.Account;
import com.bank.pojos.AccountStatus;
import com.bank.pojos.AccountType;
import com.bank.pojos.User;
import com.bank.utils.HelperFunctions;

public class AccountUI extends HelperFunctions {
	
	private static Account accountObj = null;
	private static AccountDao accountDao = null;
	private static AccountAccountTypeDao accountAccountTypeDao = null;
	private static Scanner readFromUser = null;

	public static void display() {
		
		print(" CREATE A USER ACCOUNT ");
		Scanner readFromUser = new Scanner(in);
		
	}
	
	public static void createAccTypeForUser(User userObj) {
		
		String userAnswer;
		double newBalance = 0.00;
		readFromUser = new Scanner(in);
		accountDao = new AccountDao();
		accountAccountTypeDao = new AccountAccountTypeDao();
		
		// Get account data from userObj user id
		accountObj = accountDao.read(userObj.getUserid());
		
		
//		Verify for current account type (SAVINGS or CHECKING)
//		HashMap<Integer, String> currAccType = new HashMap<Integer, String>();
		
		
//		Get the other account type, this account doesn't currently have.
		String newAccType = accountAccountTypeDao.getSuggestedAccType(accountObj);
		
		
		print("Current account type is " + accountObj.getAccountTypeName());
		print("Do you want to add a " + newAccType + " type to your account? (yes or no)");
		
		userAnswer = readFromUser.next();
		
		if (userAnswer.equals("yes")) {
			
			// Add new type of account... with SAME account.
			print("Ok, ... Do you want to add some money to this new " + newAccType + " account? (yes or no)");
			
			userAnswer = readFromUser.next();
			
			if (userAnswer.equals("yes")) {
				print("Enter it below: ");
				newBalance = readFromUser.nextDouble();	
			}
			
			accountDao.createAccTypeForUser(accountObj, newAccType, newBalance);
			
		} else {
			print("ok, fine...");
		}
		
		
	}
	
	public static Account createAccount(int p_userId) {
		
//	Function used for signing up for the first time.
// 	I am passing newUserObj id into create account dao, to use it as fk in accounts table.
// 	here I ask the user for account info
// 	use this ... -> newUserObj which is the newly created user
		
		accountDao 				= new AccountDao();
		accountAccountTypeDao 	= new AccountAccountTypeDao();
		
		accountObj = new Account();
		readFromUser = new Scanner(in);
		Random rand = new Random();

		
		String 	_accountNumber;
//		int 	_accountNumber;
		int 	_userId = p_userId;
		String 	_status = AccountStatus.OPEN.toString(); // or ACTIVE?
		int		_accountTypeId;
		String	_accountTypeName;
		double	_accountBalance = 0.00;
		
		
//		Get account number
		//print("	  ACCOUNT NUMBER: ");
		
//		Let the user create (enter) an account number?
//		_accountNumber = readFromUser.next();

		
//		Or generate it randomly?
//		int randNum = rand.nextInt(500);
//		_accountNumber = Integer.toHexString(rand.nextInt(500));
		_accountNumber = Integer.toString(rand.nextInt(5000));
		
		
//		print();
		//	Set account number
		accountObj.setAccount_number(_accountNumber);

		
		//	Set fk account user id
		accountObj.setUserid(_userId);
		
		//	Set account status
		accountObj.setStatus(_status);
		
//		Account DAO ( do DML )
// 	 	Here the accountid gets generated and can be used later (following this line)
		accountObj = accountDao.create(accountObj);
		
		
//		Here we would set (insert into P0_ACCOUNT_ACCOUNTTYPE table)
		
		//	Set ACCOUNTID on object AccountAccountType
		accountObj.setAccountid( accountObj.getAccountid() );
		
		//	Ask for account type
		print("  ACCOUNT TYPE => CHECKING or SAVINGS " );
		_accountTypeName = readFromUser.next().toUpperCase();
		
		if ( ( _accountTypeName.equals(AccountType.CHECKING.toString())) || 
			 ( _accountTypeName.equals(AccountType.SAVINGS.toString())) ) {
			
			print("Account type set to " + _accountTypeName);
			
			//	Get id from acc. type name. Dao is used here to get the id of the account type name.
			_accountTypeId = accountAccountTypeDao.getAccountTypeId(_accountTypeName);
			
			
			//	Set id of acc. type
			accountObj.setAccounttypesid(_accountTypeId); // search in db for "name" of acc type to get id from P0_ACCOUNTTYPES table.
			
		} else {
			
			print(" Dude, learn to choose or write... ");
			print("'"+_accountTypeName+"', really?");
			accountObj.setAccounttypesid(1);
		
		}
		
		//	Set account balance
		print("   ACCOUNT BALANCE: ");
		_accountBalance = readFromUser.nextDouble();	// try entering negative numbers here.
														// eval if() or... to catch error(s)... and deal with 'em.
		
		accountObj.setBalance(_accountBalance);
		
		accountObj = accountAccountTypeDao.create(accountObj);
		
		return accountObj;
		
	}
	
	public static Account getAccountInfo(int p_userid) {
		
		// get account info from db using p_userid
//		accountDao = null;
		accountDao = new AccountDao();
//		accountObj = new Account();
		
		accountObj = accountDao.read(p_userid);
		
		return accountObj;
	}
	
}
