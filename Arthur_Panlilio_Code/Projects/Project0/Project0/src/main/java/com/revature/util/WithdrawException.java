package com.revature.util;

/**
 * An exception that thrown when a
 * user tries to withdraw more than the 
 * account has
 * 
 * @author Arthur Panlilio
 *
 */
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
