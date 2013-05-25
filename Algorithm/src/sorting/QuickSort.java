package sorting;

import java.util.Random;

import util.DataUtil;
/**
 * 快速排序
 * @author troyz
 * 
 */
public class QuickSort
{
	public static void main(String[] args)
	{
		for(int i = 0; i < 1; i++)
		{
			int[] arr = DataUtil.getData(10000000);
			//LogUtil.log(arr);
			long start = System.currentTimeMillis();
			//quickSortRight(arr, 0, arr.length - 1);
			//quickSortLeft(arr, 0, arr.length - 1);
			quickSortRandom(arr, 0, arr.length - 1);
			long end = System.currentTimeMillis();
			System.out.println("cost: " + (end - start));
			//LogUtil.log(arr);
		}
	}

	/**
	 * 以最右边的元素作为基点
	 * @param arr
	 */
	private static void quickSortRight(int[] arr, int p, int r)
	{
		if(p >= r || p < 0 || r >= arr.length)
		{
			return;
		}
		
		int i = p - 1;
		for(int j = p; j < r; j++)
		{
			if(arr[j] <= arr[r])
			{
				i++;
				int tmp = arr[j];
				arr[j] = arr[i];
				arr[i] = tmp;
			}
			
		}
		int tmp = arr[r];
		arr[r] = arr[i + 1];
		arr[i + 1] = tmp;
		
		// 此时i+1左边的元素比它小, 右边的元素比它大
		
		// 下面再递归排序左边和右边
		quickSortRight(arr, p, i);
		quickSortRight(arr, i + 2, r);
	}
	
	/**
	 * 以最左边的元素作为基点
	 * @param arr
	 */
	private static void quickSortLeft(int[] arr, int p, int r)
	{
		if(p >= r || p < 0 || r >= arr.length)
		{
			return;
		}
		
		int i = p;
		for(int j = p + 1; j <= r; j++)
		{
			if(arr[j] <= arr[p])
			{
				i++;
				int tmp = arr[j];
				arr[j] = arr[i];
				arr[i] = tmp;
			}
			
		}
		int tmp = arr[p];
		arr[p] = arr[i];
		arr[i] = tmp;
		
		// 此时i+1左边的元素比它小, 右边的元素比它大
		
		// 下面再递归排序左边和右边
		quickSortLeft(arr, p, i - 1);
		quickSortLeft(arr, i + 1, r);
	}
	
	/**
	 * 以随机的元素作为基点
	 * @param arr
	 */
	private static void quickSortRandom(int[] arr, int p, int r)
	{
		if(p >= r || p < 0 || r >= arr.length || p >= arr.length)
		{
			return;
		}
		
		int pos = new Random().nextInt(r - p) + p;
		
		// 先将pos与r交换, 然后以右元素为基点
		int _tmp = arr[r];
		arr[r] = arr[pos];
		arr[pos] = _tmp;
		
		int i = p - 1;
		for(int j = p; j < r; j++)
		{
			if(arr[j] <= arr[r])
			{
				i++;
				int tmp = arr[j];
				arr[j] = arr[i];
				arr[i] = tmp;
			}
			
		}
		int tmp = arr[r];
		arr[r] = arr[i + 1];
		arr[i + 1] = tmp;
		
		quickSortRandom(arr, p, i);
		quickSortRandom(arr, i + 2, r);
	}
}