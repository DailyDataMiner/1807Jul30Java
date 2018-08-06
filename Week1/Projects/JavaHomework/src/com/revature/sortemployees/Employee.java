package com.revature.sortemployees;

import java.util.Comparator;

public class Employee {
	String name, department;
	int age;

	public Employee(String name, int age, String department) {
		this.name = name;
		this.department = department;
		this.age = age;
	}

	public String toString() {
		return this.name + " " + this.age + " " + this.department;
	}

}

class Sortbyage implements Comparator<Employee> {

	public int compare(Employee a, Employee b) {
		if (a.age == b.age)
			return 0;
		else if (a.age > b.age)
			return 1;
		else
			return -1;
	}

}

class Sortbyname implements Comparator<Employee> {

	public int compare(Employee a, Employee b) {
		return a.name.compareTo(b.name);
		
	}
}

class Sortbydepartment implements Comparator<Employee> {
	
	public int compare(Employee a, Employee b) {
		return a.department.compareTo(b.department);
	}
}
