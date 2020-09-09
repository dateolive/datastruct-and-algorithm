package search;

import java.awt.List;
import java.util.ArrayList;

public class BinarySearch {
	// ע��:ʹ�ö��ֲ��ҵ�����,����������ġ�
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
		// ��left > rightʱ,�������ѯ����
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

	// ��һ�����������У��ж����ͬ����ֵʱ����ν����е���ֵ�����ҵ������������ 1000.
	// ˼·����:
	// 1.���ҵ�midʱ,�����Ϸ���
	// 2.��mid����ֵ�����ɨ��,���������� 1000��Ԫ�ص��±꣬���뵽����ArrayList��
	// 3.��mid����ֵ���ұ�ɨ��,���������� 1000��Ԫ�ص��±꣬���뵽����ArrayList��
	// 4.����ArrayList����
	public static ArrayList<Integer> binarySearch2(int[] arr, int left,
			int right, int value) {
		// ��left > rightʱ,�������ѯ����
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
			// ��mid����ֵ�����ɨ��,���������� 1000��Ԫ�ص��±꣬���뵽����ArrayList��
			int temp = mid - 1;
			while (true) {
				if (temp < 0 || arr[temp] != value)
					break;
				reget.add(temp);
				temp--;// ����
			}
			reget.add(mid);// ���ҵ����м��±�д��
			// ��mid����ֵ���ұ�ɨ��,���������� 1000��Ԫ�ص��±꣬���뵽����ArrayList��
			temp = mid + 1;
			while (true) {
				if (temp > arr.length - 1 || arr[temp] != value)
					break;
				reget.add(temp);
				temp++;// ����
			}
			return reget;

		}
	}

}
