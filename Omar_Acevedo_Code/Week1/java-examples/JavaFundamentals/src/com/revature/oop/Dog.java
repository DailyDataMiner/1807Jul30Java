package com.revature.oop;


public class Dog extends Animal {

	@Override
	public void breathe() {
		// TODO Auto-generated method stub
		print("Dog is breathing");
	}

	@Override
	public void consume() {
		// TODO Auto-generated method stub		
		print("Dog is consuming");
	}

	@Override
	public void excrete() {
		// TODO Auto-generated method stub
		print("Dog poops");
	}
		
}
