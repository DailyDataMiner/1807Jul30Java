package com.revature.designpatterns;
import com.revature.helpers.HelperFunctions;

public class LazySingleton extends HelperFunctions {
	
	// Only declaration NOT instantiation
	private static LazySingleton instance;
	
	private LazySingleton() {}
	
	public static LazySingleton getInstance() {
		if (instance == null) {
			instance = new LazySingleton();
		}
		return instance;
	}
	
	public void test() {
		print(this.getClass());
	}
	
}
