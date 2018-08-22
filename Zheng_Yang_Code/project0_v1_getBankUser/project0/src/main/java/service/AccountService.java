package service;

import java.util.ArrayList;

import Dao.AccountDaoImplement;
import Dao.UserDaoImplement;
import model.BankAccount;

public class AccountService {
	public static AccountService accountService;
	
	private AccountService() {};
	
	public static AccountService getAccountService() {
		if(accountService == null) {
			accountService = new AccountService();
		}
		return accountService;
		
	}
	
	/*
	 * get bank account
	 * */
	public static BankAccount returnBankAccount(int accountId,  int userId) {
		return AccountDaoImplement.getDao().getBankAccount(accountId, userId);
	}
	
	/*
	 * get total bank account number
	 * */
	public static int  getTotalBankAccountNumberService() {
		return AccountDaoImplement.getDao().getTotalBankAccountNumberDao();
		
	}
	
	
	public static void createNewBankAccount(int account_id, int user_id, int balance, String account_type) {
		
		 AccountDaoImplement.getDao().newBankAccount(account_id, user_id, balance, account_type);
		
	}
	
	
	/*
	 * get list of accounts from given users
	 * */
	public static ArrayList<BankAccount>  getGivenUserAccountsListService( int userId) {
		return AccountDaoImplement.getDao().getListBankAccountsOfGivenUserDao( userId);
	}
	
	/*
	 * update balance of specific user account
	 * */
	public static void updateBalanceOfUserAccountService(int account_id, int user_id, int balance) {
		
		 AccountDaoImplement.getDao().updateBalanceOfGivenAccountDao(account_id, user_id, balance);
		
	}
	
	/*
	 * get list of accounts from given users
	 * */
	public static void  deleteUserBankAccounts( int userId) {
		 AccountDaoImplement.getDao().deleteUserBankAccountsDao(userId);
	}
	
}
