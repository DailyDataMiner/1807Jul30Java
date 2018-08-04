package hw.q1;

public class BubbleSort 
{
	public static int[] sort(int[] a) 
	{
		int[] intArray = new int[a.length];
		for (int i = 0; i < intArray.length; i++)
		{
			intArray[i] = a[i];
		}
		
		boolean swapped = true;
		
		while (swapped)
		{
			swapped = false;
			for (int i = 0; i < intArray.length - 1; i++)
			{
				if (intArray[i] > intArray[i + 1])
				{
					int temp = intArray[i];
					intArray[i] = intArray[i + 1];
					intArray[i + 1] = temp;
					swapped = true;
				}
			}
		}
		return intArray;
	}
}
