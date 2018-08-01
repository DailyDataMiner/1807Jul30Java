package com.revature.oop;

public class Dog extends Animal {

	String className = "Dog";
	@Override // forces method to override method from parent class
	public void breathe() {
		// TODO Auto-generated method stub
		System.out.println("Pant pant pant");
	}

	@Override
	public void consume() {
		// TODO Auto-generated method stub
		System.out.println("dog nom nom nom");
	}

	@Override
	public void excrete() {
		// TODO Auto-generated method stub
		System.out.println("dog fart noise");
	}
	
}
