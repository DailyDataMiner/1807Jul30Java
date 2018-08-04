// Logan Smith, 8/2/2018
// Class to show off how cases work

package question14;

import java.sql.Date;

public class CaseDisplay {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		CaseDisplay cd = new CaseDisplay(); // instance to access functions
		
		cd.caseBased(3, 5); // first int changes case, second int to be rooted
	}
	
	// Function which changes cases depending on input
	public void caseBased(int decider, int rooter) {
		
		// Based off of decider
		switch (decider) {
		case 1: // Case 1: find the square root of the second input number
			System.out.println("The Square Root is: " + Math.sqrt(rooter));
			break;
		case 2: // Case 2: display the date
			System.out.println("The Date is: " + java.time.LocalDate.now());
			break;
		case 3: // Case 3: create a string array which stores the string "I am learning Core Java"
			String[] stringstorer = new String[24];
			String toBeStored = "I am learning Core Java";
			for (int i = 0; i < 23; i++) {
				stringstorer[i] = "" + toBeStored.charAt(i);
				System.out.println(stringstorer[i]);
			}
			break;
		default: // Default case: Shouldn't be reached
			System.out.println("You shouldn't be here!");
			break;
		}
		
	}

}
