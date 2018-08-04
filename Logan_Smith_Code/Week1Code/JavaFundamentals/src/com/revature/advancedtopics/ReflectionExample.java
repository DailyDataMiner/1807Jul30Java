package com.revature.advancedtopics;

import java.time.LocalDateTime;

public class ReflectionExample {

	private String name;
	private int id;
	private LocalDateTime todaysTime;

	public ReflectionExample() {

	}

	public ReflectionExample(String name, int id, LocalDateTime todaysTime) {
		super();
		this.name = name;
		this.id = id;
		this.todaysTime = todaysTime;
	}

	public static void main(String[] args) {

		Runtime run = Runtime.getRuntime();
		System.out.println("Free memory: " + run.freeMemory());
		System.out.println("Maximum memory: " + run.maxMemory());
		System.out.println("Total memory: " + run.totalMemory());
		
		ReflectionExample re = new ReflectionExample();
		System.out.println("Class name: " + re.getClass().getCanonicalName());
		System.out.println("Superclass: " + re.getClass().getSuperclass());
	}

}
