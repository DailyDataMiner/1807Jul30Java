package com.revature.oop;

public class Dog extends Animal {

	@Override // forces the method to override method from parent class of same name
	public void breathe() {
		System.out.println("breathing");
		
	}

	@Override
	public void consume() {
		System.out.println("eating");
		
	}

	@Override
	public void excrete() {
		System.out.println("poop poop");
	}

}
