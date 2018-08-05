package com.revature.q18;

public class SubClass extends SuperClass {

	public static void main(String[] args) {
		
		SubClass sc =  new SubClass();
		sc.checkUpper("Sub");
		sc.convertUpper("SuperCLass");
		sc.convertInt("10");
		
		
	}

	// checks for upper case using regex
	public boolean checkUpper(String Char) {

		if (Char.matches("(?s).*[A-Z].*")){
			System.out.println("true");
			return true;
		}
		
		System.out.println("false");
		return false;
	}

	//converts string to uppercase using toUpperCase()
	public String convertUpper(String Char) {
		Char = Char.toUpperCase();
		System.out.println(Char);
		return Char;
	}

	//converts string to int and adds 10
	public int convertInt(String Char) {
		int CharI = Integer.parseInt(Char);
		CharI += 10;
		System.out.println(CharI);
		return CharI;
	}
	
}
