package com.revature.designpatterns;

import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		
		
		//Singleton Example
		/*
		Singleton s = Singleton.getInstance();
		s.name = "first instance";
		
		Singleton s2 = Singleton.getInstance();
		s2.name = "second 'instance'";
		
		System.out.println(s.name);
		System.out.println(s2.name);
		System.out.println(s == s2);
		
		s = null;
		s2 = null;
		Singleton s3 = Singleton.getInstance();
		System.out.println(s3.name);
		
		LazySingleton lazy = LazySingleton.getInstance();
		lazy.test();
		LazySingleton lazy2 = LazySingleton.getInstance();
		lazy2.test();
		*/
		
		Singleton.test();
		LazySingleton.test();
		
		//Factory example
		/*
		 * Here, we will instantiate an object without exposing creation logic
		 */
		
		System.out.println("Hey Bob! What tool would you like to build with?");
		Scanner scan = new Scanner(System.in);
		String tool = scan.nextLine();
		
		Tool t = ToolFactory.instantiate(tool);
		System.out.println(t.work());
		System.out.println(t.getClass());
	}

}