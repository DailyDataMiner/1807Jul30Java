package homework1.q10;

public class TernaryOps {

	public static void main(String[] args) {
	
		System.out.println("Minimum Value of 3 & 45 is: " + minValue(3, 45));
		System.out.println("Minimum Value of 56 & 22 is: " + minValue(56, 22));
		System.out.println("Minimum Value of 103 and 245 is: " + minValue(103, 245));

	}
	//Finds minimum of 2 numbers using ternary operators
	public static int minValue(int a, int b) {
		return((a < b) ? a : b);
		
	}

}
