package com.ex.main;

import com.ex.data.AccountRepository;
import com.ex.data.UserRepository;
import com.ex.models.Account;
import com.ex.models.User;

public class MainClass {

	public static void main(String[] args) {
		
		UserRepository repo = new UserRepository();
		AccountRepository aRepo = new AccountRepository();
		
		User user = new User();
		user.setFirstName("Omar");
		user.setLastName("Acevedo");
		user.setUsername("omarace");
		user.setPassword("mypassword");
		
		repo.save(user);
		
		Account account = new Account();
		account.setName("Omar-Account");
		account.setBalance(780);
		account.setOwner(user);
		
		aRepo.save(account);
		
	}
	
}
