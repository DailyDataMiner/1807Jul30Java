package com.ex.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class Life implements InitializingBean, DisposableBean, BeanFactoryAware, BeanPostProcessor, BeanNameAware,
		ApplicationContextAware {
	
	/*
	 *  Spring Bean Life Cycle
	 *  
	 *  Instantiate Populate 
	 */

	private String circleOfLife;

	public Life() {

		System.out.println("IN NO ARGS CONSTRUCTOR ");
	}

	public Life(String circleOfLife) {
		super();
		this.circleOfLife = circleOfLife;
	}

	public String getCircleOfLife() {
		return circleOfLife;
	}

	public void setCircleOfLife(String circleOfLife) {
		this.circleOfLife = circleOfLife;
	}

	public static void live() {
		System.out.println("IM READY TO LIVE !!!!");
	}

	public void customInitMethod() {
		System.out.println("In CUSTOM INIT");
	}

	public void customDestroyMethod() {
		System.out.println("IN CUSTOM DESTROY !!!! BOOOOOOM");
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		// TODO Auto-generated method stub
		System.out.println("In setAppContext");

	}

	@Override
	public void setBeanName(String name) {
		// TODO Auto-generated method stub
		System.out.println("IN setBeanName");

	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		// TODO Auto-generated method stub
		System.out.println("IN postProcessBefore");
		return null;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		// TODO Auto-generated method stub
		System.out.println("IN postProcessAfter");
		return null;
	}

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		// TODO Auto-generated method stub
		System.out.println("In setBeanFactory");

	}

	@Override
	public void destroy() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("In DESTROY");

	}

	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println("IN afterPropertiesSet()");

	}

}
