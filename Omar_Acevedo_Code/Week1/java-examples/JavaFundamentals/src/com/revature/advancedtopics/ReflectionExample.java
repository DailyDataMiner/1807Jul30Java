package com.revature.advancedtopics;
import com.revature.helpers.HelperFunctions;

import java.time.LocalDateTime;

public class ReflectionExample extends HelperFunctions {

	/**
	 * Java Reflection makes it possible to inspect
	 * classes, interfaces, fields, and methods at
	 * runtime without knowing the name of the class,
	 * method, etc.
	 * It also makes it possible to instantiate new
	 * objects, invoke methods, and get/set fields
	 * @param args
	 */
	private String name;
	private int id;
	private LocalDateTime todaysTime;
	
	public ReflectionExample() {}
	public ReflectionExample(String name, int id, LocalDateTime todaysTime) {
		super();
		this.name = name;
		this.id = id;
		this.todaysTime = todaysTime;
	}

	public static void main(String[] args) {
		
		Runtime run = Runtime.getRuntime();
		for (int i = 0; i<100; i++) {
			Object o = new Object();
		}
		
		print("Free memory: " + run.freeMemory() + " bytes");
		print("Maximum memory: " + run.maxMemory() + " bytes");
		print("Total memory: " + run.totalMemory() + " bytes");
		
		ReflectionExample re = new ReflectionExample();
		print("Class Name: " + re.getClass());
		print("Class Canonical Name: " + re.getClass().getCanonicalName());
		print("Super Class Name: " + re.getClass().getSuperclass());
		
	}

}
