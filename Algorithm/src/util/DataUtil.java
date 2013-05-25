package util;

import java.util.Random;

public class DataUtil
{
	public static int[] getData(int size)
	{
		int[] arr = new int[size];
		Random random = new Random();
		for(int i = 0; i < size; i++)
		{
			arr[i] = random.nextInt(size * 10);
		}
		return arr;
	}
}
