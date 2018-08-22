package Dao;

import model.BankAccount;

public interface AccountDao {
	
	//return a BankAccount
	public BankAccount getBankAccount( int accountId, int userId);
}
