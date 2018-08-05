package Minimum;

public class Minimum {
	
	static int minimo(int firstNumber, int secondNumber) {
		return firstNumber < secondNumber ? firstNumber : secondNumber;
	};
	public static void main(String[] args) {
	   System.out.println("The minimum number is: "+ minimo(53,4));
	}

}
