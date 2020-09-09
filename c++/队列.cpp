#include<iostream>
#include<string.h>
using namespace std;
class ArrayQueue{
	private:
		int maxSize;//��ʾ�����������
	    int front;//����ͷ
		int rear;//����β
		int* arr;//�������
	
	public:
		//�������еĹ����� 
		ArrayQueue(int arrMaxSize){
			maxSize=arrMaxSize;
			front=-1;//ָ����е�ͷ�� 
			rear=-1;//ָ����е�β��
			arr=new int[maxSize]{0};
		}
		//�ж϶����Ƿ����� 
		bool isFull(){
			return rear==maxSize-1; 
		}
		//�ж϶����Ƿ�Ϊ��
		bool isEmpty(){
			return rear==front;
		}
		//��������ӵ�����
		void addQueue(int n){
			if(isFull()){
				cout<<"��������������ʧ��"<<endl;
			}
			else{
				rear++;
				arr[rear]=n;	
			}
			
		} 
		//��ȡ���е�����,������ 
		int getQueue(){
			if(isEmpty()){
				throw "����Ϊ��";
			}
			front++;
			return arr[front];
		}
		//��ʾ���е����� 
		void showQueue(){
			if(isEmpty()){
				cout<<"�����ѿ�"<<endl;
			}
			else{
				for(int i=0;i<maxSize;i++){
					cout<<arr[i]<<"\t";
				}
			cout<<endl;
			}
			
		}
		//��ʾ����ͷ���� 
		int headQueue(){
			if(isEmpty()){
				throw "����Ϊ��";	
			}
			return arr[front+1]; 
		}
};
int main()
{
	ArrayQueue queue(3);
	cout<<"1.�������\t2.��ʾ����\t3.������\t4.��ʾ����ͷ"<<endl;
	int ch;
	int data;
	while(cin>>ch){
		switch(ch){
		case 1:
			cout<<"������һ������"<<endl;
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
