package com.revature.designpatterns;

public class Driver {

	public static void main(String[] args) {
		Singleton s = Singleton.getInstance()
s.name = "forst omstamce";
		
		Singleton s2 = Singleton.getInstance()
s2.name = "second 'instance'";

	System.out.println(s.name);
	System.out.println(s2.name);
	System.out.println(s == s2);
	
	s = null;
	s2 = null;
	Singleton s3 = Singleton.getInstance();
	System.out.println(s3.name);
	
	LazySingleton lazy = LazySingleton.getInstance();
	Lazy.test();
	LazySingleton Lazy2 = LazySingleton.getInstance();
	
	}
}
