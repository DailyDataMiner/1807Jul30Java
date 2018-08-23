package com.ex.main;

public class AccessModifierClass {
	

	
	public void publicMethod() {
		privateMethod();
	}
	
	protected int protectedMethod() {
		return 0;
	}
	
	void defaultMethod() {
		
	}
	
	private void privateMethod() {
		System.out.println("private method");
	}

}












