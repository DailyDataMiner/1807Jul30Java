package com.revature.service;

import java.time.LocalDate;
import java.util.List;

import com.revature.dao.AccountDAO;
import com.revature.pojo.Account;
import com.revature.util.WithdrawException;

/**
 * Account service handles the logic 
 * behind account functions
 * 
 * @author Arthur Panlilio
 *
 */
public class AccountService {
	
	//The account DAO
	static AccountDAO aDao = new AccountDAO();

	
	/**
	 * Returns all the accounts
	 * 
	 * @return a list of account
	 */
	public List<Account> getAll(){
		return aDao.findAll();
	}
	
	/**
	 * Returns a user's accounts
	 * 
	 * @param userId is the user 
	 * @return a list of the user's accounts
	 */
	public List<Account> getAllMine(int userId, LocalDate currDate, double interest){
		return aDao.findAllMine(userId, currDate, interest );
	}
	
	/**
	 * Returns an updated account back to the interface
	 * 
	 * @param a the account to be fetched
	 * @return the updated accounted
	 */
	public Account update(Account a) {
		return aDao.findOne(a.getUserId(), a.getAccountTypeId());
	}
	
	/**
	 * Gets the account type string
	 * 
	 * @param accType is the id of the account type
	 * @return a string of the account type
	 */
	public String getAccType(int accType) {
		return aDao.findAccountTypeName(accType);
		
	}
	
	/**
	 * Adds an account to the database
	 * 
	 * @param a is the account to be saved
	 * @return an account for verification
	 */
	public Account save(Account a) {
		Account temp = null;
		//checks if the account already exists in the database
		if(aDao.findOne(a.getUserId(), a.getAccountTypeId()) == null) {
			temp = aDao.save(a);
		}
		return temp;
	}
	
	/**
	 * Returns the balance of an account
	 * 
	 * @param a is the account
	 * @return a double balance
	 */
	public double getBalance(Account a) {
		return aDao.findOne(a.getUserId(), a.getAccountTypeId()).getBalance();
	}
	
	
	/**
	 * Withdraws an amount from an account
	 * 
	 * @param wit is the amount to be withdrawn
	 * @param a is the account
	 * @throws WithdrawException is thrown when withdrawal amount is higher than balance
	 */
	public void withdraw(double wit, Account a) throws WithdrawException {
		if(wit <= a.getBalance()) {
			aDao.withdraw(wit, a.getAccountId());
		}else {
			//returns exception and returns the difference between withdrawal and balance
			double atleast = wit -a.getBalance();
			throw new WithdrawException(atleast);
		}
	}
	
	/**
	 * Deposits an amount into an account
	 * 
	 * @param dep the amount to be deposited
	 * @param a is the account
	 * @return if it worked or not
	 */
	public boolean deposit(double dep, Account a) {
		boolean success = false;
		if(dep > 0) {
			aDao.deposit(dep, a.getAccountId());
		}
		return success;
	}
	
	

}
