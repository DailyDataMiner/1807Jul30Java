package question20;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class question20 {

	public static void main(String[] args) throws FileNotFoundException {
		File infile = new File("/Users/PauloWebba/my_git_repos/1807Jul30Java/Paulo_Webba_Code/assignments/src/question20/Data.txt");
		Scanner sc = new Scanner(infile);
		String firstname = new String(), lastname= new String(), state = new String();
		int age= 0;
		
		while(sc.hasNext()) {
		sc.useDelimiter(":");
		if(sc.hasNext())
		firstname = sc.next();
		if(sc.hasNext())
		lastname = sc.next();
		if(sc.hasNext())
		age = sc.nextInt();
		if(sc.hasNext()) {
			sc.useDelimiter("\n");
			state = sc.next();
		}
		
		
		//System.out.println("State" + state);
		System.out.println("Name: " + firstname +" "+ lastname);
		System.out.println("Age: " + age + " years");
		System.out.println("State" + state + " State");
       }
	}

}
