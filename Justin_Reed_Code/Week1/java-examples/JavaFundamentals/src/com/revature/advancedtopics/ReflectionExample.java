package com.revature.advancedtopics;

import java.time.LocalDateTime;

public class ReflectionExample {
	
	private String name;
	private int id;
	private LocalDateTime todaysTime;
	
	
	public static void main(String[] args) {
		
//		StringBuilder sb;
//		for(int i = 0; i <100; i++) {
//			sb = new StringBuilder("test" + i);
//			System.out.println(sb);
//		}
		
		Runtime run = Runtime.getRuntime();
		System.out.println("Free memory: "+ run.freeMemory() + "bytes");
		System.out.println("Max Memory: "+ run.maxMemory()+ "bytes");
		System.out.println("Total memory: "+ run.totalMemory()+ "bytes");
		
		ReflectionExample re = new ReflectionExample();
		
		System.out.println("get Class: "+ re.getClass().getName());
		System.out.println("Class name: "+ re.getClass().getCanonicalName());
		System.out.println("Super: "+ re.getClass().getSuperclass());
		
	}
	
	public ReflectionExample() {
		
	}


	public ReflectionExample(String name, int id, LocalDateTime todaysTime) {
		super();
		this.name = name;
		this.id = id;
		this.todaysTime = todaysTime;
	}
	
	
	

}
