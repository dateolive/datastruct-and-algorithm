package search;

public class InsertValueSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 1, 8, 10, 89, 1000,1000, 1234 };
		int serch = insertValueSearch(arr, 0, arr.length - 1, 1000);
		System.out.println("serch = " + serch);
	}

	/**
	 * 插值查找算法,也要求数组是有序的!!!
	 * 
	 * @Description 插值查找算法
	 * @author 梦独吟
	 * @date 2020年8月21日下午9:43:59
	 * @param arr
	 *            数组
	 * @param left
	 *            左边的索引
	 * @param right
	 *            右边的索引
	 * @param value
	 *            查找的值
	 * @return 如果找到,就返回对应的下标,如果没有找到,返回-1
	 */
	public static int insertValueSearch(int[] arr, int left, int right,
			int value) {
		// 注意：value < arr[0] 和 value > arr[arr.length - 1] 必须需要
		// 否则将会得到的 mid可能越界
		if (left > right || value > arr[arr.length - 1] || value < arr[0]) {
			return -1;
		}
		/*
		 * 插值查找的核心是mid的自适应
		 */
		int mid = left + (right - left) * (value - arr[left])
				/ (arr[right] - arr[left]);
		if (value < arr[mid]) {
			return insertValueSearch(arr, left, mid - 1, value);
		} else if (value > arr[mid]) {
			return insertValueSearch(arr, mid + 1, right, value);
		} else {
			return mid;
		}
	}

}
