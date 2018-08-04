package com.revature.designpatterns;

public class ToolFactory {

	public static Tool  createTool(String toolType) {
		switch (toolType.toLowerCase()) {
		case "hammer":
			return new Hammer();
		case "screwDriver":
			return new ScrewDriver();
		case "wrench":
			return new Wrench();
		default:
			return null;
		}
	}

}
