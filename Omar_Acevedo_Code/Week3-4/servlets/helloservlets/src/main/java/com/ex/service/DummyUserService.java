package com.ex.service;

import java.util.ArrayList;
import java.util.function.Predicate;

import com.ex.pojos.User;


public class DummyUserService extends User {

	static ArrayList<User> users = new ArrayList<User>();
	{
		users.add(new User("Omar", "password"));
		users.add(new User("Ramo", "drowssap"));
		users.add(new User("Oram", "d5r4o3w2s1s0ap"));
	}
	
	public ArrayList<User> getUsers() {
		return users;
	}
	
	public User getByUsername(String name) {
		
//		User u = users.stream().filter( u -> u.getUsername().equals(name)).findFirst().get();
//		User un = users.stream().filter( u -> u.getUsername().equals(name)).findFirst().get();
		User un = users.stream().filter( u -> u.getUsername().equals(name)).findAny().orElse(null);
		
		return un;
	}
	
}
