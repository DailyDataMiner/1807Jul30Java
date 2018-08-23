package com.ex.main;

public class AccessMain {
	
	
	
	public static void main(String[] args) {
		//Child class
		AccessModifierClassChild a = new AccessModifierClassChild();
		//Can access public, default, and protected methods
		a.defaultMethod();
		a.protectedMethod();
		a.publicMethod(); //Will execute the private method in superclass via public method
	
		//Subclass does not have access to private method from superclass
		a.privateMethod();
	}

}











