// Logan Smith, 8/2/2018
// Class which provides implementation for the OperandInterface interface

package InterfacePackage;

public class Operators implements OperandInterface {

	// Implements addition
	@Override
	public int addition(int a, int b) {
		return a+b;
	}

	// Implements subtraction
	@Override
	public int subtraction(int a, int b) {
		return a-b;
	}

	// Implements multiplication
	@Override
	public int multiplication(int a, int b) {
		return a*b;
	}

	// Impliments division
	@Override
	public int division(int a, int b) {
		return a/b;
	}

}
