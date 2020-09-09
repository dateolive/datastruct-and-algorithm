package sort;

import java.util.Arrays;

public class BubbleSort {

	public static void main(String[] args) {
		int[] arr={2,-3,5,1,10,12};
		bubblesort(arr);

	}
	public static void bubblesort(int[] arr)
	{
		int temp=0;
		// 冒泡排序 的时间复杂度 O(n^2)
		for(int i=0;i<arr.length-1;i++)
		{
			for(int j=0;j<arr.length-1-i;j++)
			{
				if(arr[j]>arr[j+1])
				{
					temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				}
			}
			System.out.print("第" + (i + 1) + "趟排序后:");
			System.out.println(Arrays.toString(arr));
		}
	}
}
