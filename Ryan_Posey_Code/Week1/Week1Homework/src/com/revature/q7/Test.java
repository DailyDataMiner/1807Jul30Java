package com.revature.q7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Test{

	public static void main(String[] args) {
		// ArrayList of employees for comparison
		ArrayList<Employee> emps = new ArrayList<Employee>();
		emps.add(new Employee("Helen", "Development", 25));
		emps.add(new Employee("Rob", "Accounting", 34));
		emps.add(new Employee("Hiero", "Human Resources", 27));
		
		// Unsorted list
		System.out.println("Unsorted");
		for(int i = 0; i < emps.size(); i++) {
			System.out.println(emps.get(i));
		}
		
		
		// Sort the list by name field
		Collections.sort(emps, new sortByName());
		
		System.out.println("\nSorted by Name");
		for(int i = 0; i < emps.size(); i++) {
			System.out.println(emps.get(i));
		}
		
		
		// Sort the list by department field
		Collections.sort(emps, new sortByDepartment());
		
		System.out.println("\nSorted by Department");
		for(int i = 0; i < emps.size(); i++) {
			System.out.println(emps.get(i));
		}
		
		// Sort the list by age field
		Collections.sort(emps, new sortByAge());
		
		System.out.println("\nSorted by Age");
		for(int i = 0; i < emps.size(); i++) {
			System.out.println(emps.get(i));
		}
	}
}


// overridden sort methods to compare Employee fields

// compares two employee names
class sortByName implements Comparator<Employee> {

	@Override
	public int compare(Employee e1, Employee e2) {
		return e1.getName().compareTo(e2.getName());
	}
	
}

// compares two employee departments
class sortByDepartment implements Comparator<Employee> {

	@Override
	public int compare(Employee e1, Employee e2) {
		return e1.getDepartment().compareTo(e2.getDepartment());
	}
	
}

// compares two employee ages
class sortByAge implements Comparator<Employee> {

	@Override
	public int compare(Employee e1, Employee e2) {
		// TODO Auto-generated method stub
		return e1.getAge() - e2.getAge();
	}
	
}
