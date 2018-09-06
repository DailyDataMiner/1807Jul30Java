package com.ex.hellospring;

public class DependentBean {
	
	private HelloWorld hello;

	public DependentBean() {
		super();
	}

	public HelloWorld getHello() {
		return hello;
	}

	public void setHello(HelloWorld hello) {
		this.hello = hello;
	}
	

}
