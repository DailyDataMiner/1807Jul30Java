package Q7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

//Constructor
class Employee{
	String name;
	String dept;
	int age;
//had this as a default constructor originally, but a fix to a problem I had was to change the default constructor into this
Employee (String string, String string2, int i) {};
	

}

class nameSorter implements Comparator{
	public int compare(Employee e1, Employee e2) {
		return e1.name.compareTo(e2.name);
	}

	@Override
	public int compare(Object e1, Object e2) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
//Mostly based this off of an example I found online, because I wanted to try a comparator in the java 8 style
public class EmployeeSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList list = new ArrayList();
		list.add(new Employee("Susan Defrou", "Accounting", 20));
		list.add(new Employee("Aaron Anderson", "Information Technology", 29));

		System.out.println("Unsorted list: ");
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		Collections.sort(list, new nameSorter());
		
		System.out.println("Sorted list: ");
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}



}