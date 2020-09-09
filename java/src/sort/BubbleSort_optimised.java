package sort;

import java.util.Arrays;

public class BubbleSort_optimised {
	public static void main(String[] args) {
		int[] arr = { 2, -3, 5, 1, 10, 12 };
		bubblesort(arr);

	}

	public static void bubblesort(int[] arr) {
		int temp = 0;
		boolean flag=false;// 标识变量,表示是否进行过交换
		// 冒泡排序 的时间复杂度 O(n^2)
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr.length - 1 - i; j++) {
				if (arr[j] > arr[j + 1]) {
					flag=true;
					temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
			if(!flag)
			{
				//一趟排序中没有交换则退出
				break;
			}else{
				flag=false;
			}
			System.out.print("第" + (i + 1) + "趟排序后:");
			System.out.println(Arrays.toString(arr));
		}
	}
}
