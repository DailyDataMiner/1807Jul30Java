// Logan Smith, 8/2/2018
// Class for inheriting abstract functions and adding implementation

package question18;

public class ConcreteSubclass extends AbstractSuperclass {

	@Override
	boolean uppercaseDetector(String s) {
		// Checks all characters in a loop and returns true if one is uppercase
		for (int i = 0; i < s.length(); i++) {
			if (Character.isUpperCase(s.charAt(i))) {
				return true;
			}
		}
		return false;
	}

	@Override
	String toUppercaseModifier(String s) {
		// Converts all characters to uppercase
		s = s.toUpperCase();
		return s;
	}

	@Override
	void plusTenOutput(String s) {
		// Uses try/catch statement to convert string to int, then add 10 and output
		int i = 0;
		try {
			i = Integer.parseInt(s);
		}
		catch(Exception e) {
			System.out.println("Invalid input. String unable to convert to int.");
			return;
		}
		i = i+10;
		System.out.println("The final int: " + i);
	}

}
