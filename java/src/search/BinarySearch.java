package search;

import java.awt.List;
import java.util.ArrayList;

public class BinarySearch {
	// 注意:使用二分查找的数组,必须是有序的。
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * int arr[] = {1,8, 10, 89, 1000, 1234}; int serch = binarySearch1(arr,
		 * 0, arr.length - 1, 11); System.out.println("serch = " + serch);
		 */
		int arr[] = { 1, 8, 10, 89, 1000, 1000, 1234 };

		ArrayList<Integer> reget = binarySearch2(arr, 0, arr.length - 1, 1000);
		System.out.println("reget = " + reget);
	}

	public static int binarySearch1(int[] arr, int left, int right, int value) {
		// 当left > right时,该数组查询不到
		if (left > right)
			return -1;
		int mid = (left + right) / 2;
		int midval = arr[mid];
		if (value > midval)
			return binarySearch1(arr, mid + 1, right, value);
		else if (value < midval)
			return binarySearch1(arr, left, mid - 1, value);
		else
			return midval;
	}

	// 当一个有序数组中，有多个相同的数值时，如何将所有的数值都查找到，比如这里的 1000.
	// 思路分析:
	// 1.在找到mid时,不马上返回
	// 2.向mid索引值的左边扫描,将所有满足 1000的元素的下标，加入到集合ArrayList中
	// 3.向mid索引值的右边扫描,将所有满足 1000的元素的下标，加入到集合ArrayList中
	// 4.返回ArrayList集合
	public static ArrayList<Integer> binarySearch2(int[] arr, int left,
			int right, int value) {
		// 当left > right时,该数组查询不到
		if (left > right)
			return new ArrayList<Integer>();
		int mid = (left + right) / 2;
		int midval = arr[mid];
		if (value > midval)
			return binarySearch2(arr, mid + 1, right, value);
		else if (value < midval)
			return binarySearch2(arr, left, mid - 1, value);
		else {
			ArrayList<Integer> reget = new ArrayList<Integer>();
			// 向mid索引值的左边扫描,将所有满足 1000的元素的下标，加入到集合ArrayList中
			int temp = mid - 1;
			while (true) {
				if (temp < 0 || arr[temp] != value)
					break;
				reget.add(temp);
				temp--;// 后移
			}
			reget.add(mid);// 将找到的中间下标写入
			// 向mid索引值的右边扫描,将所有满足 1000的元素的下标，加入到集合ArrayList中
			temp = mid + 1;
			while (true) {
				if (temp > arr.length - 1 || arr[temp] != value)
					break;
				reget.add(temp);
				temp++;// 后移
			}
			return reget;

		}
	}

}
