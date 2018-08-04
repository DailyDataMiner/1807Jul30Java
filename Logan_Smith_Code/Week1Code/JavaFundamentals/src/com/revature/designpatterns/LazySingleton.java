package com.revature.designpatterns;

// Lazy Singleton
public class LazySingleton {

	private static LazySingleton instance;
	
	public String name;
	
	private LazySingleton( ) {
		System.out.println("Instantiating singleton");
	}
	
	public static LazySingleton getInstance() {
		if (instance == null) {
			instance = new LazySingleton();
		}
		return instance;
	}
	
	public void test() {
		System.out.println(this.getClass());
	}
}
