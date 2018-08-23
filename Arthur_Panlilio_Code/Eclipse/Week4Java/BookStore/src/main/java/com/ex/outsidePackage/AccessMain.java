package com.ex.outsidePackage;

import com.ex.main.PublicAccessClass;

public class AccessMain {
	
	public static void main(String[] args) {
		
		//can call in outside package
		PublicAccessClass pac = new PublicAccessClass();
		
		//cannot call in outside package
		DefaultAccessClass dac = new DefaultAccessClass();
		
	}

}
