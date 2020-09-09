package sort;

import java.util.Arrays;

public class QuickSort {
	// �������� ʱ�临�Ӷ�nlogn   ð�������Ż�����
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { -9, 78, 0, 23, -567, 70 };

		quickSort(arr, 0, arr.length - 1);

		System.out.println("arr����Ľ����:" + Arrays.toString(arr));
	}

	public static void quickSort(int[] arr, int left, int right) {
		int l = left;// ������
		int r = right;// ������
		// middle �м�ֵ
		int middle = arr[(left + right) / 2];
		int temp = 0;// ����ֵ
		// whileѭ����Ŀ��:��,��middle ֵС�ķŵ����,��middle ֵ��ķŵ��ұ�
		while (l < r) {
			// ��middle������ң�����ҵ���middle��ģ����˳�whileѭ��
			while (arr[l] < middle) {
				l++;// l�����ƶ�
			}
			// ��middle���ұ��ң�����ҵ���middleС�ģ����˳�whileѭ��
			while (arr[r] > middle) {
				r--;// r�����ƶ�
			}
			// �������l >= r,��˵��middlet ����������ֵ���Ѿ��������ȫ����
			// С�ڵ���middleֵ,�ұ�ȫ���Ǵ��ڵ���middleֵ.
			if (l >= r) {
				break;
			}
			// ���ݽ���
			temp = arr[l];
			arr[l] = arr[r];
			arr[r] = temp;
			// ��������if��Ҫ��Ϊ�˵ݹ�ʱ�˳����whileѭ������ֹ��ѭ�� ������ l>r����ѭ��
			// // ����������,�������arr[l] == middleֵ,��� r--, ǰ��
			if (arr[l] == middle) {
				r--;
			}
			// // ����������,�������arr[r] == middleֵ,��� l++, ǰ��
			if (arr[r] == middle) {
				l++;
			}

		}
		// ���r==l����Ҫ��r--��l++���������ջ���������ݹ���������
		if (r == l) {
			r--;
			l++;
		}
		// ��ݹ�
		if (left < r) {
			quickSort(arr, left, r);
		}
		// �ҵݹ�
		if (right > l) {
			quickSort(arr, l, right);
		}

	}

}
