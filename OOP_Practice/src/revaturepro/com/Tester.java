/**
 * 
 */
package revaturepro.com;

/**
 * @author zheng yang
 *
 */
public class Tester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Pikachu chu1 = new Pikachu(6);
		chu1.print();
		Pikachu chu2 = new Pikachu("pika2");
		chu2.print();
		
		
		//setter
		chu2.setSpirit(10);
		chu2.print();
		
		System.out.println(chu2.getSpirit());
		
	}

}
