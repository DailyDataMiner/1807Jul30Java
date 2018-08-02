package com.revature.oop;

import com.revature.classbasics.StaticStuff;

public class Test {

	public static void main(String[] args) {
		Dog d = new Dog();
		
		((Animal)d).consume();
		
		Cat c = new Cat();
		c.consume();
		
		StaticStuff newstatic = new StaticStuff();
		
		newstatic.staticStuff();

	}

}
