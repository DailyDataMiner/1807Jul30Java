package com.revature.designPatterns;

import com.revature.designPatterns.FactoryClasses.Dragon;

public class Factory {
	
	public static Dragon getDragon(String s) {
		s = s.toLowerCase();
		switch(s) {
			case "ice":
				return new FactoryClasses.IceDragon();
			case "fire":
				return new FactoryClasses.FireDragon();
			case "lightning":
				return new FactoryClasses.LightningDragon();
		
		}
		return null;
	}

}
