package service;

import Dao.UserDaoImplement;
import model.BankUser;

public class UserService {
	public static UserService userService;
	
	private UserService() {};
	
	public static UserService getUserService() {
		if(userService == null) {
			userService = new UserService();
		}
		return userService;
		
	}
	
	//this method inside service will call the Dao class
	//finally return bankUser info from DB according to given userID
	public static BankUser returnBankUser(int userId) {
		
		//only service class  has direct access to 
		//Daoimplement class without create instance, becoz 
		//Daoimplement is singleton
		return UserDaoImplement.getDao().getUser(userId);
		
	}
	
}
