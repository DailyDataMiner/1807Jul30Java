package com.revature.designPatterns;

import com.revature.designPatterns.AbstractFactoryClasses.Robot;

public class AbstractFactories {
	
	static class RobotFactory{
		static Robot buildRobot(String type, AbstractSize size, int powerLevel) {
		Robot r = null;
		return r;///stopped here
		}
		
	}
	
	
	static class KillerFactory{
		static Robot buildRobot(AbstractSize size, int powerLevel) {
			Robot r = null;
			switch(size) {
				case SMALL:
					r = new AbstractFactoryClasses.Killer(AbstractSize.SMALL, powerLevel);
					return r;
				case MEDIUM:
					r = new AbstractFactoryClasses.Killer(AbstractSize.MEDIUM, powerLevel);
					return r;
				case LARGE:
					r = new AbstractFactoryClasses.Killer(AbstractSize.LARGE, powerLevel);
					return r;
				
			}			
			return null;		
		}
	}
	
	static class MechaFactory{
		static Robot buildRobot(AbstractSize size, int powerLevel) {
			Robot r = null;
			switch(size) {
				case SMALL:
					r = new AbstractFactoryClasses.Mecha(AbstractSize.SMALL, powerLevel);
					return r;
				case MEDIUM:
					r = new AbstractFactoryClasses.Mecha(AbstractSize.MEDIUM, powerLevel);
					return r;
				case LARGE:
					r = new AbstractFactoryClasses.Mecha(AbstractSize.LARGE, powerLevel);
					return r;
				
			}			
			return null;		
		}
	}
	
	static class BioFactory{
		static Robot buildRobot(AbstractSize size, int powerLevel) {
			Robot r = null;
			switch(size) {
				case SMALL:
					r = new AbstractFactoryClasses.Bio(AbstractSize.SMALL, powerLevel);
					return r;
				case MEDIUM:
					r = new AbstractFactoryClasses.Bio(AbstractSize.MEDIUM, powerLevel);
					return r;
				case LARGE:
					r = new AbstractFactoryClasses.Bio(AbstractSize.LARGE, powerLevel);
					return r;
				
			}			
			return null;		
		}
	}

}
