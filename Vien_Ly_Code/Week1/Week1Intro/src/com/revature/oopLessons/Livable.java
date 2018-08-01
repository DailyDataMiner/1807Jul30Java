package com.revature.oopLessons;

public interface Livable {
	
	// abstract and public keywords are0implicit in interfaces
	// modifiers allowed: public, abstract, default, static, strict
	abstract void breathe();
	void consume();
	void excrete();
	
	// default modifier to not be abstract
	default void stayinAlive() {
		System.out.println("survival of the fittest");
	}
}
