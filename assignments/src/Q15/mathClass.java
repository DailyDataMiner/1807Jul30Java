package Q15;

public class mathClass implements mathInterface {

	public static void main(String[] args) {
		
	}

	@Override
	public int addition(int x, int y) {
		int sum = x + y;
		return sum;
	}

	@Override
	public int subtraction(int x, int y) {
		int diff = x - y;
		return diff;
	}

	@Override
	public int multiplication(int x, int y) {
		int product = x * y;
		return product;
	}

	@Override
	public int division(int x, int y) {
		int quotient = x / y;
		return quotient;
	}
	
}
