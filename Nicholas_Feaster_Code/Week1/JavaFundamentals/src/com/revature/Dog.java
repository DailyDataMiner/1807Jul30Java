package com.revature;

public class Dog extends Animal {

	@Override
	public void breathe() {
		// TODO Auto-generated method stub
		System.out.println("dogs breathe. woof");
	}

	@Override//forces the method to override method from parent class of the same names
	public void consume() {
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public void excrete() {
		// TODO Auto-generated method stub
		System.out.println("Dogs poop everywhere and mark their territory");
	}

}
