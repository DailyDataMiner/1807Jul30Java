package com.revature.oop;

public interface Livable {

	//abstract keyword is implicit in interfaces
	abstract void breathe();
	void consume();
	void excrete();
	
	default void stayinAlive() {
		System.out.println("ha ha ha ha staying aliiiiiiiiiiiiiiiive");
	}
}