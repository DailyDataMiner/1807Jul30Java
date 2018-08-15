package com.revature.oopfundamentals;

public class Child extends People {

	public Child(String eyeColor, String sex, int age, String race, String name) {
		super(eyeColor, sex, age, race, name);
		
		
		final String school;
		
        
	
	}
	
	protected void run() {
		
		System.out.println(name + " ran 4 miles today");
	}
	protected void speak() {
		
		System.out.println(name + ": Run! Forest Run!!");
	}
	

public Child() {
	super(eyeColor, eyeColor, age, eyeColor, eyeColor);
		// TODO Auto-generated constructor stub
	}



public static void main(String[] args ) {
	
	Child Jenny = new Child();
	Jenny.setAge(7);
	Jenny.setEyeColor("brown");
	Jenny.setName("Jenny Curran");
	Jenny.setSex("female");
	Jenny.setRace("Caucasian");
	
	Jenny.speak();
	
	
}
	

}
