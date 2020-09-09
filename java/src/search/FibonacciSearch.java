package search;

import java.util.Arrays;

public class FibonacciSearch {
	
	public static int maxSize=20;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 1, 8, 10, 89, 1000,89, 1234 };
		System.out.println("index = " + fibS(arr, 89));
	}
	// �÷ǵݹ鷽���õ�һ��쳲���������
	public static int[] fibonacci()
	{
		int[] f=new int[maxSize];
		f[0]=1;
		f[1]=1;
		for(int i=2;i<maxSize;i++)
			f[i]=f[i-1]+f[i-2];
		return f;
	}
	
	/**
	 * ʹ�÷ǵݹ�ķ�ʽ��д쳲������㷨
	 * @param arr  ����
	 * @param value ���ҵ�ֵ
	 * @return ֵ���±�
	 */
	public static int fibS(int[] arr,int value)
	{
		int low=0;
		int hight=arr.length-1;
		int mid=0;
		int k=0;// 쳲��������е��±�
		int[] f=fibonacci();
		// ��ȡ��쳲������ָ���ֵ���±�
		while(hight>f[k]-1)
			k++;
		//��Ϊf[k]��ֵ���ܴ���arr�ĳ��ȣ�����������Ҫʹ��Arrays��,����һ���µ�����,��ָ��temp[]
		int[] temp=Arrays.copyOf(arr, f[k]);
		//����Ĳ�����arr��������Ԫ�����
		for(int i=hight+1;i<temp.length;i++)
		{
			temp[i]=arr[hight];
		}
		//ѭ���ҵ�value
		while(low<=hight)
		{
			mid=low+f[k-1]-1;
			//���Ҫ�ҵ�ֵС��mid��Ӧ��ֵ���������Ѱ��
			if(value<temp[mid])
			{
				hight=mid-1;
				// ʹ��k--��ԭ��
				// ˵��:
				// 1.ȫ��Ԫ�� = ǰ���Ԫ�� + ���Ԫ��
				// 2.f[k] = f[k-1] + f[k-2]
				// ��Ϊ ǰ���� f[k-1]��Ԫ��,���Կ��Լ������ f[k-1] = f[k-2] + f[k-3]
				// �� �� f[k-1] ��ǰ��������� k--
				// ���´�ѭ�� mid = f[k-1-1]-1
				k-=1;
			}
			//���Ҫ�ҵ�ֵ����mid��Ӧ��ֵ�������ұ�Ѱ��
			else if(value>temp[mid])
			{
				low=mid+1;
				// ʹ��k -= 2 ��ԭ��
				// ˵��
				// 1.ȫ��Ԫ�� = ǰ���Ԫ�� + ���Ԫ��
				// 2.f[k] = f[k-1] + f[k-2]
				// 3.��Ϊ����������f[k-2] ���Կ��Լ������ f[k-1] = f[k-3] + f[k-4]
				// 4.����f[k-2] ��ǰ����в��� k -= 2
				// 5.���´�ѭ�� mid = f[k - 1 - 2] - 1
				k-=2;
			}else{
				//��Ҫȷ�����ص����ĸ��±�
				if(mid<=hight)
					return mid;
				else
					return hight;
			}
		}
		return -1;
	}
	
}
