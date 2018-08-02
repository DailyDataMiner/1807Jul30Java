// Logan Smith, 8/2/2018
// Class which displays the usage of the operator class

package InterfacePackage;

public class OperatorUser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Operators op = new Operators();
		
		// Output
		System.out.println("5 + 6 = " + op.addition(5, 6));
		System.out.println("8 - 5 = " + op.subtraction(8, 5));
		System.out.println("10 * 3 = " + op.multiplication(10, 3));
		System.out.println("8 / 4 = " + op.division(8, 4));
		
	}

}
