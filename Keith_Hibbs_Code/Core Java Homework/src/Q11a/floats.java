package Q11a;
import Q11b.Floats;
public class floats {
public static void main(String[] args) {
	
	// Creates an object named Floats
	Floats item = new Floats();
	
	// Gets the X and Y values and assigns them to a local variable
	float a = item.getX();
	float b = item.getY();
	
	// Printing stuff to show it works
	System.out.println(a);
	System.out.println(b);
	System.out.println(a+b);
}
}

