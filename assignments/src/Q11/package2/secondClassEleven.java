package Q11.package2;

import Q11.package1.firstClassEleven; //importing other package, so we can use the stuff in it

public class secondClassEleven extends firstClassEleven{
	
	public static void main(String[] args) {
		
		System.out.println(accessibleFloat);	//printing accessibleFloat, which is in package1 and firstClassEleven
		System.out.println(accessibleFloat2);	//and this one, too
		
	}

}
