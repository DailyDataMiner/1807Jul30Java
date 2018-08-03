package com.revature.q18;

public class Main {

	public static void main(String[] args) {
		//creates the subclass 
		SubClassQuestion s = new SubClassQuestion();
		//demonstrates the methods working
		System.out.println(s.ifUpper("Hello!"));
		System.out.println(s.ifUpper("goodbye!"));
		
		System.out.println(s.toLower("AHAHAHAHAHHAA"));
		
		s.toInt("55");
	}

}
