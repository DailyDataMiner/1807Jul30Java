package com.revature.oop;

public class Dog extends Animal {

	String className = "Dog";
	
	@Override
	public void breathe() {
		System.out.println("Dogs breathe.");
		
	}

	@Override // Forces override. Not necessary in most situations
	public void excrete() {
		System.out.println("Dogs poop");
		
	}

	public void consume () {
		System.out.println("Dogs eat things.");
	}
	
	
}
