package com.revature.q18;

/**
 * subclass that holds methods from superclass
 * 
 * @author Arthur Panlilio
 *
 */
public class SubClassQuestion extends SuperClassQuestion {
	
	/**
	 * uses the ascii table to check if uppercase
	 * 
	 */
	@Override
	public boolean ifUpper(String s) {
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) < 97 && s.charAt(i) > 64) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Converts to lowercase
	 */
	@Override
	public String toLower(String s) {
		return s.toLowerCase();
	}
	

	/**
	 * converts to int and adds 10
	 */
	@Override
	public void toInt(String s) {
		int x = Integer.parseInt(s);
		System.out.println(x + 10);
		
	}



}
