package sorting;

import util.DataUtil;
import util.LogUtil;

public class HeapSort
{
	public static void main(String[] args)
	{
		int[] arr = DataUtil.getData(100000000);
		//LogUtil.log(arr);
		long start = System.currentTimeMillis();
		heapSort(arr);
		long end = System.currentTimeMillis();
		//LogUtil.log(arr);
		System.out.println("cost: " + (end - start));
	}
	private static int heapSize;
	private static void heapSort(int[] arr)
	{
		heapSize = arr.length;
		buildMaxHeap(arr);
		while(heapSize >= 1)
		{
			int tmp = arr[heapSize - 1];
			arr[heapSize - 1] = arr[0];
			arr[0] = tmp;
			heapSize--;
			maxHeap(arr, 0);
		}
	}
	private static void buildMaxHeap(int[] arr)
	{
		for(int i = heapSize / 2 -1; i >= 0; i--)
		{
			maxHeap(arr, i);	
		}
	}
	private static void maxHeap(int[] arr, int i)
	{
		int l = leftChildIndex(i);
		int r = rightChildIndex(i);
		int largest = i;
		if(l < heapSize && arr[l] > arr[largest])
		{
			largest = l;
		}
		if(r < heapSize && arr[r] > arr[largest])
		{
			largest = r;
		}
		if(largest != i)
		{
			int tmp = arr[i];
			arr[i] = arr[largest];
			arr[largest] = tmp;
			maxHeap(arr, largest);
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