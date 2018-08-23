package com.ex.main;

public class AccessModifierClassChild extends AccessModifierClass {
	
	
	//Overriding a method and declaring a more restricted access modifier is not allowed
	@Override
	private void publicMethod() {
		privateMethod();
	}	
	
	@Override
	default int protectedMethod() {
		return 0;
	}
	
	@Override
	protected void defaultMethod() {
		
	}
	
	@Override
	private void privateMethod() {
		System.out.println("private method");
	}
}





