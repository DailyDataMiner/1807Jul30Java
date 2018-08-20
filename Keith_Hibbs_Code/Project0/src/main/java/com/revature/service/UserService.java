package com.revature.service;

import java.sql.SQLException;
import java.util.List;

import com.revature.dao.AccountDao;
import com.revature.dao.UsersDao;
import com.revature.main.app;
import com.revature.pojos.Account;
import com.revature.pojos.Users;

public class UserService {
	
	static UsersDao ud = new UsersDao();
	static Users u = new Users();
	static AccountDao ad = new AccountDao();
	
	
	
	public static void onLoginAfter(String username) {
		
		
		
		Users users = ud.findOneAfter(username);
		System.out.println(users.getfName());
		ad.findAccounts(username);

		}
	public static Users onLogin(String username, String password) throws SQLException {
		
			Users users = ud.findOne(username, password);
			if (users==null) {
				System.out.println("User not found");
app.menu1();			
			}
			
			

			return users;
	}
	public static void onDelete(String username, String password) throws SQLException {
		
		ud.deleteOne(username, password);
		
	}

}
