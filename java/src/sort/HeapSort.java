package sort;

import java.util.Arrays;

//堆排序
/*
 * 一般升序采用大顶堆，降序采用小顶堆
 * 
 * 1.将待排序序列构造成一个大顶堆
 2.此时，整个序列的最大值就是堆顶的根节点。
 3.将其与末尾元素进行交换，此时末尾就为最大值。
 4.然后将剩余n-1个元素重新构造成一个堆，这样会得到n个元素的次小值。如此反复执行，便能得到一个有序序列了。

 可以看到在构建大顶堆的过程中，元素的个数逐渐减少，最后就得到一个有序序列了.
大顶堆特点：arr[i] >= arr[2*i+1] && arr[i] >= arr[2*i+2]  // i 对应第几个节点，i从0开始编号7

小顶堆：arr[i] <= arr[2*i+1] && arr[i] <= arr[2*i+2] // i 对应第几个节点，i从0开始编号
 */
public class HeapSort {

	/**
	 * 步骤一:构造初始堆。将给定无序序列构造成一个大顶堆（一般升序采用大顶堆，降序采用小顶堆)。原始的数组[4,6,8,5,9]
	 * 步骤二:将堆顶元素与末尾元素进行交换，使末尾元素最大。然后继续调整堆，再将堆顶元素与末尾元素交换,得到第二大元素。如此反复进行交换、重建、交换。
	 * 对上述思路进行总结:
1.将无序序列构建成一个堆，根据升序降序需求选择大顶堆或小顶堆; 
2.将堆顶元素与末尾元素交换，将最大元素"沉"到数组末端; 
3.重新调整结构，使其满足堆定义，然后继续交换堆顶元素与当前末尾元素，反复执行调整+交换步骤， 直到整个序列有序。
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]={4,6,8,5,9};
		heapSort(arr);
	}
	
	public static void heapSort(int[] arr){
		System.out.println("堆排序");
		int temp=0;
		//1.将无序序列构建成一个堆,根据升序降序需求选择大顶堆或小顶堆
		for(int i=arr.length/2-1;i>=0;i--)
		{
			adjustHeap(arr, i, arr.length);
		}
		//2.将堆顶元素与末尾元素交换,将最大元素"沉"到数组末端;
		//3.重新调整结构,使其满足堆定义,然后继续交换堆顶元素与当前末尾元素,反复执行调整+交换步骤,直到整个序列有序。
		for(int j=arr.length-1;j>0;j--)
		{
			temp=arr[j];
			arr[j]=arr[0];
			arr[0]=temp;
			adjustHeap(arr, 0, j);
		}
		System.out.println("大顶堆排序后"+Arrays.toString(arr));
	}
	/**
	 * 功能: 完成 将 以 i 对应的非叶子结点的树调整成大顶堆
	 * 
	 * @param arr 带排序的数组
	 * @param i 非叶子节点的索引
	 * @param length 要调整的元素个数
	 */
	public static void adjustHeap(int[] arr,int i,int length){
		//把非叶子节点的值保存下来
		int temp=arr[i];
		//说明:
		//1. j = i * 2 + 1 j 是 i结点的左子结点
		for(int j=i*2+1;j<length;j=j*2+1)
		{
			//说明左子节点的值小于右子节点的值
			if(j+1<length&&arr[j]<arr[j+1])
			{
				j++;//j指向右子节点
			}
			//如果子节点大于父节点
			if(arr[j]>temp)
			{
				arr[i]=arr[j];//讲较大的值赋给当前的节点
				i=j;//讲i指向j，继续循环
				
			}else{
				break;
			}
			// 当for 循环结束后,已经将以 i 为父结点的树的最大值,放在了最顶(局部)
			arr[i] = temp;
		}
		
	}

}
