package advancedtopics;

public class GarbageDriver {

	public static void main(String[] args) {
		System.out.println("Instantiating an unused object");
		
		GarbageDriver obj = new GarbageDriver();
		System.out.println("object created. about to sleep...");
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		obj=null;
		System.gc();
		
	System.out.println("at the end of main method");
	}
	
	@Override
	protected void finalize() throws Throwable {
		super.finalize();
		System.out.println("Goodbye cruel world, I'm leaving you today");
	}
}
