package com.revature.oopfundamentals;

abstract class People {
	
	static String eyeColor;
	private String sex;
	static int age;
	protected String race;
	protected String name;
	
	
	public People(String eyeColor, String sex, int age, String race, String name) {
		super();
		this.eyeColor = eyeColor;
		this.sex = sex;
		this.age = age;
		this.race = race;
		
		
	}
	
	public void setName (String name) {
		this.name = name;
	}
	
	public void setEyeColor (String eyeColor) {
			this.eyeColor = eyeColor;	
	}
	public void setRace (String race) {
		this.race = race;
	}
	
	public void setSex (String sex) {
		this.sex = sex;
	}
	
	public void setAge (int n) {
		age = n;
	}
	
	public void getName() {
		System.out.println(name);
	}
	public void getAge() {
		System.out.println(age);
	}
	public void getEyeColor() {
		System.out.println(eyeColor);
	}
	public void getRace() {
		System.out.println(race);
	}
	public void getSex() {
		System.out.println(sex);
	}
	
	abstract void run();
	abstract void speak();
}
