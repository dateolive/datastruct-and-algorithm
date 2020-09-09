package sort;

import java.util.Arrays;

public class SelectSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr={1,3,8,-20,2};
		sort(arr);
		

	}
	//选择排序
	// 在推导过程中,通过规律直接循环解决
	// 选择排序的时间复杂度O(n^2)
	/*
	 * 说明：
    1. 选择排序一共有 数组大小 - 1 轮排序
    2. 每1轮排序，又是一个循环, 循环的规则(见下面代码)
	2.1 先假定当前这个数是最小数
	2.2 然后和后面的每个数进行比较，如果发现有比当前数更小的数，就重新确定最小数，并得到下标
	2.3 当遍历到数组的最后时，就得到本轮最小数和下标
	2.4 交换 [见下面代码]
	 * 
	 * 
	 * */
	public static void sort(int[] arr){
		
		for(int i=0;i<arr.length-1;i++)
		{
			int min=arr[i];//假設某個值為最小值
			int minindex=i;
			for(int j=i+1;j<arr.length;j++)
			{
				if(min>arr[j])
				{
					min=arr[j];
					minindex=j;
				}
			}
			if(minindex!=i)
			{
				arr[minindex]=arr[i];
				arr[i]=min;
			}
			System.out.print("第" + (i+1) + "轮后:");
			System.out.println(Arrays.toString(arr));
		}
		
	}

}
