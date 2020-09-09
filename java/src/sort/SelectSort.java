package sort;

import java.util.Arrays;

public class SelectSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr={1,3,8,-20,2};
		sort(arr);
		

	}
	//ѡ������
	// ���Ƶ�������,ͨ������ֱ��ѭ�����
	// ѡ�������ʱ�临�Ӷ�O(n^2)
	/*
	 * ˵����
    1. ѡ������һ���� �����С - 1 ������
    2. ÿ1����������һ��ѭ��, ѭ���Ĺ���(���������)
	2.1 �ȼٶ���ǰ���������С��
	2.2 Ȼ��ͺ����ÿ�������бȽϣ���������бȵ�ǰ����С������������ȷ����С�������õ��±�
	2.3 ����������������ʱ���͵õ�������С�����±�
	2.4 ���� [���������]
	 * 
	 * 
	 * */
	public static void sort(int[] arr){
		
		for(int i=0;i<arr.length-1;i++)
		{
			int min=arr[i];//���Oĳ��ֵ����Сֵ
			int minindex=i;
			for(int j=i+1;j<arr.length;j++)
			{
				if(min>arr[j])
				{
					min=arr[j];
					minindex=j;
				}
			}
			if(minindex!=i)
			{
				arr[minindex]=arr[i];
				arr[i]=min;
			}
			System.out.print("��" + (i+1) + "�ֺ�:");
			System.out.println(Arrays.toString(arr));
		}
		
	}

}
