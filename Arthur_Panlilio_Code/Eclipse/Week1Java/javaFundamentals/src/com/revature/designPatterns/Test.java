package com.revature.designPatterns;


import java.util.Scanner;

import com.revature.designPatterns.FactoryClasses.Dragon;

public class Test {

	public static void main(String[] args) {
		//Singleton demonstration
		Singleton single = Singleton.getInstance();
		System.out.println(single.getInfo());
		Singleton single2 = Singleton.getInstance();
		single2.setInfo("New class info");
		System.out.println(single.getInfo());
		single = null;
		single2 = null;
		Singleton single3 = Singleton.getInstance();
		System.out.println(single3.getInfo());
		
		LazySingleton lazy = LazySingleton.getInstance();
		lazy.test();
		LazySingleton lazy2 = LazySingleton.getInstance();
		lazy.test();
		
		//Factory dem
		//Here we will instantiate an object without exposing creation logic to the client. we refer
		//to the newly created object using a common interface
		/*
		Dragon blue = Factory.getDragon("ice");
		blue.breathe();
		Dragon red = Factory.getDragon("fire");
		red.breathe();
		Dragon yellow = Factory.getDragon("lightning");
		yellow.breathe();
		*/
		System.out.println("Hey bob, what tool you want?");
		Scanner s = new Scanner(System.in);
		String tool = s.nextLine();
		Tool t = ToolFactory.instantiate(tool);
		System.out.println(t.work());

	}

}
