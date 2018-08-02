package question15;

public class Test {

	public static void main(String[] args) {
		Calculator calc = new Calculator();
		double a = 10;
		double b = 20;
		
		System.out.println(calc.add(a, b));
		System.out.println(calc.subtract(a, b));
		System.out.println(calc.multiply(a, b));
		System.out.println(calc.divide(a, b));
	}

}
