package com.ex.main;

import com.ex.data.UserRepository;
import com.ex.models.User;

public class MainClass {

	public static void main(String[] args) {
		UserRepository repo = new UserRepository();
		
		User u = new User();
		u.setFirstname("Log");
		u.setLastname("Smi");
		u.setUsername("puglord");
		u.setPassword("Tori96");
		
		repo.save(u);
	}
	
}
