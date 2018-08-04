package hw.q1;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class Q1Test 
{
	@Test
	public void test() 
	{
		int[] intArray = {1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4};
		int[] expected = {1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4};
		Arrays.sort(expected);
		
		int[] intArray2 = {-10, 4, 200, 94, 0, 1, 23};
		int[] expected2 = {-10, 4, 200, 94, 0, 1, 23};
		Arrays.sort(expected2);
		
		assertArrayEquals(BubbleSort.sort(intArray), expected);
		assertArrayEquals(BubbleSort.sort(intArray2), expected2);
	}
}
