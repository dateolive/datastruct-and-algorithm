#include<bits/stdc++.h>
using namespace std;
int main()
{
	//ϡ������Ͷ�ά�����ת�� ,ѹ������ 
	//1.����һ��ԭʼ����  11*11
	int Arrary1[11][11]={};
	Arrary1[1][2]=1;
	Arrary1[2][3]=2;
	cout<<"ԭʼ�������£�"<<endl;
	for(int i=0;i<11;i++)
	{
		for(int j=0;j<11;j++)
		{
			cout<<Arrary1[i][j]<<" ";
		}	
		cout<<endl;
	}
	//2.��ά����ת��ϡ������ 
	//1).����ԭʼ���飬��÷�0���ݸ���
	int sum=0;
	for(int i=0;i<11;i++)
	{
		for(int j=0;j<11;j++)
		{
			if(Arrary1[i][j]!=0)
			sum++;
		}	
		
	}
	cout<<"��0���ݸ�����"<<sum<<endl;
	//2).����ϡ������,���Ҹ�ֵ 
	int sparseArr[sum+1][3]={0};
	int rows=sizeof(Arrary1)/sizeof(Arrary1[0]);
	int cols=sizeof(Arrary1[0])/sizeof(Arrary1[0][0]);
	sparseArr[0][0]=rows;
	sparseArr[0][1]=cols;
	sparseArr[0][2]=sum;
	//3).������ֵ����ϡ�����飬�ñ����
	int flag=0; 
	for(int i=0;i<11;i++)
	{
		for(int j=0;j<11;j++)
		{
			if(Arrary1[i][j]!=0)
			{
				flag++;
				sparseArr[flag][0]=i;
				sparseArr[flag][1]=j;
				sparseArr[flag][2]=Arrary1[i][j];
			}
			
		}	
		
	}
	//4).�������ϡ������
	cout<<"ϡ������Ϊ:"<<endl;
	for(int i=0;i<sizeof(sparseArr[0])/sizeof(int);i++)
	{
		cout<<sparseArr[i][0]<<"\t"<<sparseArr[i][1]<<"\t"<<sparseArr[i][2]<<endl;
	}
	//3.��ϡ������ת���ɶ�ά����
	int Arrary2[rows][cols]={};
	cout<<rows<<" "<<cols<<endl;
	for(int i=1;i<sizeof(sparseArr[0])/sizeof(int);i++)
	{
		Arrary2[sparseArr[i][0]][sparseArr[i][1]]=sparseArr[i][2];

	}
	cout<<"ԭʼ����Ϊ:"<<endl; 
	for(int i=0;i<rows;i++)
	{
		for(int j=0;j<cols;j++)
		{
			cout<<Arrary2[i][j]<<" ";
		}
		cout<<endl;
		
	}
	

	 
}
