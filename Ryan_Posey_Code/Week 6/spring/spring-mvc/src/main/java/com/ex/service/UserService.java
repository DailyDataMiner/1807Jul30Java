package com.ex.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ex.beans.User;

@Service
public class UserService {

	// mock service layer. would talk to dao.
	static ArrayList<User> users = new ArrayList<User>();
	
	static {
		users.add(new User("Ryan", "123", "I am awesome"));
		users.add(new User("Genesis", "pass", "I am a trainer"));
	}
	
	public List<User> getAll() {
		return users;
	}
	
	public User login(String username, String password) {
		Optional<User> user = users.stream().filter(u -> 
			u.getName().equalsIgnoreCase(username)).findFirst();
		
		if(user.isPresent()) {
			if(user.get().getPassword().equals(password)) {
				return user.get();
			}
		}
		return null; //wrong credentials
	}
}