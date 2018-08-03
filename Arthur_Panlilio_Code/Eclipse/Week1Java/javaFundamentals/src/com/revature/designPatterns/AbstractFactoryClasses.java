package com.revature.designPatterns;

public class AbstractFactoryClasses {
	
	static abstract class Robot{
		AbstractSize size;
		int powerLevel;
		String type;
		
		Robot(AbstractSize size, int powerLevel){
			this.size = size;
			this.powerLevel = powerLevel;
		}

		public AbstractSize getSize() {
			return size;
		}

		public void setSize(AbstractSize size) {
			this.size = size;
		}

		public int getPowerLevel() {
			return powerLevel;
		}

		public void setPowerLevel(int powerLevel) {
			this.powerLevel = powerLevel;
		}
		
		public String battleCry() {
			return "I AM A " + size + " " + type +" ROBOT! MY POWER LEVEL IS " + powerLevel;
		}
	}
	
	static class Killer extends Robot{
		Killer(AbstractSize size, int powerLevel){
			super(size,powerLevel);
			type = "Killer Robot";
		}
	}
	
	static class Mecha extends Robot{
		Mecha(AbstractSize size, int powerLevel){
			super(size,powerLevel);
			type = "Mecha Robot";
		}
	}
	
	static class Bio extends Robot{
		Bio(AbstractSize size, int powerLevel){
			super(size,powerLevel);
			type = "Biological Robot";
		}
	}

}
