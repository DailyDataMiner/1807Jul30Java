package com.revature;

public interface Livable {
	
	//abstract and public keyword is implicit in interfaces
	// only keywords allowed are public abstract default static strictfp 
	void breathe();
	void consume();
	void excrete();
	
	default void stayinAlive() {
		System.out.println("ha ha ha ha stayin aliiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiive");
	}

}
