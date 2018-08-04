package hw.q20;

import java.io.BufferedReader;
import java.io.FileReader;

public class DisplayData 
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new FileReader("src/hw/q20/Data.txt"));
		String line = "";
		while ((line = br.readLine()) != null)
		{
			String[] sArray = line.split(":");
			System.out.println("Name: " + sArray[0] + " " + sArray[1] + "\nAge: " + 
					sArray[2] + " years\nState: " + sArray[3] + " State\n");
		}
	}
}
