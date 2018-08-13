package com.revature.project0.service;

import java.util.List;

import com.revature.project0.dao.UserToAccountDAO;
import com.revature.project0.projectobjects.Account;
import com.revature.project0.projectobjects.User;

public class UserToAccountService {

static UserToAccountDAO utaDao = new UserToAccountDAO();
	

	public List<User> getAllLinkedUsers(int iaccountid) {
		return utaDao.findAllLinkedUsers(iaccountid);
	}
	public List<Account> getAllLinkedAccounts(int iuserid) {
		return utaDao.findAllLinkedAccounts(iuserid);
	}
	public void saveUserToAccount(User a, Account b) {
		utaDao.save(a, b);
	}
	public void deleteUserToAccount(User a, Account b) {
		utaDao.delete(a, b);
	}
	
}
