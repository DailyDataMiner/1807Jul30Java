package com.revature.advancedtopics;

import java.time.LocalDateTime;

public class ReflectionExample {
	/*
	 * java reflection makes it possible to inspect 
	 * classes, interfaces, fields, and methods at
	 * runtime without knowing the name of the class,
	 * method, etc
	 * It also makes it possible to instantiate new objects
	 * invoke methods, and get/set fields
	 */
	
	private String name;
	private int id;
	private LocalDateTime todaysTime;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDateTime getTodaysTime() {
		return todaysTime;
	}

	public void setTodaysTime(LocalDateTime todaysTime) {
		this.todaysTime = todaysTime;
	}
	
	public ReflectionExample() {
		super();
	}
	
	public ReflectionExample(String name, int id, LocalDateTime todaysTime) {
		super();
		this.name = name;
		this.id = id;
		this.todaysTime = todaysTime;
	}

	public static void main(String[] args) {
		Runtime run = Runtime.getRuntime();
		
		System.out.println("bytes of free memory: " + run.freeMemory());
		System.out.println("bytes of max memory: " + run.maxMemory());
		System.out.println("bytes of total memory: " + run.totalMemory());
		
		ReflectionExample re = new ReflectionExample();
		System.out.println("class name: " + re.getClass());
		System.out.println("canonical class name: " + re.getClass().getCanonicalName());
		System.out.println("superclass name: " + re.getClass().getSuperclass());

	}

}
