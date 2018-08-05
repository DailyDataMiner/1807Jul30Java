package com.revature.q7;

import java.util.Comparator;

public class Employee implements Comparator<Employee>{
	
	
	String Name;
	String Department;
	int Age;
	
	public Employee(String name,String dep,int age) {
		name = this.Name;
		dep = this.Department;
		age = this.Age;
		
	}
	
	public int compare(Employee arg0, Employee arg1) {
		if(arg0.Age < arg1.Age) {
			return 1;
		}
		return 0;
	}
	
		
	

	public static void main(String[] args) {
		
		Employee e1 = new Employee("Bill","Sales", 45);
		Employee e2 = new Employee("Zach","Tech", 40);
		
		Employee arraye[] = {e1,e2};
		
		for(int i = 0; i < arraye.length -1; i++) {
			if(e1.compare(arraye[i],arraye[i+1]) == 1) {
				
			}
				
		}
		
	}

	

	
	

}

