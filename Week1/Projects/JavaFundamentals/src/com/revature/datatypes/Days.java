package com.revature.datatypes;

public enum Days {
	MONDAY {
		public void live() {
			System.out.println("Mondays are long days");
		}
	},
	TUESDAY {
		public void live() {
			System.out.println("gringo");
		}
	},
	WEDNESDAY{
		 public void live() {
			System.out.println("man");
		}
	},
	THURSDAY {
		public void live() {
			System.out.println("bob");
		}
	},
	FRIDAY{
		public void live() {
			System.out.println("hey!");
		}
	},
	SATURDAY{
		public void live() {
			System.out.println("gobble");
		}
	},
	SUNDAY {
		public void live() {
			System.out.println("sadlife");
		}
	};

	
	
	public abstract void live(); //this method exists
}
