package com.revature.intro;

public class VariableScopes {
	
	int age; 
	String name; 
	static int count = 0;
	

	public VariableScopes() {
		count++;
	}
	
	public static void main(String[] args) {
		
		Integer num = new Integer(5);
		Integer x = new Integer(159109);
		System.out.println(num.MAX_VALUE == x.MAX_VALUE);
		
		VariableScopes s = new VariableScopes();
		s.age = 12;
		s.test();
		doThings();
	}
	
	static void doThings() {
		
	}
	
	void test() {
		doThings();
	}

}