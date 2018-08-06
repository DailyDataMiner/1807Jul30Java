package homework1.q11.two;
import homework1.q11.one.*; 

//Class in second package that access float values from other package
public class AccessFloats extends FloatValues {

	public static void main(String[] args) {
		System.out.println(FloatValues.fltValue1 + " " + fltValue2);
	}
}
