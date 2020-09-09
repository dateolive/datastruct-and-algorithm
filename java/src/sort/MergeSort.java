package sort;

import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 8, 4, 5, 7, 1, 3, 6, 2 };
		int temp[] = new int[arr.length]; // �鲢������Ҫһ������ռ�
		mergeSort(arr, 0, arr.length - 1, temp);
		System.out.println("�鲢����Ľ��:" + Arrays.toString(arr));
	}

	// ��+�͵ķ���
	public static void mergeSort(int[] arr, int left, int right, int[] temp) {
		if (left < right) {
			int mid = (left + right) / 2;
			// ����ݹ�
			mergeSort(arr, left, mid, temp);
			// ���ҵݹ�
			mergeSort(arr, mid + 1, right, temp);
			// �ϲ�
			merge(arr, left, mid, right, temp);
		}
	}

	// �ϲ��ķ���
	/**
	 * 
	 * @param arr
	 *            �����ԭʼ����
	 * @param left
	 *            ����������еĳ�ʼ����
	 * @param mid
	 *            �м�����
	 * @param right
	 *            �ұ�����
	 * @param temp
	 *            ��ת������
	 */
	public static void merge(int[] arr, int left, int mid, int right, int[] temp) {
		int i = left; // ��ʼ��i, ����������еĳ�ʼ����
		int j = mid + 1; // ��ʼ��j, �ұ��������еĳ�ʼ����
		int t = 0; // ָ��temp����ĵ�ǰ����

		// һ��
		// �Ȱ���������(����)�����ݰ��չ�����䵽temp����
		// ֱ���������ߵ���������,��һ�ߴ������Ϊֹ
		while (i <= mid && j <= right) {
			if (arr[i] > arr[j]) {
				temp[t] = arr[j];
				t++;
				j++;
			} else {
				temp[t] = arr[i];
				t++;
				i++;
			}
		}

		// ����
		// ����ʣ�����ݵ�һ�ߵ���������ȫ����䵽temp
		// ��ߵ��������л���ʣ���Ԫ��,��ȫ����䵽temp
		while (i <= mid) {
			temp[t] = arr[i];
			i++;
			t++;
		}
		// �ұߵ��������л���ʣ���Ԫ��,��ȫ����䵽temp
		while (j <= right) {
			temp[t] = arr[j];
			j++;
			t++;
		}
		// ����
		// ��temp�����Ԫ�ؿ�����arr,ע��,������ÿ�ζ�������������
		t = 0;
		int tempindex = left;
		while (tempindex <= right) {
			arr[tempindex] = temp[t];
			t++;
			tempindex++;
		}

	}

}
