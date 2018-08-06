package com.revature.sortemployees;

import java.util.ArrayList;
import java.util.Collections;

// Sort two employees based on their name, department, and age using the
// Comparator interface

public class Main {
public static void main(String[] args) {

	ArrayList<Employee> arrList = new ArrayList<Employee>();
	arrList.add(new Employee("Michael", 22, "Revature"));
	arrList.add(new Employee("Aguywhoishere", 24, "Oracle"));
	
	Collections.sort(arrList,  new Sortbyname());
	System.out.println("Sorted by name:");
	for (int i=0; i <arrList.size(); i++) {
		System.out.println(arrList.get(i));
	}
	
	Collections.sort(arrList,  new Sortbyage());
	System.out.println("\nSorted by age:");
	for (int i=0; i <arrList.size(); i++) {
		System.out.println(arrList.get(i));
	}
	
	Collections.sort(arrList,  new Sortbydepartment());
	System.out.println("\nSorted by department:");
	for (int i=0; i <arrList.size(); i++) {
		System.out.println(arrList.get(i));
	}

}
}
