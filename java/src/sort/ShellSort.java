package sort;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Arrays;

public class ShellSort {
	/*
	 * ϣ������Ҳ��һ�ֲ����������Ǽ򵥲������򾭹��Ľ�֮���һ������Ч�İ汾��Ҳ��Ϊ��С��������
	 * ʱ�临�Ӷ�O(nlogn)
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int[] arr = new int[80000];
		 for(int i = 0;i < 80000;i++){
		 arr[i] = (int)(Math.random() * 80000); //�Զ�����[0,80000)֮��������
		 }

		// ����ǰ��ʱ��:
		Date data = new Date();
		SimpleDateFormat simt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateS = simt.format(data);
		System.out.println("����ǰ��ʱ����:" + dateS);

//		shellSort1(arr); // ����[����ʽ]����
		shellSort2(arr); // ����[��λʽ]����

		// ������ʱ��:
		Date data2 = new Date();
		SimpleDateFormat simt2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateS2 = simt2.format(data2);
		System.out.println("������ʱ����:" + dateS2);
	}
	// ϣ������[����ʽ]
	public static void shellSort1(int[] arr) {
		
		int temp = 0;
		int cnt = 0;
		// 1.����
		for (int grap = arr.length / 2; grap > 0; grap /= 2) {
			for (int i = grap; i < arr.length; i++) {
				// 2.�������������е�Ԫ��(��grap��,ÿ��?��Ԫ��),������grap
				for (int j = i - grap; j >= 0; j -= grap) {
					if (arr[j] > arr[j + grap]) {
						temp = arr[j];
						arr[j] = arr[j + grap];
						arr[j + grap] = temp;
					}
				}
			}
			//System.out.println("��" + (++cnt) + "������:" + Arrays.toString(arr));
		}
	}
	//// �Խ���ʽ��ϣ����������Ż�->��λ��
	public static void shellSort2(int[] arr) {
		
		// 1.����
		for (int grap = arr.length / 2; grap > 0; grap /= 2) {
			// ��num��Ԫ��,����������ڵ������ֱ�Ӳ�������
			for(int i=grap;i<arr.length;i++)
			{
				int j=i;//������Ƚϵ���������
				int temp=arr[j];//������Ƚϵ�����
				if(arr[j]<arr[j-grap])
				{
					while(j-grap>=0&&temp<arr[j-grap])
					{
						//�ƶ�
						arr[j]=arr[j-grap];//���������ͽ���
						j-=grap;//�����Ԫ�ؽ��н���������Ԫ������������Ԫ�ؼ�����
					}
				}
				arr[j]=temp;
			}
		}
	}

}
