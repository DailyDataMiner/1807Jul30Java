package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import question1.BubbleSort;
import question2.Fibonacci;
import question3.StringReverse;

public class QuestionTester {

	static QuestionTester qt;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	
		qt = new QuestionTester();
	
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		
		qt = null;
		
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testBubbleSort() {
		BubbleSort bub = new BubbleSort();
		int[] toSort = { 1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4 };
		int[] expected = {0, 1, 2, 3, 3, 4, 5, 6, 7, 8, 9};
		
		assertArrayEquals(expected, bub.bubbleSort(toSort));
	}
	
	@Test
	public void testStringReverse() {
		StringReverse sr = new StringReverse();
		String toReverse = "Hello!";
		String expected = "!olleH";
		
		assertEquals(expected, sr.reverser(toReverse));
	}

}
