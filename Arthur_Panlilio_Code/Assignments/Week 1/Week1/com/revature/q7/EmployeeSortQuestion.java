package com.revature.q7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Uses the comparator interface to sort employees
 * 
 * @author Arthur Panlilio
 *
 */
public class EmployeeSortQuestion {

	public static void main(String[] args) {
		//Generates multiple employees
		Employee e1 = new Employee("Bob","Marketing",42);
		Employee e2 = new Employee("Gragnok","HR",210);
		Employee e3 = new Employee("Martha", "Marketing", 39);
		Employee e4 = new Employee("Karlore", "Demon Slayer",9999);
		Employee e5 = new Employee("Tim", "HR", 25);
		//Creates an array list to store employees
		ArrayList<Employee> a1 = new ArrayList<>();
		a1.add(e1);
		a1.add(e2);
		a1.add(e3);
		a1.add(e4);
		a1.add(e5);
		//Sorts by name
		System.out.println("Sorted by name: ");
		Collections.sort(a1, new SortByName());
		printArray(a1);
		//Sorts by department
		System.out.println("Sorted by department: ");
		Collections.sort(a1, new SortByDepartment());
		printArray(a1);
		//Sorts by age
		System.out.println("Sorted by age: ");
		Collections.sort(a1, new SortByAge());
		printArray(a1);
		
		

	}
	/**
	 * Sorts by name
	 * 
	 * @author Arthur Panlilio
	 *
	 */
	static class SortByName implements Comparator<Employee>{
		@Override
		public int compare(Employee o1, Employee o2) {
			return o1.name.compareTo(o2.name);
		}		
	}
	/**
	 * Sorts by department
	 * 
	 * @author Arthur Panlilio
	 *
	 */
	static class SortByDepartment implements Comparator<Employee>{
		@Override
		public int compare(Employee o1, Employee o2) {
			return o1.department.compareTo(o2.department);
		}
	}
	/**
	 * Sorts by age
	 * 
	 * @author Arthur Panlilio
	 *
	 */
	
	static class SortByAge implements Comparator<Employee>{
		@Override
		public int compare(Employee o1, Employee o2) {
			return o1.age - o2.age;
		}
	}
	
	/**
	 * Prints out the array values in order
	 * 
	 * @param ar is the array to be printed
	 */
	public static void printArray(ArrayList<Employee> ar) {
		
		for(int i = 0; i < ar.size(); i++) {
			System.out.print(ar.get(i).name + ", " + ar.get(i).department
					 + ", " + ar.get(i).age);
			if(i != ar.size()-1) {
				System.out.print(" ||| ");
			}
		}
		System.out.println("\n \n");
	
	}


	

}
