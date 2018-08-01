import java.util.Scanner;

public class ControlStructures {
	
	public static void main(String[] args) {
		System.out.println("Array to count: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]...");
		int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		// For loops
		for(int i = 0; i < 10; i++) {
			System.out.println("For loop count = " + nums[i]);
		}
		
		// for-each loop
		for(int i : nums) {
			System.out.println("For each count = " + nums[i-1]);
		}
		
		//while
		int num = 0;
		int index = 0;
		while(num > nums[index]) {
			System.out.println(nums[index]);
		}
		
		//do-while
		do {
			System.out.println("Do while count = " + nums[index]);
			index++;
		}
		while(index < 10);
		
		//if-else
		System.out.print("Enter a number between 1 and 100: ");
		Scanner c = new Scanner(System.in);
		int inputNum = c.nextInt();
		if(inputNum > 50) {
			System.out.println("The number you entered is greater than 50.");
		}
		else {
			System.out.println("The number you entered is less than 50.");
		}
		
		//if-elseif-else
		System.out.print("Enter another number between -10 and 10: ");
		inputNum = c.nextInt();
		if(inputNum > 0) {
			System.out.println("The number you entered is positive.");
		}
		else if(inputNum < 0) {
			System.out.println("The number you entered is negative.");
		}
		else System.out.println("You have entered 0. It is neither positive nor negative.");
		
		//switch
		System.out.print("Enter the number of a day of the week: ");
		inputNum = c.nextInt();
		
		switch(inputNum) {
		case 1:
			System.out.println("It's Sunday!");
			break;
		case 2:
			System.out.println("It's Monday!");
			break;
		case 3:
			System.out.println("It's Tuesday!");
			break;
		case 4:
			System.out.println("It's Wednesday!");
			break;
		case 5:
			System.out.println("It's Thursday!");
			break;
		case 6:
			System.out.println("It's Friday!");
			break;
		case 7:
			System.out.println("It's Saturday!");
			break;
		default:
			System.out.println("Invalid day!");
			break;
		}
	}
}
