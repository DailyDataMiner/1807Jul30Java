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
	
	//call Dao and call UserDaoImplement newUser() 
	//to insert data into DB as new user.
	public static void createNewBankUser(int user_id, String first_name, String last_name, String username, String password) {
		
	    UserDaoImplement.getDao().newUser(user_id, first_name, last_name, username, password);
		
	}
	
	
	/*
	 * call Daoimplement's updatePassword() method
	 * */
	public static void updatePassword(int user_id, String password) {
	    UserDaoImplement.getDao().updatePassword(user_id,  password);
	}
	
	/*
	 * delete user
	 * */
	public static void deleteUser(int user_id) {
	    UserDaoImplement.getDao().deleteUser(user_id);
	}
	
	/*
	 * get specific user from userName and password
	 * */
	public static BankUser getUserWithUsernamePassword(String userName, String passWord) {
	    return UserDaoImplement.getDao().getSpecificUser(userName, passWord);
	}
	
	/*
	 * get list of user name
	 * */
	public static String[]  userNameList() {
		return UserDaoImplement.getDao().existingUsernameList();
		
	}
	
	/*
	 * get total user number
	 * */
	public static int  getTotalUserNumberService() {
		return UserDaoImplement.getDao().getTotalUserNumberDao();
		
	}
	
	public static BankUser getUserWithUserNamePassWord(String user_name, String pass_word) {
		// TODO Auto-generated method stub
		return UserDaoImplement.getDao().getSpecificUser(user_name, pass_word);
	}
	
	 
}
