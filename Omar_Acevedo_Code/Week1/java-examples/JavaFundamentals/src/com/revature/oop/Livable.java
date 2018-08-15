package com.revature.oop;

public interface Livable {
	
	// abstract keyword is implicit in interfaces
	// only keywords allowed are public abstract default static strictfp
	abstract void breathe();
	void consume();
	void excrete();
	
	default void stayingAlive() {
		System.out.println("Staying alive!!!");
	}
	
}