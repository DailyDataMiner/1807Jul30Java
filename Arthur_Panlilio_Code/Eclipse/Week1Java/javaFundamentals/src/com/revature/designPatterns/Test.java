package com.revature.designPatterns;


import com.revature.designPatterns.FactoryClasses.Dragon;

public class Test {

	public static void main(String[] args) {
		Singleton single = Singleton.getInstance();
		System.out.println(single.getInfo());
		Singleton single2 = Singleton.getInstance();
		single2.setInfo("New class info");
		System.out.println(single.getInfo());
		
		
		Dragon blue = Factory.getDragon("ice");
		blue.breathe();
		Dragon red = Factory.getDragon("fire");
		red.breathe();
		Dragon yellow = Factory.getDragon("lightning");
		yellow.breathe();

	}

}
