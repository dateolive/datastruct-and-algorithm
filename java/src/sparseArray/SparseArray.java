package sparseArray;

public class SparseArray {

	public static void main(String[] args) {
		//����һ��ԭʼ�Ķ�ά����
		int Arrary1[][]=new int[11][11];
		Arrary1[1][2]=1;
		Arrary1[2][3]=2;
		for(int[] row : Arrary1){
			for(int data : row)
			{
				System.out.printf("%d\t",data);
			}
			System.out.println();
		}
		//���б������ҵ���ά�����в�Ϊ0�ĸ���
		int sum=0;
		for(int i=0;i<Arrary1.length;i++)
		{
			for(int j=0;j<Arrary1[0].length;j++)
			{
				if(Arrary1[i][j]!=0){
					sum++;
				}
			}
		}
		System.out.println("��ά�����з�0����:"+sum);
		//1.����ϡ�����飬���ҽ���0���ݵ�����ֵд��
		int sparseArr[][]=new int[sum+1][3];
		int flag=0;//�����
		sparseArr[0][0]=Arrary1.length;
		sparseArr[0][1]=Arrary1[0].length;
		sparseArr[0][2]=sum;
		for(int i=0;i<Arrary1.length;i++)
		{
			for(int j=0;j<Arrary1[0].length;j++)
			{
				if(Arrary1[i][j]!=0){
					flag++;
					sparseArr[flag][0]=i;
					sparseArr[flag][1]=j;
					sparseArr[flag][2]=Arrary1[i][j];
					
				}
			}
		}
		System.out.println("ϡ������Ϊ:");
		for(int i=0;i<sparseArr.length;i++)
		{
			System.out.printf("%d\t%d\t%d\t",sparseArr[i][0],sparseArr[i][1],sparseArr[i][2]);
			System.out.println();
		}
		//��ϡ������ת���ɶ�ά����
		int Arrary2[][]=new int [sparseArr[0][0]][sparseArr[0][1]];
		for(int i=1;i<sparseArr.length;i++)
		{
			Arrary2[sparseArr[i][0]][sparseArr[i][1]]=sparseArr[i][2];
		}
		System.out.println("�ָ���Ķ�ά����:");
		for(int[] row : Arrary2){
			for(int data : row)
			{
				System.out.printf("%d\t",data);
			}
			System.out.println();
		}
	}

}
