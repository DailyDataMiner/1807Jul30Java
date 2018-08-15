package com.revature.oop;

public interface Liveable {
	
	//abstract keyword is implicitly in interfaces 
	void breathe();
	void consume();
	void excrete();
	
	default void stayinAlive() {
		
		System.out.println();
		
		
	}

}
