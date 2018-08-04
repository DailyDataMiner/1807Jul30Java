/**
 * 
 */
package com.revature.JUnit;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author vienl
 *
 */
public class MethodsTest {
	
	Methods m;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("before class");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("after class");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		m = new Methods();
		System.out.println("before");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		m = null;
		System.out.println("after");
	}

	/**
	 * Test method for {@link com.revature.JUnit.Methods#bubbleSort(int[])}.
	 */
	@Test
	public void testBubbleSort() {
		int[] arr = {100, 2, 89, 51, 2, 6, 0};
		m.bubbleSort(arr);
		int[] expected = {100, 2, 89, 51, 2, 6, 0};

		Arrays.sort(expected);
		assertArrayEquals(expected, arr);
		assertNotNull(arr);
	}

	/**
	 * Test method for {@link com.revature.JUnit.Methods#reverseString(java.lang.String)}.
	 */
	@Test
	public void testReverseString() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.revature.JUnit.Methods#factorial(int)}.
	 */
	@Test
	public void testFactorial() {
		fail("Not yet implemented");
	}

}
