package sort;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Arrays;

public class ShellSort {
	/*
	 * 希尔排序也是一种插入排序，它是简单插入排序经过改进之后的一个更高效的版本，也称为缩小增量排序。
	 * 时间复杂度O(nlogn)
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int[] arr = new int[80000];
		 for(int i = 0;i < 80000;i++){
		 arr[i] = (int)(Math.random() * 80000); //自动生成[0,80000)之间的随机数
		 }

		// 排序前的时间:
		Date data = new Date();
		SimpleDateFormat simt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateS = simt.format(data);
		System.out.println("排序前的时间是:" + dateS);

//		shellSort1(arr); // 调用[交换式]排序
		shellSort2(arr); // 调用[移位式]排序

		// 排序后的时间:
		Date data2 = new Date();
		SimpleDateFormat simt2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateS2 = simt2.format(data2);
		System.out.println("排序后的时间是:" + dateS2);
	}
	// 希尔排序[交换式]
	public static void shellSort1(int[] arr) {
		
		int temp = 0;
		int cnt = 0;
		// 1.分组
		for (int grap = arr.length / 2; grap > 0; grap /= 2) {
			for (int i = grap; i < arr.length; i++) {
				// 2.遍历各组中所有的元素(共grap组,每组?个元素),步长是grap
				for (int j = i - grap; j >= 0; j -= grap) {
					if (arr[j] > arr[j + grap]) {
						temp = arr[j];
						arr[j] = arr[j + grap];
						arr[j + grap] = temp;
					}
				}
			}
			//System.out.println("第" + (++cnt) + "轮排序:" + Arrays.toString(arr));
		}
	}
	//// 对交换式的希尔排序进行优化->移位法
	public static void shellSort2(int[] arr) {
		
		// 1.分组
		for (int grap = arr.length / 2; grap > 0; grap /= 2) {
			// 从num个元素,逐个对其所在的组进行直接插入排序
			for(int i=grap;i<arr.length;i++)
			{
				int j=i;//保存待比较的数组索引
				int temp=arr[j];//保存待比较的数组
				if(arr[j]<arr[j-grap])
				{
					while(j-grap>=0&&temp<arr[j-grap])
					{
						//移动
						arr[j]=arr[j-grap];//符合条件就交换
						j-=grap;//与待排元素进行交换的组内元素索引，组内元素间隔相等
					}
				}
				arr[j]=temp;
			}
		}
	}

}
