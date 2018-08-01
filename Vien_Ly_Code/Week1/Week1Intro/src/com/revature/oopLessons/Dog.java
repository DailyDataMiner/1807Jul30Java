package com.revature.oopLessons;

public class Dog extends Animal{

	@Override
	public void breathe() {
		System.out.println("dog breathes, woof");
	}

	@Override
	public void consume() {
		System.out.println("dog eats food");
	}

	@Override
	public void excrete() {
		System.out.println("dog poops");
	}

}
