package com.revature.designpatterns;

public final class LazySingleton {
	
	// only declare, not instantiated
	private static LazySingleton instance;
	
	public String name;
	
	private LazySingleton() {
		System.out.println("instantiating lazy singleton");
	}
	
	public static LazySingleton getInstance() {
		if(instance == null) {
			instance = new LazySingleton();
		}
		
		return instance;
	}
	
	public void test() {
		System.out.println(this.getClass());
	}
}
