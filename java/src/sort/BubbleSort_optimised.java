package sort;

import java.util.Arrays;

public class BubbleSort_optimised {
	public static void main(String[] args) {
		int[] arr = { 2, -3, 5, 1, 10, 12 };
		bubblesort(arr);

	}

	public static void bubblesort(int[] arr) {
		int temp = 0;
		boolean flag=false;// ��ʶ����,��ʾ�Ƿ���й�����
		// ð������ ��ʱ�临�Ӷ� O(n^2)
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
				//һ��������û�н������˳�
				break;
			}else{
				flag=false;
			}
			System.out.print("��" + (i + 1) + "�������:");
			System.out.println(Arrays.toString(arr));
		}
	}
}
