package Q6;

public class isItEven {

public void isItEven(int n) {
		
		//System.out.println(n & 1);
		
		if((n & 1) == 0){										//comparing using bitwise operator last bit of number n and 1 and
			System.out.println("Even number"); 					//checking if equal to 0, which 
			}
		else {
			System.out.println("Odd number"); 
		}
	}
	
	public static void main(String[] args) {
		int oddOrEven = 97;
		isItEven isit = new isItEven();
		isit.isItEven(oddOrEven);
	}

}
