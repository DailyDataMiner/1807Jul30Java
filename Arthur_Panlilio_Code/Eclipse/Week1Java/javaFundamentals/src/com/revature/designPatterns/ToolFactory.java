package com.revature.designPatterns;

public class ToolFactory {
	
	public static Tool instantiate(String toolType) {
		toolType = toolType.toLowerCase();
		switch(toolType) {
			case "hammer":
				return new Hammer();
			case "wrench":
				return new Wrench();
			case "screwdriver":
				return new Screwdriver();
			default:
				return null;
		}
	}

}
