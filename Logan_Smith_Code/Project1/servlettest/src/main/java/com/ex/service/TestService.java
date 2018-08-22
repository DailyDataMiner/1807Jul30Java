package com.ex.service;

import java.util.ArrayList;

import com.ex.pojos.User;

public class TestService {

	static ArrayList<User> users = new ArrayList<User>();
	{
		users.add(new User("Logan", "Pug"));
		users.add(new User("Slug", "World"));
		users.add(new User("Brian", "Bumblebee"));
	}
	
	public ArrayList<User> getUsers(){
		return users;
	}
	public User getByUsername(String name) {
		User u = users.stream().filter(x -> x.getUsername().equals(name)).findAny().orElse(null);
		return u;
	}
}
