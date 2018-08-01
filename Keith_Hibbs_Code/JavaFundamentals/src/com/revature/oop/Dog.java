package com.revature.oop;

public class Dog extends Animal{

	@Override
	public void breate() {
System.out.println("dogs breathe");		
	}

	@Override
	public void consume() {
		System.out.println("Dogs eat anything");
	}

	@Override
	public void exrcete() {
System.out.println("Dogs poop everywhere");		
	}

}
