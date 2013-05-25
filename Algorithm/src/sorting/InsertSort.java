package sorting;

import util.DataUtil;
import util.LogUtil;

/**
 * 插入排序
 * @author troyz
 */
public class InsertSort
{
	public static void main(String[] args)
	{
		int[] arr = DataUtil.getData(1000000);
		LogUtil.log(arr, true);
		long start = System.currentTimeMillis();
		insertSort(arr);
		long end = System.currentTimeMillis();
		System.out.println("cost " + (end - start));
		LogUtil.log(arr, true);
	}

	private static void insertSort(int[] arr)
	{
		for(int i = 0; i < arr.length; i++)
		{
			int value = arr[i];
			int j = i - 1;
			for(j = i - 1; j >= 0 && arr[j] > value; j--)
			{
				arr[j + 1] = arr[j];
			}
			arr[j + 1] = value;
		}
	}
}