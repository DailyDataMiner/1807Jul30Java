package com.rev.service;

import java.util.ArrayList;

import com.rev.pojos.User;

public class DummyUserService {

	static ArrayList<User> users = new ArrayList<User>();
	{
		users.add(new User("Michael", "admin"));
		users.add(new User("Michael1", "123"));
		users.add(new User("Michaela", "abc"));
	}
	
	public ArrayList<User> getUsers() {
		return users;
	}
	
	//stream magic
	public User getByUsername(String name) {
		User u = users.stream().filter(x -> x.getUsername().equals(name)).findAny().orElse(null);
		return u;
	}
}
