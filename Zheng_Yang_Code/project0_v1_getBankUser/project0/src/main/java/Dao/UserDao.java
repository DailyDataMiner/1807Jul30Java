package Dao;

import model.BankUser;


//how you are going to talk to the DB
public interface UserDao {
	
	
	//return a bankuser
	public BankUser getUser(int userId);
}
