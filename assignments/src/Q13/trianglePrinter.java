package Q13;

public class trianglePrinter {
	
	public static void main(String[] args) {
		triangleMaker(4);
	}

	public static void triangleMaker(int rows) {
		boolean b = false;
		
		for(int i = 1; i <= rows; i++) {
			for(int j = 0; j < i; j++) {
				if (b == true) {			//If b is true, print 1 and invert to 0
					System.out.print(1);
				}							//If b is false, print 0 and invert to 1
				else if(b == false) {
					System.out.print(0);
				}
				b = !b;
			}
			System.out.println("\n");
		}
	}		
}
