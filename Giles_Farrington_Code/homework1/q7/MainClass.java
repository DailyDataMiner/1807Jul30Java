package homework1.q7;

import java.util.ArrayList;
import java.util.Collections;

public class MainClass {

	public static void main(String[] args) {
		
		//Array list containing employee information
		ArrayList<Employee> al = new ArrayList<Employee>();
		al.add(new Employee("John", "Dep.1", 32));
		al.add(new Employee("Chris", "Dep.2", 28));
		
		System.out.println("Original unsorted: ");
		for(int i=0; i < al.size(); i++) {
			System.out.println(al.get(i));
		}
		
		Collections.sort(al,  new SortByName());
		System.out.println("\nSorted by name: ");
		for(int i=0; i < al.size(); i++) {
			System.out.println(al.get(i));
		}
		
		Collections.sort(al, new SortByDepartment());
		System.out.println("\nSorted by Department: ");
		for(int i=0; i < al.size(); i++) {
			System.out.println(al.get(i));
		}
		
		Collections.sort(al, new SortByAge());
		System.out.println("\nSorted by Age: ");
		for(int i=0; i < al.size(); i++) {
			System.out.println(al.get(i));
		}
	}

}
