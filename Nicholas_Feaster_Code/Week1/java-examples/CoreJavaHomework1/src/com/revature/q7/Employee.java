package com.revature.q7;

import java.util.Comparator;

public class Employee implements Comparator {
	public String name;
	public String department;
	public int age;
	public Employee() {}
	public Employee(String name, String department, int age) {
		super();
		this.name = name;
		this.department = department;
		this.age = age;
	}
	class sortByName implements Comparator<Employee>{
		public int compare(Employee a, Employee b) {
			return a.name.compareTo(b.name);
		}
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public static int sortByName(Employee a, Employee b) {
		return a.name.compareTo(b.name);
	}
	
	//class sortByName implements Comparator<Employee>{
		//public int compare(Employee a, Employee b) {
			//return a.name.compareTo(b.name);
		//}
	//}
	
	public static int sortByDepartment(Employee a, Employee b) {
		return a.department.compareTo(b.department);
	}
	
	public static int sortByAge(Employee a, Employee b) {
		return a.age-b.age;
	}
	
	public int compare(Object arg0, Object arg1) {
		// TODO Auto-generated method stub
		return 0;
	}

}
