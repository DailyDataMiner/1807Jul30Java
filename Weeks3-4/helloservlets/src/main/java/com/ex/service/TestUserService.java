package com.ex.service;

import java.util.ArrayList;

import com.ex.pojos.User;

public class TestUserService {
	
	static ArrayList<User> users = new ArrayList<User>();
	{
		users.add(new User("Justin","admin"));
		users.add(new User("George","123"));
		users.add(new User("Bob","456"));
	}
	
	public ArrayList<User> getUsers(){
		return users;
	}
	
	public User getByUsername(String name) {
		User u = users.stream().filter(x -> x.getUsername().equals(name)).findAny().orElse(null);
		return u;
	}

}
