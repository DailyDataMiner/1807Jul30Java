package question7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class CompareByName implements Comparator<Employee> {

	@Override
	public int compare(Employee a, Employee b) {
		return a.getName().compareTo(b.getName());
	}
	
}

class CompareByDepartment implements Comparator<Employee> {

	@Override
	public int compare(Employee a, Employee b) {
		return a.getDepartment().compareTo(b.getDepartment());
	}
	
}

class CompareByAge implements Comparator<Employee> {

	@Override
	public int compare(Employee a, Employee b) {
		return a.getAge() - (b.getAge());
	}
	
}

public class EmployeeSort {

	public static void main(String[] args) {
		Employee a = new Employee("Angela", "IT", 40);
		Employee b = new Employee("Bob", "HR", 25);
		Employee c = new Employee("Charlie", "Advertising", 29);

		
		List<Employee> allEmployees = new ArrayList<Employee>();
		
		allEmployees.add(a);
		allEmployees.add(b);
		allEmployees.add(c);
		
		Collections.sort(allEmployees, new CompareByAge());
		
		for (Employee e : allEmployees) {
			System.out.println(e.toString());
		}
		
		System.out.println();
		
		Collections.sort(allEmployees, new CompareByName());
		
		for (Employee e : allEmployees) {
			System.out.println(e.toString());
		}
		
		System.out.println();
		
		Collections.sort(allEmployees, new CompareByDepartment());
		
		for (Employee e : allEmployees) {
			System.out.println(e.toString());
		}
	}
	
	

}
