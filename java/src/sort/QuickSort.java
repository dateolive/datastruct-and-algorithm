package sort;

import java.util.Arrays;

public class QuickSort {
	// 快速排序 时间复杂度nlogn   冒泡排序优化而来
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { -9, 78, 0, 23, -567, 70 };

		quickSort(arr, 0, arr.length - 1);

		System.out.println("arr排序的结果是:" + Arrays.toString(arr));
	}

	public static void quickSort(int[] arr, int left, int right) {
		int l = left;// 左索引
		int r = right;// 右索引
		// middle 中间值
		int middle = arr[(left + right) / 2];
		int temp = 0;// 交换值
		// while循环的目的:让,比middle 值小的放到左边,比middle 值大的放到右边
		while (l < r) {
			// 在middle的左边找，如果找到比middle大的，则退出while循环
			while (arr[l] < middle) {
				l++;// l向右移动
			}
			// 在middle的右边找，如果找到比middle小的，则退出while循环
			while (arr[r] > middle) {
				r--;// r向左移动
			}
			// 如果发现l >= r,则说明middlet 的左右两的值，已经按照左边全部是
			// 小于等于middle值,右边全部是大于等于middle值.
			if (l >= r) {
				break;
			}
			// 数据交换
			temp = arr[l];
			arr[l] = arr[r];
			arr[r] = temp;
			// 下面两个if主要是为了递归时退出这个while循环，防止死循环 交换后 l>r跳出循环
			// // 如果交换完后,发现这个arr[l] == middle值,相等 r--, 前移
			if (arr[l] == middle) {
				r--;
			}
			// // 如果交换完后,发现这个arr[r] == middle值,相等 l++, 前移
			if (arr[r] == middle) {
				l++;
			}

		}
		// 如果r==l，需要将r--，l++，否则会有栈溢出，下面递归会出现问题
		if (r == l) {
			r--;
			l++;
		}
		// 左递归
		if (left < r) {
			quickSort(arr, left, r);
		}
		// 右递归
		if (right > l) {
			quickSort(arr, l, right);
		}

	}

}
