package Q5;

import java.util.Scanner;

public class SubString {
public static void main(String[] args) {
	//get string and index
	Scanner sc = new Scanner(System.in);
	System.out.print("Enter a string.:  ");
    String str = sc.next();
	System.out.print("Enter the index number:  ");
	int idx = sc.nextInt();
	sc.close();
//	get the charecter at the index
	for (int i =0; i<=idx; i++) {
		System.out.print(str.charAt(i));
	}
}
}
