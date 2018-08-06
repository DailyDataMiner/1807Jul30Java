package com.revature.threads.two;

public class DeadlockExample {
	static class leUniverse{
		public leUniverse(String name) {
			super();
			this.name = name;
		}

		String name;
	}
	
	public static class immovable extends leUniverse{

		public immovable(String name) {
			super(name);
			
		}
		
		public static synchronized void encounter() {
			System.out.println("I have encountered something");
		}
		
	}
	
	public static class unstoppable extends leUniverse{

		public unstoppable(String name) {
			super(name);
			// TODO Auto-generated constructor stub
		}
		
		public static synchronized void encounter() {
			System.out.println("Something has encounter me");
		}
		
	}
	public static void main(String[] args) {
		final immovable Blob = new immovable ("Blob");
		final unstoppable Jug = new unstoppable("Jugger");
		new Thread(new Runnable() {
			public void Run() {Blob.encounter();}

			@Override
			public void run() {
				// TODO Auto-generated method stub
				
			}
		}).start();
	}

}
