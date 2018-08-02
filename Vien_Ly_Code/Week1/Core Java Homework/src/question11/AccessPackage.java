package question11;

import question11class.DummyClass;

public class AccessPackage {

	public static void main(String[] args) {
		DummyClass a = new DummyClass(5.2f, 9.2f);
		DummyClass b = new DummyClass(1.2f, 2.5f);
		
		System.out.println(a.getA());
		System.out.println(a.getB());
		System.out.println(b.getA());
		System.out.println(b.getB());
	}

}
