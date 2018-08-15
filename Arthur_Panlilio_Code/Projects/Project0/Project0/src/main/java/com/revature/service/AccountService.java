package com.revature.service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import com.revature.dao.AccountDAO;
import com.revature.pojo.Account;
import com.revature.util.LessThanZeroException;
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
	
	public List<Account> getAllofType(int accTypeId){
		return aDao.findAllofType(accTypeId);
	}
	
	/**
	 * Returns a user's accounts
	 * 
	 * @param userId is the user 
	 * @return a list of the user's accounts
	 */
	public List<Account> getAllMine(int userId, LocalDate currDate, double interest){
		List<Account> accs = aDao.findAllMine(userId);
		for(Account a: accs) {
			int daysPassed = getDifferenceDays(a.getLastUpdate(), Date.valueOf(currDate));
			a = aDao.updateDate(a, currDate, 4, daysPassed);
		}
		return accs;
	}
	
	/**
	 * Returns an updated account back to the interface
	 * 
	 * @param a the account to be fetched
	 * @return the updated accounted
	 */
	public Account update(Account a) {
		return aDao.findOne(a.getUserId(), a.getName());
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
		if(aDao.findOne(a.getUserId(), a.getName()) == null) {
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
		return aDao.findOne(a.getUserId(), a.getName()).getBalance();
	}
	
	
	/**
	 * Withdraws an amount from an account
	 * 
	 * @param wit is the amount to be withdrawn
	 * @param a is the account
	 * @throws WithdrawException is thrown when withdrawal amount is higher than balance
	 * @throws LessThanZeroException 
	 */
	public void withdraw(double wit, Account a) throws WithdrawException, LessThanZeroException {
		double balance = a.getBalance();
		boolean communal = false;
		if(aDao.findAccountTypeName(a.getAccountTypeId()).equals("Communal")) {
			communal = true;
			List<Account> accs = getAllofType(a.getAccountTypeId());
			for(Account ca: accs) {
				balance += ca.getBalance();
			}
		}
		if(wit <= balance && wit >= 0) {
			if(!communal) {
				aDao.withdraw(wit, a.getAccountId());
			} else {
				List<Account> accs = getAllofType(a.getAccountTypeId());
				double totalOwed = wit;
				for(int i = 0; i < accs.size(); i++) {
					double toWithdraw = totalOwed;
					if(toWithdraw <= 0.0) {
						break;
					}
					if(toWithdraw > accs.get(i).getBalance()) {
						toWithdraw = accs.get(i).getBalance();
					}
					aDao.withdraw(toWithdraw, accs.get(i).getAccountId());
					totalOwed -= toWithdraw;
				}
			}
		} else if(wit < 0){
			throw new LessThanZeroException();
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
	 * @return if it worked or not. 0 = failed, 1 = worked, 2 = won, 3 = lost
	 */
	public int deposit(double dep, Account a) {
		int success = 0;
		boolean gambling = false;
		if(aDao.findAccountTypeName(a.getAccountTypeId()).equals("Gambling")) {
			Random r = new Random();
			int q = r.nextInt(100);
			if(q <= 50) {
				dep = dep/2;
				success = 3;
			} else {
				dep = dep+(dep/2);
				success = 2;
			}
			gambling = true;
		}
		if(dep > 0) {
			aDao.deposit(dep, a.getAccountId());
			if(!gambling) {
				success = 1;
			}
		}
		return success;
	}
	
	/**
	 * Deletes an account
	 * if it is a communal account, find other communal account to transfer funds to. 
	 * @param a is the account to be deleted
	 * @return the account to be deleted
	 */
	public boolean delete(Account a) {
		if(aDao.findAccountTypeName(a.getAccountTypeId()).equals("Communal")) {
			double balance = getBalance(a);
			List<Account> accs = getAllofType(3);
			if(accs.size() >= 1) {
				for(int i = 0; i < accs.size(); i++) {
					if(accs.get(i).getAccountId() != a.getAccountId()) {
						aDao.deposit(balance, accs.get(i).getAccountId());
						break;
					}
				}
			}
		}
		return aDao.delete(a.getAccountId());
	}
	
	/**
	 * Gets the difference between two dates in times
	 * 
	 * @param d1
	 * @param d2
	 * @return the days
	 */
	public int  getDifferenceDays(Date d1, Date d2) {
	    long diff = d2.getTime() - d1.getTime();
	    return (int) TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
	

}
