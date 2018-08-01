package com.revature.oop;

public interface Livable {
// every thing is implicitly abstract
	void breate();
	void consume();
	void exrcete();

	default void stayinAlive() {
		System.out.println("Ha ha ha ha stayin aliiiiiiiive");
	}
}
