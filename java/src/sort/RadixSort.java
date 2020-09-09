package sort;

import java.util.Arrays;

public class RadixSort {
	// 基数排序是使用空间换时间的经典算法
	/**
	 * 1.基数排序是对传统桶排序的扩展，速度很快.
	 * 2.基数排序是经典的空间换时间的方式，占用内存很大,当对海量数据排序时，容易造成OutOfMemoryError。
	 * 3.基数排序时稳定的。[注:假定在待排序的记录序列中存在多个具有相同的关键字的记录，
	 * 若经过排序，这些记录的相对次序保持不变，即在原序列中，r[i]=r [j]，且r[i]在r[j]之前，
	 * 而在排序后的序列中，r[i]仍在r[j]之前，则称这种排序算法是稳定的；否则称为不稳定的]
	 * 4.有负数的数组，我们不用基数排序来进行排序,如果要支持负数，需要将负数先转化为正数，最后再判断
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 53, 3, 542, 748, 14, 214 };
		radixSort(arr); // 调用基数排序
	}

	public static void radixSort(int[] arr) {
		// 1.首先先得到数组中最大的数
		int max = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}
		}
		// 2.之后计算数组中最大数的位数是多少，可以通过转化字符串计算长度
		int maxlen = (max + "").length();
		// 3.定义一个二维数组，表示10个桶0-9
		// 为了防止在放入数的时候,数据溢出,则每个一维数组(桶),大小定为arr.length
		int[][] bucket = new int[10][arr.length];

		// 4.定义一个一维数组，来计算每个桶中的数据个数
		int[] bucketsize = new int[10];

		// 5.
		for (int i = 0, n = 1; i < maxlen; i++, n *= 10) {
			// 对每个元素的各位进行排序,第一次是个位,第二次是十位,第三次是百位.
			for (int j = 0; j < arr.length; j++) {
				// 取出每个元素的对应位的值
				int digt = arr[j] / n % 10;
				// 放入到对应的桶中
				bucket[digt][bucketsize[digt]] = arr[j];
				bucketsize[digt]++;
			}
			// 按照这个桶的顺序(将一维数组的下标依次取出数据,放入原来数组)
			int index = 0;
			// 遍历每一个桶，将每个桶的数据依次取出，放在原数组
			for (int k = 0; k < bucketsize.length; k++) {
				// 如果桶中有数据,才放入原数组
				if (bucketsize[k] != 0) {
					// 桶中的数据取出，放在arr数组中
					for (int m = 0; m < bucketsize[k]; m++) {
						arr[index++] = bucket[k][m];
					}
				}
				// 处理完每一个桶后，需要将该桶重置
				bucketsize[k] = 0;
			}
			System.out.println("第" + (i + 1) + "轮排序:" + Arrays.toString(arr));
		}

	}
}
