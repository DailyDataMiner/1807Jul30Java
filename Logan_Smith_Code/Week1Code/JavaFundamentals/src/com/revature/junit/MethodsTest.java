/**
 * 
 */
package com.revature.junit;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author lorga
 *
 */
public class MethodsTest {

	static Methods m;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		m = new Methods();
		System.out.println("Before Class");

	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		m = null;
		System.out.println("After class");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		System.out.println("Before");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		System.out.println("After");
	}

	/**
	 * Test method for {@link com.revature.junit.Methods#bubbleSort(int[])}.
	 */
	@Test
	public void testBubbleSort() {
		int[] nums = {100, 2, 89, 51, 2, 5, 6, 0};
		int[] expected = {0, 2, 2, 5, 6, 51, 89, 100};
		
		assertArrayEquals(expected, m.bubbleSort(nums));
		assertNotNull(nums);
	}

	/**
	 * Test method for
	 * {@link com.revature.junit.Methods#reverseString(java.lang.String)}.
	 */
	@Test
	public void testReverseString() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.revature.junit.Methods#factorial(int)}.
	 */
	@Test
	public void testFactorial() {
		fail("Not yet implemented");
	}

}
