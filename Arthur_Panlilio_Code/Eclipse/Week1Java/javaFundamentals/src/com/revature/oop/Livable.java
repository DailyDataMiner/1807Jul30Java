package com.revature.oop;

public interface Livable {
	
	//Abstract is implicit in interface
	//only keywords allowed are public abstract default static strctfp
	void breathe();
	void consume();
	void excrete();
	
 String className ="live!";
	
	//Needs default keyword
	default void stayinAlive() {
		System.out.println("ha ha ha ha stayin aliiiiiiiiiiiiiiiiive");
	}
	
	public static void achoo() {
		System.out.println(className);
	}
}
