package com.ex.hellospring;

public class HelloWorld {
	
	private String message;

	public HelloWorld(String message) {
		super();
		this.message = message;
		System.out.println("In message constructor");
	}
	
	public HelloWorld() {
		System.out.println("In no args constructor");
	}

	public String getMessage() {
		return message;
		
	}

	public void setMessage(String message) {
		System.out.println("In setMessage()");
		this.message = message;
	}
	
	

}
