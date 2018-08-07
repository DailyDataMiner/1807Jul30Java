package com.revature.week1.Q7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortEmployees {

	static class Sort implements Comparator<Employee>{
		@Override
		public int compare(Employee a, Employee b) {
			int i = a.name.compareTo(b.name);
			if(i == 0) {
				i = a.departement.compareTo(b.departement);
			}
			if(i == 0) {
				i = b.age - a.age;
			}
			return i;
		}
	}
	
	public static void main(String[] args) {
		Employee e1 = new Employee("Alpha", "One", 30);
		Employee e2 = new Employee("Beta", "One", 30);
		ArrayList<Employee> list = new ArrayList<>();
		list.add(e2);
		list.add(e1);
		display(list);
		Collections.sort(list, new Sort());
		display(list);
	}
	
	private static <T> void display(List<T> list) {
		for(T t : list) {
			System.out.println(t);
		}
		System.out.println();
	}

}

class Employee {
	public String name;
	public String departement;
	public int age;
	public Employee(String name, String departement, int age) {
		this.name = name;
		this.departement = departement;
		this.age = age;
	}
	
	@Override
	public String toString() {
		return name + " - " + departement + " - " + age;
	}
}

