package com.ex.hellospring;

public class HelloWorld {
	
	private String message;
	
	public HelloWorld() {
		System.out.println("IN NO ARGS COMNSTRUCTOR");
	}

	public HelloWorld(String message) {
		super();
		this.message = message;
		System.out.println("IN MESSAGE CONSTRUCTOR");
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
		System.out.println("IN setMessage()");
	}

}
