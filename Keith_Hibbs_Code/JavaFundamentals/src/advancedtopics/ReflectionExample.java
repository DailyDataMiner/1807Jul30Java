package advancedtopics;

import java.time.LocalDateTime;

public class ReflectionExample {
/*
 * Java Reflection makes it possible to inspect classes, interfaces, fields, and methods at runtime eithout knowing the name of the class, method etc.
 * 
 * It also makes it possible to instantiate new objecrs, invoke methods, and get/set fields
 */
	private String name;
	private int id;
	private LocalDateTime todaysTime;
public static void main(String[] args) {
	Runtime run = Runtime.getRuntime(); //127611672
//	for (int i = 0 ; 1<100;i++) {
//		Stringbuilder sb = new StringBuilder("test" + i);
//		
//	}
	System.out.println("Free memoryL " + run.freeMemory());
	System.out.println("Maximum Memory: " + run.maxMemory());
	System.out.println("Total memory: " + run.totalMemory());

ReflectionExample re = new ReflectionExample();
System.out.println("Class name: " + re.getClass().getCanonicalName()););
System.out.println("Super class: " + re.getClass().getSuperclass());
}
public ReflectionExample(String name, int id, LocalDateTime todaysTime) {
	super();
	this.name = name;
	this.id = id;
	this.todaysTime = todaysTime;
}
}
