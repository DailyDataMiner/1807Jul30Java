package com.revature.oop;

public class Dog extends Animal {

	@Override
	public void breathe() {
		System.out.println("dogs breathe");
		
	}

	@Override
	public void consume() {
		System.out.println("dogs eat dog food");
		
	}

	@Override
	public void excrete() {
		System.out.println("dogs poop");
		
	}

	
}
