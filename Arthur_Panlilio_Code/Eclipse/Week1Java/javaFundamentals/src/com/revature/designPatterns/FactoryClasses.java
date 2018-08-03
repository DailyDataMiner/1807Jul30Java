package com.revature.designPatterns;

public class FactoryClasses {
	
	static abstract class Dragon {		
		public abstract void breathe();
	}
	
	static class IceDragon extends Dragon{
		public void breathe() {
			System.out.println("I breathe ice!");
		}
	}
	
	static class FireDragon extends Dragon{
		public void breathe() {
			System.out.println("I breath fire!");
		}
	}
	
	static class LightningDragon extends Dragon{
		public void breathe() {
			System.out.println("I breath lightning!");
		}
	}
	
	

}
