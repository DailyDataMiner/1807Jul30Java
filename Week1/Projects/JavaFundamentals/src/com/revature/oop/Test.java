package com.revature.oop;

public class Test {

	public static void main(String[] args) {
		Dog d = new Dog();
		System.out.println(d.className);
		System.out.println(((Animal)d));
		d.consume();
		((Animal)d).consume();
		d.stayinAlive();
	}

}