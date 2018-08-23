package com.ex.main;

public interface AccessInterface {
	
	//Only public (implicit and explicit) fields are allowed
	int implicitlyPublic = 5;
	
	public int explicitlyPublic  = 3;
	
	//Default as an access modifier is not available in interfaces.
	default defaultIsNotAnAccessModifierHere = 2;
	
	protected int protectedInt = 3;
	
	private int privateInt = 4;
	
	
	
	//Only public (implicit and explicit) methods are allowed
	void implicitlyPublicMethod();
	
	public void explicitlyPublicMethod();
	
	protected void protectedMethod();
	
	private void privateMethod();
	
	//Default methods are not the same as default access
	default void defaultMethod() {
		System.out.println("This is an implemented method");
	}
	
	static void staticMethod() {
		System.out.println("This is a static method");
	}

}
