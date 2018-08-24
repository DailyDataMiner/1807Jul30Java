package com.rev.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.rev.pojos.User;

public class DummyUserService {
	static ArrayList<User> users = new ArrayList<User>();

	static {
		users.add(new User("Gin", "admin"));
		users.add(new User("Isa", "<3"));
	}

	public ArrayList<User> getUsers() {
		return users;
	}

	public User getByUsername(String name) {
		return users.stream().filter(u -> {
			return u.getUsername().equals(name);
		}).findAny().orElse(null);
	}
}
