package com.ex.lifecycle;

import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContextAware;

public class Life implements InitializingBean,
	DisposableBean, BeanFactoryAware, BeanPostProcessor,
	BeanNameAware, ApplicationContextAware {
	
	private String circleOfLife;

	public Life() {
		System.out.println("no arg constructor of life");
	}

	public Life(String circleOfLife) {
		super();
		this.circleOfLife = circleOfLife;
	}

	public String getCircleOfLife() {
		return circleOfLife;
	}

	public void setCircleOfLife(String circleOfLife) {
		System.out.println("setting properties");
		this.circleOfLife = circleOfLife;
	}
	
	public void live() {
		System.out.println("Im ready to live");
	}
	
	public void customInitMethod() {
		System.out.println("in custom init");
	}
	
	public void customDestoryMethod() {
		System.out.println("in custom destroy");
	}
	

}
