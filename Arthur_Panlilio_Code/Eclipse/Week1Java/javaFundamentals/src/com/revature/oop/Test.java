package com.revature.oop;

public class Test {

	public static void main(String[] args) {
		Dog d = new Dog();
		System.out.println(d.className);
		System.out.println(((Animal)d).className);
		((Animal)d).consume();
		d.stayinAlive();
		
		Cat c = new Cat();
		c.consume();

	}

}
