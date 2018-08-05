package Employee;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Employee{

    private String name;
    private String department;
    private int age;
	public Employee(String name, String department, int age) {
		super();
		this.name = name;
		this.department = department;
		this.age = age;
	}
	
	@Override
    public String toString() {
        return " Employee:" + "Name- " + name + ", Age- " + age + ", Department- " + department + "\n.";

    }	
	  public static Comparator<Employee> AgeComparator = new Comparator<Employee>(){

	        public int compare(Employee o1, Employee o2) {
	            return o1.age - o2.age;
	        }
	      
	    };
	    public static Comparator<Employee> NameComparator = new Comparator<Employee>(){

	        public int compare(Employee o1, Employee o2) {
	        	return (o1.name).compareTo(o2.name);
	        }
	      
	    };
	    public static  Comparator<Employee> DepartmentComparator = new Comparator<Employee>(){

	        public int compare(Employee o1, Employee o2) {
	        	return (o1.department).compareTo(o2.department);
	        }
	      
	    };
	    
	    
	    public static void main(String [] args) {
	    	
	    	Employee e1 = new Employee("Pedro", "Cooking", 70);
	    	Employee e2 = new Employee("Suzan", "Engeneering", 33);
	    	
	    	ArrayList<Employee> Elist = new ArrayList<Employee>();
	    	Elist.add(e1);
	    	Elist.add(e2);
	    	System.out.println("Age Sorting: ");
	    	Collections.sort(Elist, AgeComparator);
	    	System.out.println(Elist);
	    	System.out.println("Name Sorting: ");
	    	Collections.sort(Elist, NameComparator);
	    	System.out.println(Elist);
	    	System.out.println("Department Sorting: ");
	    	Collections.sort(Elist, DepartmentComparator);
	    	System.out.println(Elist);
	    	 
	    	
	    }
	    


}
