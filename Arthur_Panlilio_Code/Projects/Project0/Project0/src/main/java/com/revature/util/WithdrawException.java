package com.revature.util;

public class WithdrawException extends Throwable{
	
	private static final long serialVersionUID = 1L;
	
	private double amount;
		
	public WithdrawException(double amount){
		this.amount = amount;
	} 
	public double getAmount(){
      return amount;
	}

}
