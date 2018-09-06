package com.ex.lifecycle;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	
	public static void main(String[] args) {
		//should only be used to expose lifecycle. not pratical
		AbstractApplicationContext = new ClassPathXmlApplicationContext("beans.xml");
		Life life = (Life) context.getBean("Life");
		Life.live();
		context.close();
	}

}
