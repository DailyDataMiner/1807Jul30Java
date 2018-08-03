package com.revature.designPatterns;

public class LazySingleton {
	
	private static LazySingleton instance;
	
	private LazySingleton() {
		System.out.println("Instantiating singleton");
	}
	
	public static LazySingleton getInstance() {
		if(instance == null) {
			instance = new LazySingleton();
		}
		return instance;
	}
	
	public void test() {
		System.out.println("I AM LAZY " + instance);
	}
	
	

}
