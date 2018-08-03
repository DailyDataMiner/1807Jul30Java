package com.revature.designPatterns;

public class Singleton {
	
	private static Singleton INSTANCE = new Singleton();
	
	
	private String info = "Initial info class";
	
	/**
	 * SIngleton design pattern
	 * only once instance of this classes allowed to exist
	 * 
	 * 
	 * Private constructor prevents any class from instantiating this
	 */
	private Singleton() {
		
	}
	
	public static Singleton getInstance() {
		if(INSTANCE == null) {
			INSTANCE = new Singleton();
		}
		
		return INSTANCE;
	}
	
	public String getInfo() {
		return info;
	}
	
	public void setInfo(String s) {
		info = s;
	}

}
