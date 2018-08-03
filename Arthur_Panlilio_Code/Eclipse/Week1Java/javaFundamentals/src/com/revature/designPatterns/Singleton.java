package com.revature.designPatterns;

public class Singleton {
	
	private static Singleton INSTANCE;
	private String info = "Initial info class";
	
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
