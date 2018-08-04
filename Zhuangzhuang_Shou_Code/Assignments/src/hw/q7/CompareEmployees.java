package hw.q7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class CompareEmployees 
{
	public static void main(String[] args) 
	{
		Employee e1 = new Employee("John", "HR", 30);
		Employee e2 = new Employee("Bob", "Sales", 25);
		ArrayList<Employee> eList = new ArrayList<Employee>();
		eList.add(e1);
		eList.add(e2);
		
		Comparator<Employee> compareByName = (Employee emp1, Employee emp2) -> 
			{return emp1.name.compareTo(emp2.name);};
		Comparator<Employee> compareByDepartment = (Employee emp1, Employee emp2) ->
			{return emp1.department.compareTo(emp2.department);};
		Comparator<Employee> compareByAge = (Employee emp1, Employee emp2) ->
			{return  emp1.age - emp2.age;};
		
		
		System.out.println(eList.toString());
//		Collections.sort(eList, new CompareByName());
//		System.out.println(eList.toString());
//		Collections.sort(eList, new CompareByDepartment());
//		System.out.println(eList.toString());		
//		Collections.sort(eList, new CompareByAge());
//		System.out.println(eList.toString());
		
		Collections.sort(eList, compareByName);
		System.out.println(eList.toString());
		Collections.sort(eList, compareByDepartment);
		System.out.println(eList.toString());		
		Collections.sort(eList, compareByAge);
		System.out.println(eList.toString());
		
		
	}
}

class Employee
{
	String name, department;
	int age;
	
	Employee (String name, String department, int age)
	{
		this.name = name;
		this.department = department;
		this.age = age;
	}
	
	public String toString()
	{
		return name + " " + department + " " + age;
	}
}

class CompareByName implements Comparator<Employee>
{
	public int compare(Employee e1, Employee e2)
	{
		return e1.name.compareTo(e2.name);
	}
}

class CompareByDepartment implements Comparator<Employee>
{
	public int compare(Employee e1, Employee e2)
	{
		return e1.department.compareTo(e2.department);
	}
}

class CompareByAge implements Comparator<Employee>
{
	public int compare(Employee e1, Employee e2)
	{
		return e1.age - e2.age;
	}	
}
