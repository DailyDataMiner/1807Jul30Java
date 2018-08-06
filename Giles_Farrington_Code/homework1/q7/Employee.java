package homework1.q7;

import java.util.Comparator;


public class Employee {

	public String name;
	public String department;
	public int age;
	
	public Employee(String name, String department, int age) {
		super();
		this.name = name;
		this.department = department;
		this.age = age;
	}
	
	public String toString() {
		
		return this.name + ", " + this.department + ", " + this.age;
	}
	
}

//Sorts by name
class SortByName implements Comparator<Employee>{

	public int compare(Employee a, Employee b) {
		
		return a.name.compareTo(b.name);
	}
}
//Sorts by department
class SortByDepartment implements Comparator<Employee>{

	public int compare(Employee a, Employee b) {
		return a.department.compareTo(b.department);
	}
}
//Sorts by age
class SortByAge implements Comparator<Employee>{

	public int compare(Employee a, Employee b) {
		return a.age - b.age;
	}
}
