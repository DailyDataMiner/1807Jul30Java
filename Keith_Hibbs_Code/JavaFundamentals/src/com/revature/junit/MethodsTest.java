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
 * @author keith
 *
 */
public class MethodsTest {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link com.revature.junit.Methods#bubbleSort(int[])}.
	 */
	@Test
	public void testBubbleSort() {
		int[] nums = {100,2,89,51,2,5,6,0}
		Arrays.sort(nums);;
		assertArrayEquals(nums, m.bubbleSort(nums));
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.revature.junit.Methods#reverseString(java.lang.String)}.
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
