package com.revature.q7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Driver {
	

	
	public static void main(String[] args) {
		ArrayList<Employee> emp = new ArrayList<Employee>();	
		emp.add(new Employee("Molly","Legal",26));
		emp.add(new Employee("Joissa","Education",29));
		//Collections.sort(emp, new sortByName());
		for(int i = 0; i<emp.size();i++){
			System.out.println(i);
		}
	
	}
}
	
	 

		
	
