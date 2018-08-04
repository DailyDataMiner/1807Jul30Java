// Logan Smith, 8/2/2018
// Class with comparators and comparing output

package question7;

import java.awt.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.io.*;

public class CompareEmployee {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		CompareEmployee ce = new CompareEmployee(); // Instance to generate comparators
		
		ArrayList<Employee> employeeList = new ArrayList<Employee>(); // List of employees
		
		employeeList.add(new Employee("John", "Marketing", 34)); // Adding Employee
		employeeList.add(new Employee("Mark", "Business", 27)); // Adding Employee
		employeeList.add(new Employee("Luke", "Advertising", 39)); // Adding Employee
		employeeList.add(new Employee("Paul", "Infrastructure", 62)); // Adding Employee
		employeeList.add(new Employee("Matthew", "Marketing", 34)); // Adding Employee
		
		// Ouput
		Collections.sort(employeeList, ce.new SortbyName());
		for (Employee e : employeeList) {
			System.out.println("Name: " + e.name + " Age: " + e.age + " Department: " + e.department);
		}
		
		System.out.println();
		
		Collections.sort(employeeList, ce.new SortbyAge());
		for (Employee e : employeeList) {
			System.out.println("Name: " + e.name + " Age: " + e.age + " Department: " + e.department);
		}
		
		System.out.println();
		
		Collections.sort(employeeList, ce.new SortbyDepartment());
		for (Employee e : employeeList) {
			System.out.println("Name: " + e.name + " Age: " + e.age + " Department: " + e.department);
		}
		
	}
	
	// Comparator class which sorts by Name
	public class SortbyName implements Comparator<Employee> {
		@Override
		public int compare(Employee a, Employee b) {
			return a.name.compareTo(b.name);
		}
	}
	
	// Comparator class which sorts by Department
	class SortbyDepartment implements Comparator<Employee> {
		@Override
		public int compare(Employee a, Employee b) {
			return a.department.compareTo(b.department);
		}
	}
	
	// Comparator class which sorts by Age
	class SortbyAge implements Comparator<Employee> {
		@Override
		public int compare(Employee a, Employee b) {
			return a.age > b.age ? 1 : -1;
		}
	}

}
