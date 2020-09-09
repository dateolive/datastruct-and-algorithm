package search;

import java.util.Arrays;

public class FibonacciSearch {
	
	public static int maxSize=20;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 1, 8, 10, 89, 1000,89, 1234 };
		System.out.println("index = " + fibS(arr, 89));
	}
	// 用非递归方法得到一个斐波那契数列
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
	 * 使用非递归的方式编写斐波那契算法
	 * @param arr  数组
	 * @param value 查找的值
	 * @return 值的下标
	 */
	public static int fibS(int[] arr,int value)
	{
		int low=0;
		int hight=arr.length-1;
		int mid=0;
		int k=0;// 斐波那契数列的下标
		int[] f=fibonacci();
		// 获取到斐波那契分割数值的下标
		while(hight>f[k]-1)
			k++;
		//因为f[k]的值可能大于arr的长度，所以我们需要使用Arrays类,构造一个新的数组,并指向temp[]
		int[] temp=Arrays.copyOf(arr, f[k]);
		//不足的部门用arr数组最后的元素替代
		for(int i=hight+1;i<temp.length;i++)
		{
			temp[i]=arr[hight];
		}
		//循环找到value
		while(low<=hight)
		{
			mid=low+f[k-1]-1;
			//如果要找的值小于mid对应的值，则向左边寻找
			if(value<temp[mid])
			{
				hight=mid-1;
				// 使用k--的原因
				// 说明:
				// 1.全部元素 = 前面的元素 + 后边元素
				// 2.f[k] = f[k-1] + f[k-2]
				// 因为 前面有 f[k-1]个元素,所以可以继续拆分 f[k-1] = f[k-2] + f[k-3]
				// 即 在 f[k-1] 的前面继续查找 k--
				// 即下次循环 mid = f[k-1-1]-1
				k-=1;
			}
			//如果要找的值大于mid对应的值，则向右边寻找
			else if(value>temp[mid])
			{
				low=mid+1;
				// 使用k -= 2 的原因
				// 说明
				// 1.全部元素 = 前面的元素 + 后边元素
				// 2.f[k] = f[k-1] + f[k-2]
				// 3.因为后面我们有f[k-2] 所以可以继续拆分 f[k-1] = f[k-3] + f[k-4]
				// 4.即在f[k-2] 的前面进行查找 k -= 2
				// 5.即下次循环 mid = f[k - 1 - 2] - 1
				k-=2;
			}else{
				//需要确定返回的是哪个下标
				if(mid<=hight)
					return mid;
				else
					return hight;
			}
		}
		return -1;
	}
	
}
