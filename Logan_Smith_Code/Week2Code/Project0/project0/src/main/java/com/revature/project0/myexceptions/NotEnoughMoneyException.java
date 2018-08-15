package com.revature.project0.myexceptions;

public class NotEnoughMoneyException extends BankExceptions {
	
	public NotEnoughMoneyException() {
		super("You do not have enough money.");
	}

}
