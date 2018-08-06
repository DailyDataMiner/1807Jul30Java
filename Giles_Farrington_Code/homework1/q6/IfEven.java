package homework1.q6;

public class IfEven {

	public static void main(String[] args) {
		ifEven(9);

	}
	
	//Method to determine if even without using modulus operator
	public static void ifEven(int n) {
		int quot = n/2;
		if(quot * 2 == n) {
			System.out.println("Number is even");
		}
		else {
			System.out.println("Number is odd");
		}
	}

}
