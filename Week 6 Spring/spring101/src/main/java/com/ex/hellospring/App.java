package com.ex.hellospring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		
		//Wrong! NOT USING SPRING
		HelloWorld hello = new HelloWorld();
		System.out.println(hello.getMessage());

		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		HelloWorld world = (HelloWorld) context.getBean("thisIsABean");
		System.out.println(world.getMessage());
		world.setMessage("Message Changed");
		System.out.println(world.getMessage());
		//System.out.println(context);
		
		
		DependentBean d = (DependentBean) context.getBean("dependent");
		System.out.println(d.getHello().getMessage());
		
	}

}
