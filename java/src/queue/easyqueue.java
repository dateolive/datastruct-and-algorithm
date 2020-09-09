package queue;

import java.util.Scanner;

public class easyqueue {

	public static void main(String[] args) {
		ArrayQueue queue=new ArrayQueue(3);
		char ch=' ';
		Scanner scanner=new Scanner(System.in);
		boolean loop=true;
		System.out.println("a.�������\tb.��ʾ����\tc.������\td.��ʾ����ͷ\te.�˳�");
		while(loop){
			ch=scanner.next().charAt(0);
			switch(ch){
			case 'a':
				System.out.println("������һ����");
				int n=scanner.nextInt();
				queue.addQueue(n);
				break;
			case 'b':
				queue.showQueue();
				break;
			case 'c':
				try{
					int res=queue.getQueue();
					System.out.println("ȡ����������"+res);
				}catch(Exception e){
					System.out.println(e.getMessage());
				}
				break;
			case 'd':
				try{
					int res=queue.headQueue();
					System.out.println("ȡ����������"+res);
				}catch(Exception e){
					System.out.println(e.getMessage());
				}
				break;
			case 'e':
				System.out.println("���˳�");
				loop=false;
				break;
			default:
				break;
			
			
			}
		}
		

	}

}
class ArrayQueue{
	private int maxSize;//�������
	private int front;//���ж���
	private int rear;//��β
	private int[] arr;//������ݵ�����
	//�������еĹ����� 
	public ArrayQueue(int arrMaxSize){
		maxSize=arrMaxSize;
		arr=new int[maxSize]; 
		front=-1;//ָ����е�ͷ��
		rear=-1;//ָ����е�β��
	}
	//�ж϶����Ƿ�����
	public boolean isFull(){
		return rear==maxSize-1;
	}
	//�ж϶����Ƿ�Ϊ��
	public boolean isEmpty(){
		return rear==front;
	}
	//��ӣ�������ݵ�����
	public void addQueue(int n){
		if(isFull()){
			System.out.println("��������");
			return;
		}
		rear++;
		arr[rear]=n;
		
	}
	//���ӣ���ȡ��������
	public int getQueue(){
		if(isEmpty()){
			throw new RuntimeException("����Ϊ��");
		}
		front++;
		return arr[front];
	}
	//��ʾ��������
	public void showQueue(){
		if(isEmpty()){
			System.out.println("����Ϊ��");
			return;
		}else{
			for(int i=0;i<arr.length;i++)
			{
				System.out.printf("arr[%d]=%d\t",i,arr[i]);
			}
			System.out.println();
		}
	}
	//��ʾ����ͷ����
	public int headQueue(){
		if(isEmpty()){
			throw new RuntimeException("����Ϊ��");
		}
		return arr[front+1];
	}
	
}