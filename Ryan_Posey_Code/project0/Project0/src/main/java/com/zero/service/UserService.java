package com.zero.service;

import java.util.List;

import com.zero.dao.Dao;
import com.zero.dao.UserDao;
import com.zero.pojos.User;

public class UserService extends UserDao {
	
	static Dao<User, Integer> uDao = new UserDao();
	
	public List<User> getUsers() {
		return uDao.findAll();
	}
	
	public User getUser(Integer id) {
		return uDao.findOne(id);
	}
	
	public User addUser(User u) {
		return uDao.save(u);
	}
	
}
