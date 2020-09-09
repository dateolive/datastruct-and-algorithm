package sort;

import java.util.Arrays;

public class RadixSort {
	// ����������ʹ�ÿռ任ʱ��ľ����㷨
	/**
	 * 1.���������ǶԴ�ͳͰ�������չ���ٶȺܿ�.
	 * 2.���������Ǿ���Ŀռ任ʱ��ķ�ʽ��ռ���ڴ�ܴ�,���Ժ�����������ʱ���������OutOfMemoryError��
	 * 3.��������ʱ�ȶ��ġ�[ע:�ٶ��ڴ�����ļ�¼�����д��ڶ��������ͬ�Ĺؼ��ֵļ�¼��
	 * ������������Щ��¼����Դ��򱣳ֲ��䣬����ԭ�����У�r[i]=r [j]����r[i]��r[j]֮ǰ��
	 * ���������������У�r[i]����r[j]֮ǰ��������������㷨���ȶ��ģ������Ϊ���ȶ���]
	 * 4.�и��������飬���ǲ��û�����������������,���Ҫ֧�ָ�������Ҫ��������ת��Ϊ������������ж�
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 53, 3, 542, 748, 14, 214 };
		radixSort(arr); // ���û�������
	}

	public static void radixSort(int[] arr) {
		// 1.�����ȵõ�������������
		int max = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}
		}
		// 2.֮������������������λ���Ƕ��٣�����ͨ��ת���ַ������㳤��
		int maxlen = (max + "").length();
		// 3.����һ����ά���飬��ʾ10��Ͱ0-9
		// Ϊ�˷�ֹ�ڷ�������ʱ��,�������,��ÿ��һά����(Ͱ),��С��Ϊarr.length
		int[][] bucket = new int[10][arr.length];

		// 4.����һ��һά���飬������ÿ��Ͱ�е����ݸ���
		int[] bucketsize = new int[10];

		// 5.
		for (int i = 0, n = 1; i < maxlen; i++, n *= 10) {
			// ��ÿ��Ԫ�صĸ�λ��������,��һ���Ǹ�λ,�ڶ�����ʮλ,�������ǰ�λ.
			for (int j = 0; j < arr.length; j++) {
				// ȡ��ÿ��Ԫ�صĶ�Ӧλ��ֵ
				int digt = arr[j] / n % 10;
				// ���뵽��Ӧ��Ͱ��
				bucket[digt][bucketsize[digt]] = arr[j];
				bucketsize[digt]++;
			}
			// �������Ͱ��˳��(��һά������±�����ȡ������,����ԭ������)
			int index = 0;
			// ����ÿһ��Ͱ����ÿ��Ͱ����������ȡ��������ԭ����
			for (int k = 0; k < bucketsize.length; k++) {
				// ���Ͱ��������,�ŷ���ԭ����
				if (bucketsize[k] != 0) {
					// Ͱ�е�����ȡ��������arr������
					for (int m = 0; m < bucketsize[k]; m++) {
						arr[index++] = bucket[k][m];
					}
				}
				// ������ÿһ��Ͱ����Ҫ����Ͱ����
				bucketsize[k] = 0;
			}
			System.out.println("��" + (i + 1) + "������:" + Arrays.toString(arr));
		}

	}
}
