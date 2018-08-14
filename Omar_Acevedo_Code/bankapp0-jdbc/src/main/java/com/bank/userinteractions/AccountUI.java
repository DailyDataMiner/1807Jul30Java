package com.bank.userinteractions;
import static java.lang.System.in;

import java.util.Random;
import java.util.Scanner;

import com.bank.daos.AccountAccountTypeDao;
import com.bank.daos.AccountDao;
import com.bank.pojos.Account;
import com.bank.pojos.AccountStatus;
import com.bank.pojos.AccountType;
import com.bank.utils.HelperFunctions;

public class AccountUI extends HelperFunctions {
	
	private static AccountDao accountDao = null;
	private static AccountAccountTypeDao accountAccountTypeDao = null;
	private static Account accountObj = null;
	private static Scanner readFromUser = null;

	public static void display() {
		
		print(" CREATE A USER ACCOUNT ");
		Scanner readFromUser = new Scanner(in);
		
	}
	
	
	// this function (createAccount) is called from the UserUI class, because first goes the user creation, 
	//	then, the account to connect them user with account.
	
	public static Account createAccount(int p_userId) {
		// I am passing newUserObj id into create account dao, to use it as fk in accounts table.
		// here I ask the user for account info
		// use this ... -> newUserObj which is the newly created user
		
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
		
		//	Get account number
		print("	  ACCOUNT NUMBER: ");
		
		_accountNumber = readFromUser.next();

//		_accountNumber = rand.nextInt(500);
		//50 is the maximum and the 1 is our minimum 
		
//		print();
		//	Set account number
		accountObj.setAccount_number(_accountNumber);

		
		//	Set fk account user id
		accountObj.setUserid(_userId);
		
		//	Set account status
		accountObj.setStatus(_status);
		
		//	Account DAO ( do DML )
		//  Here the accountid gets generated and can be used later (following this line)
		accountObj = accountDao.create(accountObj);
		
		
//		Here we would set (insert into P0_ACCOUNT_ACCOUNTTYPE table)
		
		//	Set ACCOUNTID on object AccountAccountType
		accountObj.setAccountid( accountObj.getAccountid() );
		
		//	Ask for account type
		print("  ACCOUNT TYPE => C) CHECKING or S) SAVINGS " );
		_accountTypeName = readFromUser.next().toUpperCase();
		
		if ( ( _accountTypeName.equals(AccountType.CHECKING.toString())) || 
			 ( _accountTypeName.equals(AccountType.SAVINGS.toString())) ) {
			
			
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
