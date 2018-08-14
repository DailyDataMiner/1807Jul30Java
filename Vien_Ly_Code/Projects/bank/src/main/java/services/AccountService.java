package services;

import java.util.List;

import beans.Account;
import dao.AccountDAO;
import dao.DAO;
import exceptions.UsernameNotAvailableException;

public class AccountService {
	static DAO<Account, Integer> accDAO = new AccountDAO();
	
	public Account findOne(Integer i) {
		return accDAO.findOne(i);
	}
	
	public Account save(Account acc) {
		return accDAO.save(acc);
	}
	
	public Account update(Account acc) {
		return accDAO.update(acc);
	}
	
	public List<Account> findAllByCustomerId(int customerId) {
		return ((AccountDAO)accDAO).findAllByCustomerId(customerId);
	}
	
	public void delete(Account acc) {
		accDAO.delete(acc);
	}
}
