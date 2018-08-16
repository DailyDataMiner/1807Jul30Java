package com.revature.projectZero.Service;

import java.sql.SQLException;

import com.revature.projectZero.DAO.AccountDAO;
import com.revature.projectZero.DAO.UserDAO;
import com.revature.projectZero.Exceptions.InsufficientFundsException;
import com.revature.projectZero.POJO.Account;
import com.revature.projectZero.POJO.User;

public class Service {

	private static final UserDAO usrDao = new UserDAO();
	private static final AccountDAO accDao = new AccountDAO();

	public static User login(String usr, String pwd) throws SQLException {
		User u = usrDao.login(usr, pwd);
		if (u == null) {
			throw new SQLException();
		}
		return u;
	}

	public static User createUser(String fn, String ln, String usr, String pwd) {
		return usrDao.save(new User(fn, ln, usr, pwd));
	}

	public static Account createAccount(int userId, int accountTypeId, String accountName) {
		return accDao.save(new Account(userId, accountTypeId, accountName));
	}

	public static void deposit(Account acc, double amount) {
		acc.deposit(amount);
		accDao.update(acc);
	}

	public static void withdraw(Account acc, double amount) throws InsufficientFundsException {
		acc.withdraw(amount);
		accDao.update(acc);
	}
}
