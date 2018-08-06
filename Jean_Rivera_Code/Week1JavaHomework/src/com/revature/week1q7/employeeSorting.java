package com.revature.week1q7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

import com.revature.week1q7.employeeSorting.employee;

public class employeeSorting {

	static public class employee {

		private String employeeName;
		private String employeeDepartment;
		private static int employeeAge;

		public employee(String employeeName, String employeeDepartment, int employeeAge) {

			super();
			this.employeeName = employeeName;
			this.employeeDepartment = employeeDepartment;
			this.employeeAge = employeeAge;

		}

		public String getEmployeeName() {
			return employeeName;
		}

		public void setEmployeeName(String employeeName) {
			this.employeeName = employeeName;
		}

		public String getEmployeeDepartment() {
			return employeeDepartment;
		}

		public void setEmployeeDepartment(String employeeDepartment) {
			this.employeeDepartment = employeeDepartment;
		}

		public int getEmployeeAge() {
			return employeeAge;
		}

		public void setEmployeeAge(int employeeAge) {
			this.employeeAge = employeeAge;
		}

	}

	public static Comparator<employee> employeeAgeComparator = new Comparator<employee>() {

		public int compare(employee e1, employee e2) {

			int employeeAge1 = e1.getEmployeeAge();
			int employeeAge2 = e1.getEmployeeAge();

			return employeeAge1 - employeeAge2;

		}

	};

	public static Comparator<employee> employeeNameComparator = new Comparator<employee>() {

		public int compare(employee e1, employee e2) {

			String employeeName1 = e1.getEmployeeName().toUpperCase();
			String employeeName2 = e1.getEmployeeName().toUpperCase();

			return employeeName1.compareTo(employeeName2);

		}

	};

	public static Comparator<employee> employeeDepartmentComparator = new Comparator<employee>() {

		public int compare(employee e1, employee e2) {

			String employeeName1 = e1.getEmployeeName().toUpperCase();
			String employeeName2 = e1.getEmployeeName().toUpperCase();

			return employeeName1.compareTo(employeeName2);

		}

	};

	public static void main(String[] args) {

		ArrayList<employee> employeeList = new ArrayList<employee>();

		employeeList.add(new employee("Hector", "HR", 32));
		employeeList.add(new employee("Karen", "Sales", 34));

		Collections.sort(employeeList, employeeNameComparator);
		Collections.sort(employeeList, employeeDepartmentComparator);
		Collections.sort(employeeList, employeeAgeComparator);

		for (Iterator<employee> iterator = employeeList.iterator(); iterator.hasNext();) {
			employee employee = (employee) iterator.next();

			System.out.println(employee.employeeName + " " + employee.employeeDepartment + " " + employee.employeeAge);

		}

	}

}
