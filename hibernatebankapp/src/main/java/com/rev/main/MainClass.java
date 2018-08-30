package com.rev.main;

import com.rev.data.UserRepository;
import com.rev.models.User;

public class MainClass {
	
	public static void main(String[] args) {
		UserRepository repo = new UserRepository();
		
		User u = new User();
		u.setFirstName("thing1");
		u.setLastNamel("thingy");
		u.setUsername("itsusername");
		u.setPassword("password");
		
		repo.save(u);
	}

}
