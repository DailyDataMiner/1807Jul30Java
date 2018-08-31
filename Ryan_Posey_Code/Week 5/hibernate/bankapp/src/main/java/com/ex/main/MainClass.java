package com.ex.main;

import com.ex.data.UserRepository;
import com.ex.models.User;

public class MainClass {
	public static void main(String[] args) {
		UserRepository repo = new UserRepository();
		
//		User u = new User();
//		
//		u.setFirstname("Ryan");
//		u.setLastname("Posey");
//		u.setUsername("rkposey");
//		u.setPassword("rkposey86");
//		
//		repo.save(u);
		
		System.out.println(repo.findByUsername("Ryan"));
	}
}
