package sort;

import java.util.Arrays;

public class InsertSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 101, 34, 119, 1, -1, 89, 25 };
		sort(arr);
	}
	//��������
	//����������ٶ�:O(n^2)
	public static void sort(int[] arr){
		
		for(int i=1;i<arr.length;i++)
		{
			int insertVal=arr[i];
			int insertindex=i-1;
			while(insertindex>=0&&insertVal<arr[insertindex])
			{
				arr[insertindex+1]=arr[insertindex];
				insertindex--;
			}
			arr[insertindex+1]=insertVal;
			System.out.print("��"+ i +"�ֲ���:");
			System.out.println(Arrays.toString(arr));
		}
		
	}
}
