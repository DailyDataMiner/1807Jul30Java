package com.revature.project0.service;

import java.util.List;

import com.revature.project0.dao.AccountDAO;
import com.revature.project0.myexceptions.NotEnoughMoneyException;
import com.revature.project0.projectobjects.Account;


public class AccountService {

static AccountDAO aDao = new AccountDAO();
	

	public List<Account> getAll() {
		return aDao.findAll();
	}
	public Account getOne(int input) {
		return aDao.findOne(input);
	}
	public Account saveAccount(Account a) {
		return aDao.save(a);
	}
	public void deleteAccount(Account a) {
		aDao.delete(a);
	}
	public Account updateAccountBalance(Account a) {
		return aDao.updateAccountBalance(a);
	}
	public Account withdraw(Account a, double withdrawAmount) throws NotEnoughMoneyException {
		a.withdraw(withdrawAmount);
		return updateAccountBalance(a);
	}
	public Account deposit(Account a, double depositAmount) {
		a.deposit(depositAmount);
		return updateAccountBalance(a);
	}
	public Account transfer(Account a, Account b, double transferAmount) throws NotEnoughMoneyException {
		a.withdraw(transferAmount);
		b.deposit(transferAmount);
		updateAccountBalance(b);
		return updateAccountBalance(a);
	}
}
