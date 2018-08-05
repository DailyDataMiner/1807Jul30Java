package com.revature.q7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Test{

	public static void main(String[] args) {
		ArrayList<Employee> emps = new ArrayList<Employee>();
		emps.add(new Employee("Helen", "Development", 25));
		emps.add(new Employee("Rob", "Accounting", 34));
		emps.add(new Employee("Hiero", "Human Resources", 27));
		
		System.out.println("Unsorted");
		for(int i = 0; i < emps.size(); i++) {
			System.out.println(emps.get(i));
		}
		
		Collections.sort(emps, new sortByName());
		
		System.out.println("\nSorted by Name");
		for(int i = 0; i < emps.size(); i++) {
			System.out.println(emps.get(i));
		}
		
		Collections.sort(emps, new sortByDepartment());
		
		System.out.println("\nSorted by Department");
		for(int i = 0; i < emps.size(); i++) {
			System.out.println(emps.get(i));
		}
		
		Collections.sort(emps, new sortByAge());
		
		System.out.println("\nSorted by Age");
		for(int i = 0; i < emps.size(); i++) {
			System.out.println(emps.get(i));
		}
	}
}

class sortByName implements Comparator<Employee> {

	@Override
	public int compare(Employee e1, Employee e2) {
		return e1.getName().compareTo(e2.getName());
	}
	
}

class sortByDepartment implements Comparator<Employee> {

	@Override
	public int compare(Employee e1, Employee e2) {
		return e1.getDepartment().compareTo(e2.getDepartment());
	}
	
}

class sortByAge implements Comparator<Employee> {

	@Override
	public int compare(Employee e1, Employee e2) {
		// TODO Auto-generated method stub
		return e1.getAge() - e2.getAge();
	}
	
}
