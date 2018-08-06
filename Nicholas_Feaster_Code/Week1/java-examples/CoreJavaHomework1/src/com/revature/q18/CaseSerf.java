package com.revature.q18;

public class CaseSerf extends CaseOverlord {

	@Override
	public Boolean anyUppers(String deriv) {
		//for(int i=0;i<deriv.length();i++) {
			if(deriv.matches("[A-Z]{1}")) {
				System.out.println("hi");
				return true;
			//}
		}
		return false;
	}

	@Override
	public String bigIfSmall(String aDeriv) {
		aDeriv = aDeriv.toUpperCase();
		return aDeriv;
	}

	@Override
	public void plusTen(String moreDeriv) {
		int lesser = Integer.parseInt(moreDeriv);
		lesser = lesser+10;
		System.out.println(lesser);
		
	}

}
