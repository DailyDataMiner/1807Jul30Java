package evenNumbers_Q12;

import java.util.ArrayList;

public class evenNumbers {
     
	public static void main(String[] args) {
		ArrayList<Integer> Even = new ArrayList<Integer>();
		for(int i=0; i < 100; i++) {
			if(i % 2==0) {
				Even.add(i);
			}
		}
		for(int i : Even){
			System.out.print(i + " ");
		}
	
	}

}
