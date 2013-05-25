package sorting;

import util.DataUtil;
import util.LogUtil;

public class HeapSort
{
	public static void main(String[] args)
	{
		int[] arr = DataUtil.getData(10);
		LogUtil.log(arr);
		long start = System.currentTimeMillis();
		for(int i = arr.length / 2 -1; i >= 0; i--)
		{
			buildMaxHeap(arr, i);	
		}
		long end = System.currentTimeMillis();
		LogUtil.log(arr);
		System.out.println("cost: " + (end - start));
	}

	private static void buildMaxHeap(int[] arr, int i)
	{
		int l = leftChildIndex(i);
		int r = rightChildIndex(i);
		int largest = i;
		if(l < arr.length && arr[l] > arr[largest])
		{
			largest = l;
		}
		if(r < arr.length && arr[r] > arr[largest])
		{
			largest = r;
		}
		if(largest != i)
		{
			int tmp = arr[i];
			arr[i] = arr[largest];
			arr[largest] = tmp;
			buildMaxHeap(arr, largest);
		}
	}
	private static int parentIndex(int i)
	{
		return (i - 1) / 2;
	}
	private static int leftChildIndex(int i)
	{
		return 2 * i + 1;
	}
	private static int rightChildIndex(int i)
	{
		return 2 * i + 2;
	}
}