#include<iostream>
using namespace std;
class CircleArrQueue{
	private:
		int maxSize;//��ʾ�����������
	    int front;//����ͷ
		int rear;//����β
		int* arr;//�������
	public:
		//�������ζ��еĹ����� 
		CircleArrQueue(int maxArrSize){
			maxSize=maxArrSize;
			front=0;
			rear=0;
			arr=new int[maxSize]{0};
		}
		//�ж϶����Ƿ����� 
		bool isFull(){
			return (rear+1)%maxSize==front; 
		}
		//�ж϶����Ƿ�Ϊ��
		bool isEmpty(){
			return rear==front;
		}
		//��������ӵ�����
		void addQueue(int n){
			if(isFull()){
				cout<<"��������������ʧ��"<<endl;
			}else{
				arr[rear]=n;
				//��rear���ƣ�������Ҫȡģ����Ϊ�ǻ��ζ��� 
				rear=(rear+1)%maxSize;
			} 
			
		} 
		//��ȡ���е�����,������ ,�����frontҲҪ����ȡģ����Ȼ��Խ�� 
		int getQueue(){
			if(isEmpty()){
				throw "����Ϊ��";
			}
			int flag=arr[front];
			front=(front+1)%maxSize;
			return flag;
		}
		//��ʾ���е����� 
		void showQueue(){
			if(isEmpty()){
				cout<<"�����ѿ�"<<endl;
			}
			else{
				for(int i=front;i<front+size();i++){
					cout<<arr[i%maxSize]<<"\t";
				}
			cout<<endl;
			}
			
		}
		//������Ч���ݸ���
		int size(){
			return (rear-front+maxSize)%maxSize;
		} 
		//��ʾ����ͷ���� 
		int headQueue(){
			if(isEmpty()){
				throw "����Ϊ��";	
			}
			return arr[front]; 
		}
}; 
int main()
{
	CircleArrQueue queue(4);//�������Ч������3�� 
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
