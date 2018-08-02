package com.revature.oopLessons;

import java.util.HashMap;
import java.util.Map;

public class Driver {

	public static void main(String[] args) {
		Dog d = new Dog();
		d.consume();
		d.stayinAlive();
		
		int x = 5;
		if (x++ == 5) {
			System.out.println("asd");
		}
		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	}

}
