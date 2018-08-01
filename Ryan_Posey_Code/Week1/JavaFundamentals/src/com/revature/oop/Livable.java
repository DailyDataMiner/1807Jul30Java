package com.revature.oop;

public interface Livable {
	// abstract and public keyword is implicit in interfaces\
	// only keywords allowed are public, abstract, default, static
	void breathe();
	void consume();
	void excrete();
	
	default void stayinAlive() {
		System.out.println("ha ha ha ha stayin aliiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiive");
	}
	
}
