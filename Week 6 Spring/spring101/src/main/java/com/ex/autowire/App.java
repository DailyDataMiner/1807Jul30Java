package com.ex.autowire;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		

		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		
		Employee me = (Employee) context.getBean("employee");
		me.getDepartment().setName("Training Team");
		
		Department dept = (Department) context.getBean("department");
		System.out.println(dept.getName());
		
		Employee e1 = (Employee) context.getBean("employee");
		e1.setName("Bob");
		e1.getDepartment().setName("Sales");
		
		Employee e2 = (Employee) context.getBean("employee");
		e2.setName("Bfob");
		e2.getDepartment().setName("Salfes");
		
		Employee e3 = (Employee) context.getBean("employee");
		e3.setName("Bofb");
		e3.getDepartment().setName("Sfales");
		
//		getInfo(e1);
	}

	
	
	

}
