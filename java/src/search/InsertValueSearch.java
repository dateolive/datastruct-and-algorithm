package search;

public class InsertValueSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 1, 8, 10, 89, 1000,1000, 1234 };
		int serch = insertValueSearch(arr, 0, arr.length - 1, 1000);
		System.out.println("serch = " + serch);
	}

	/**
	 * ��ֵ�����㷨,ҲҪ�������������!!!
	 * 
	 * @Description ��ֵ�����㷨
	 * @author �ζ���
	 * @date 2020��8��21������9:43:59
	 * @param arr
	 *            ����
	 * @param left
	 *            ��ߵ�����
	 * @param right
	 *            �ұߵ�����
	 * @param value
	 *            ���ҵ�ֵ
	 * @return ����ҵ�,�ͷ��ض�Ӧ���±�,���û���ҵ�,����-1
	 */
	public static int insertValueSearch(int[] arr, int left, int right,
			int value) {
		// ע�⣺value < arr[0] �� value > arr[arr.length - 1] ������Ҫ
		// ���򽫻�õ��� mid����Խ��
		if (left > right || value > arr[arr.length - 1] || value < arr[0]) {
			return -1;
		}
		/*
		 * ��ֵ���ҵĺ�����mid������Ӧ
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
