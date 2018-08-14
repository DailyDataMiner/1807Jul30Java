package com.bank.userinteractions;

import static java.lang.System.in;

import java.util.Scanner;

import com.bank.daos.UserDao;
import com.bank.pojos.User;
import com.bank.utils.HelperFunctions;

public class UserUI extends HelperFunctions {

	private static UserDao userDao = null;
	private static User userObj = null;
	private static Scanner readFromUser = null;
	
	public static User display() {

//		boolean _success = false;
		
		print(" CREATE A USER PROFILE ");
		
		userDao = new UserDao();
		userObj = new User();
		readFromUser = new Scanner(in);
		
		String _un;
		String _pw;
		String _email;
		int _personid = 0;
		
		print("	  USERNAME: ");
		_un = readFromUser.next();
		
		print("	  PASSWORD: ");
		_pw = readFromUser.next();
		
		print("	  EMAIL: ");
		_email = readFromUser.next();
		
		userObj.setUsername(_un);
		userObj.setPassword(_pw);
		userObj.setEmail(_email);
		userObj.setPersonid(_personid);
		
		//	Here we pass the user object with all the info. and pass everything to the db. (insert)
		userObj = userDao.create(userObj);
		print("  User (" + userObj.getUsername() + ") was successfully created.");
		
//		userObj = null;
//		_success = true;
		
		return userObj;
		
	}
	
	public static User logIn() {
		
		userDao = new UserDao();
		userObj = new User();
		readFromUser = new Scanner(in);
		int _canLogIn = 0;
		int _userId = 0;
		int[] _loginInfo;
		
		print("  LOG IN: \n - Enter your credentials -");
		print("  UserName: ");
		
		String _username;
		_username = readFromUser.next();
		
		print("  Password: ");
		String _password;
		_password = readFromUser.next();
		
		
		//	Get login info (success flag and userid) from db.
		_loginInfo 	= userDao.login(_username, _password);
		_canLogIn 	= _loginInfo[0];
		_userId 	= _loginInfo[1];
		
		
		//	Verify if user exists
		if (_canLogIn == 1) {
			
			userObj.setUserid(_userId);
			userObj.setUsername(_username.toLowerCase());
			
		} else {
			
			print("_canLogIn -> " + _canLogIn);
			userObj.setUserid(0);
			
		}
		
		return userObj;
		
	}
	
}
