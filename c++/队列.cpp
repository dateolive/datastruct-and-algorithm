#include<iostream>
#include<string.h>
using namespace std;
class ArrayQueue{
	private:
		int maxSize;//表示数组最大容量
	    int front;//队列头
		int rear;//队列尾
		int* arr;//存放数据
	
	public:
		//创建队列的构造器 
		ArrayQueue(int arrMaxSize){
			maxSize=arrMaxSize;
			front=-1;//指向队列的头部 
			rear=-1;//指向队列的尾部
			arr=new int[maxSize]{0};
		}
		//判断队列是否已满 
		bool isFull(){
			return rear==maxSize-1; 
		}
		//判断队列是否为空
		bool isEmpty(){
			return rear==front;
		}
		//将数据添加到队列
		void addQueue(int n){
			if(isFull()){
				cout<<"队列已满，加入失败"<<endl;
			}
			else{
				rear++;
				arr[rear]=n;	
			}
			
		} 
		//获取队列的数据,出队列 
		int getQueue(){
			if(isEmpty()){
				throw "队列为空";
			}
			front++;
			return arr[front];
		}
		//显示队列的数据 
		void showQueue(){
			if(isEmpty()){
				cout<<"队列已空"<<endl;
			}
			else{
				for(int i=0;i<maxSize;i++){
					cout<<arr[i]<<"\t";
				}
			cout<<endl;
			}
			
		}
		//显示队列头数据 
		int headQueue(){
			if(isEmpty()){
				throw "队列为空";	
			}
			return arr[front+1]; 
		}
};
int main()
{
	ArrayQueue queue(3);
	cout<<"1.添加数据\t2.显示数据\t3.出队列\t4.显示队列头"<<endl;
	int ch;
	int data;
	while(cin>>ch){
		switch(ch){
		case 1:
			cout<<"请输入一个数据"<<endl;
			cin>>data;
			queue.addQueue(data);
			break;
		case 2:
			queue.showQueue();
			break;
		case 3:
			try{
				int getdata=queue.getQueue();
				cout<<getdata<<endl;
			}catch (const char* msg) {
     			cerr << msg << endl;
   			}
			break;
		case 4:
			try{
				int gethead=queue.headQueue();
				cout<<gethead<<endl;
			}catch (const char* msg) {
     			cerr << msg << endl;
   			}
			break;
		default:
			break;
			
		}
	}
	cout<<"over"<<endl;
	
	
}
