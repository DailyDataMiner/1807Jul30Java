package com.ex.exercises.OOP;

public abstract class Person implements Work{
	private String name="John Smith";
	private int age=48;	
		public String getName(){
return name;
}

public int getAge() {
	return age;}
	
	public Person(String name, int age) {
  this.name=name;
  this.age=age;}
	public void main(String[] args) {




}

public void setName(String name) {
	this.name = name;}

public void setAge(int age) {
	this.age = age;}
	

//	}

	@Override
	public void work() {
System.out.println("I'm unemployed");		
	}
}