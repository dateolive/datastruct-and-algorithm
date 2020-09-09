#include<iostream>
using namespace std;
class CircleArrQueue{
	private:
		int maxSize;//表示数组最大容量
	    int front;//队列头
		int rear;//队列尾
		int* arr;//存放数据
	public:
		//创建环形队列的构造器 
		CircleArrQueue(int maxArrSize){
			maxSize=maxArrSize;
			front=0;
			rear=0;
			arr=new int[maxSize]{0};
		}
		//判断队列是否已满 
		bool isFull(){
			return (rear+1)%maxSize==front; 
		}
		//判断队列是否为空
		bool isEmpty(){
			return rear==front;
		}
		//将数据添加到队列
		void addQueue(int n){
			if(isFull()){
				cout<<"队列已满，加入失败"<<endl;
			}else{
				arr[rear]=n;
				//将rear后移，这里需要取模，因为是环形队列 
				rear=(rear+1)%maxSize;
			} 
			
		} 
		//获取队列的数据,出队列 ,这里的front也要考虑取模，不然会越界 
		int getQueue(){
			if(isEmpty()){
				throw "队列为空";
			}
			int flag=arr[front];
			front=(front+1)%maxSize;
			return flag;
		}
		//显示队列的数据 
		void showQueue(){
			if(isEmpty()){
				cout<<"队列已空"<<endl;
			}
			else{
				for(int i=front;i<front+size();i++){
					cout<<arr[i%maxSize]<<"\t";
				}
			cout<<endl;
			}
			
		}
		//计算有效数据个数
		int size(){
			return (rear-front+maxSize)%maxSize;
		} 
		//显示队列头数据 
		int headQueue(){
			if(isEmpty()){
				throw "队列为空";	
			}
			return arr[front]; 
		}
}; 
int main()
{
	CircleArrQueue queue(4);//这里的有效数据是3个 
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
