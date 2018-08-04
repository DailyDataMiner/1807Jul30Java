// Logan Smith, 8/2/2018
// Class to test the abstract package

package question18;

public class SubclassTester {

	public static void main(String[] args) {
		
		ConcreteSubclass cs = new ConcreteSubclass();
		
		// Outputs
		System.out.println("Does Pug have an uppercase letter: " + cs.uppercaseDetector("Pug"));
		System.out.println("Converting pug to uppercase: " + cs.toUppercaseModifier("pug"));
		System.out.println("Changing 65 to int and adding 10: ");
		cs.plusTenOutput("65");
		

	}

}
