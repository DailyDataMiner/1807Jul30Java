package com.revature.oop;

public class Main {

	public static void main(String[] args) {
		Animal a = new Animal(95123);
		a.eat();
		System.out.println();
		Dog d = new Dog("Dogbert", 21);
		d.eat();
		d.bark();
		System.out.println();
		Cat c = new Cat("Gar",-2);
		c.eat();
		c.meow();

	}

}
