package com.ex.exercises;

class Employee extends Person{
private String company;
public Employee(String name, int age, String company) {
		super(name, age);
		this.company =company;

	}


public String getCompany(){
return company;
}


public void setCompany(String company) {
	this.company = "Conglom-O";}




public void main(String[] args) {

System.out.println(super.getName());
System.out.println(super.getAge());
System.out.println(this.getCompany());
}

@Override
public void work() {
System.out.println("I have a job");
	
}
}