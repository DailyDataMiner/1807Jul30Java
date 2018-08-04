package com.revature.designpatterns;

import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		//SINGLETION DEMO
//		Singleton s = Singleton.getInstance();
//		s.name = "first instance";
//		
//		Singleton s2 = Singleton.getInstance();
//		s2.name = "second instance";
//		
//		System.out.println(s.name);
//		System.out.println(s2.name);
//		System.out.println(s == s2);
//		
//		s = null;
//		s2 = null;
//		Singleton s3 = Singleton.getInstance();
//		System.out.println(s3.name);
//		
//		LazySingleton lazy = LazySingleton.getInstance();
//		lazy.test();
//		LazySingleton lazy2 = LazySingleton.getInstance();
		
		//FACTORY DEMO
		/*
		 * instantiate an objet without exposing creation logic to the client
		 * refer to the newly created object using common interface
		 */
		
		System.out.println("Hey Bob! What tool would you like to use?");
		Scanner scan = new Scanner(System.in);
		String tool = scan.nextLine();
		Tool t = ToolFactory.instantiate(tool);
		System.out.println(t.work());
		System.out.println(t.getClass());
		
		
	}

}
