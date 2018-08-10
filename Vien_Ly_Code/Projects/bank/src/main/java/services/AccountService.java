package services;

import beans.Account;
import dao.AccountDAO;
import dao.DAO;

public class AccountService {
	static DAO<Account, Integer> accDAO = new AccountDAO();
	
	public Account save(Account acc) {
		return accDAO.save(acc);
	}
}
