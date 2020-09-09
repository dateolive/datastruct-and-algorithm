#include<bits/stdc++.h>
using namespace std;
int main()
{
	//稀疏数组和二维数组的转化 ,压缩作用 
	//1.创建一个原始数组  11*11
	int Arrary1[11][11]={};
	Arrary1[1][2]=1;
	Arrary1[2][3]=2;
	cout<<"原始数组如下："<<endl;
	for(int i=0;i<11;i++)
	{
		for(int j=0;j<11;j++)
		{
			cout<<Arrary1[i][j]<<" ";
		}	
		cout<<endl;
	}
	//2.二维数组转化稀疏数组 
	//1).遍历原始数组，获得非0数据个数
	int sum=0;
	for(int i=0;i<11;i++)
	{
		for(int j=0;j<11;j++)
		{
			if(Arrary1[i][j]!=0)
			sum++;
		}	
		
	}
	cout<<"非0数据个数："<<sum<<endl;
	//2).创建稀疏数组,并且赋值 
	int sparseArr[sum+1][3]={0};
	int rows=sizeof(Arrary1)/sizeof(Arrary1[0]);
	int cols=sizeof(Arrary1[0])/sizeof(Arrary1[0][0]);
	sparseArr[0][0]=rows;
	sparseArr[0][1]=cols;
	sparseArr[0][2]=sum;
	//3).遍历将值赋给稀疏数组，用标记器
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
	//4).遍历输出稀疏数组
	cout<<"稀疏数组为:"<<endl;
	for(int i=0;i<sizeof(sparseArr[0])/sizeof(int);i++)
	{
		cout<<sparseArr[i][0]<<"\t"<<sparseArr[i][1]<<"\t"<<sparseArr[i][2]<<endl;
	}
	//3.将稀疏数组转化成二维数组
	int Arrary2[rows][cols]={};
	cout<<rows<<" "<<cols<<endl;
	for(int i=1;i<sizeof(sparseArr[0])/sizeof(int);i++)
	{
		Arrary2[sparseArr[i][0]][sparseArr[i][1]]=sparseArr[i][2];

	}
	cout<<"原始数组为:"<<endl; 
	for(int i=0;i<rows;i++)
	{
		for(int j=0;j<cols;j++)
		{
			cout<<Arrary2[i][j]<<" ";
		}
		cout<<endl;
		
	}
	

	 
}
