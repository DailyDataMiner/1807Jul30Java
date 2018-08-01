package com.revature.oop;

public class Dog extends Animal {
	
	String className = "Dog";

	@Override
	public void breathe() {
		System.out.println("Dogs breathe woof");

	}
	@Override
	public void consume() {
		System.out.println("Dogs eat everthing");
	}


	@Override
	public void excrete() {
		System.out.println("dogs poop everywhere");

	}

}
