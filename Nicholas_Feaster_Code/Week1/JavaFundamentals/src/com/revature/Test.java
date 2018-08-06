package com.revature;

import com.revature.classbasics.StaticStuff;

public class Test {

	public static void main(String[] args) {
		Dog d = new Dog();
		d.consume();
		d.breathe();
		d.excrete();
		Cat c = new Cat();
		c.consume();
		
		//while(true) {};//Invalid code it is unreachable code and will not compile
		
		StaticStuff stuff = new StaticStuff();
		//stuff.instanceStuff();
	}

}
