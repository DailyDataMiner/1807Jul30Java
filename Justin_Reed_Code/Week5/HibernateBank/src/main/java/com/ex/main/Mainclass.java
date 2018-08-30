package com.ex.main;

import com.ex.data.UserRepository;
import com.ex.models.User;

public class Mainclass {
	
	public static void main(String[] args) {
		UserRepository repo = new UserRepository();
		
		
		User u = new User();
		u.setFirstName("Bri");
		u.setLastName("Jay");
		u.setUsername("Brijay");
		u.setPassword("1234");
		
		repo.save(u);
		
	}

}
