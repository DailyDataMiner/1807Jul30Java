package com.revature.service;

import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;

import com.revature.dao.UserDAO;
import com.revature.pojo.User;

public class UserService {
	
	private UserDAO uDao = new UserDAO();
	
	public List<User> getAll(){
		List<User> users =  uDao.findAll();
		return users;
	}
	
	public User find(String username) {
		User u = uDao.findOne(username);
		return u;
	}
	
	public User find(int id) {
		User u = uDao.findOne(id);
		return u;
	}
	
	/*public boolean checkLogin(String username, String password) {
		User u = uDao.findOne(username);
		return u.getPassword().equals(password);
	}*/
	
	public String getRole(User u) {
		if(u!=null) {
		return uDao.findRole(u.getRoleId());
		} else {
			return "";
		}
	}
	
	public User addUser(User u) {
		u.setPassword(cipher(u.getPassword(),u.getUsername()));
		return uDao.save(u);
	}
	
	public boolean checkLogin(String pass, User u) {
		return cipher(pass,u.getUsername()).equals(u.getPassword());
	}
	
	public String cipher(String pwd, String salt) {
        return DigestUtils.sha256Hex(pwd+salt);
    }

}
