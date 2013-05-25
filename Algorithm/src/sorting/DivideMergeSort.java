package sorting;

import util.DataUtil;
import util.LogUtil;

/**
 * 分治-合并排序
 * @author troyz
 * ///需要额外的空间
 */
public class DivideMergeSort
{
	public static void main(String[] args)
	{
		int[] arr = DataUtil.getData(100000000);
		//LogUtil.log(arr, true);
		long start = System.currentTimeMillis();
		divideMergeSort(arr, 0, arr.length - 1);
		long end = System.currentTimeMillis();
		//LogUtil.log(arr, true);
		System.out.println("cost: " + (end - start));
	}

	private static void divideMergeSort(int[] arr, int p, int r)
	{
		if(p < r)
		{
			int q = (p + r) / 2;
			divideMergeSort(arr, p, q);
			divideMergeSort(arr, q + 1, r);
			mergeSort(arr, p, q, r);
		}
	}

	private static void mergeSort(int[] arr, int p, int q, int r)
	{
		int llen = q - p + 1;
		int rlen = r - q;
		int[] left = new int[llen];
		int[] right = new int[rlen];
		for(int i = p; i <= q; i++)
		{
			left[i - p] = arr[i];
		}
		for(int i = q + 1; i <= r; i++)
		{
			right[i - q - 1] = arr[i];
		}
		int lp = 0, rp = 0;
		for(int i = p; i <= r; i++)
		{
			if(rp >= right.length || (lp < left.length && left[lp] < right[rp]))
			{
				arr[i] = left[lp++];
			}
			else
			{
				arr[i] = right[rp++];
			}
		}
	}
}
