package com.revature.project0.myexceptions;

public class UsernameTakenException extends BankExceptions {

	public UsernameTakenException () {
		super("This username is already taken.");
	}
	
}
