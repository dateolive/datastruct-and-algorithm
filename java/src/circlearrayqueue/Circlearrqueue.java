package circlearrayqueue;

import java.util.Scanner;

public class Circlearrqueue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		circlequeue queue=new circlequeue(4);//������Ч������3
		char ch = ' ';
		Scanner scanner = new Scanner(System.in);
		boolean loop = true;
		System.out.println("a.�������\tb.��ʾ����\tc.������\td.��ʾ����ͷ\te.�˳�");
		while (loop) {
			ch = scanner.next().charAt(0);
			switch (ch) {
			case 'a':
				System.out.println("������һ����");
				int n = scanner.nextInt();
				queue.addQueue(n);
				break;
			case 'b':
				queue.showQueue();
				break;
			case 'c':
				try {
					int res = queue.getQueue();
					System.out.println("ȡ����������" + res);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case 'd':
				try {
					int res = queue.headQueue();
					System.out.println("ȡ����������" + res);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case 'e':
				System.out.println("���˳�");
				loop = false;
				break;
			default:
				break;

			}
		}
	}

}
//���ζ���
class circlequeue {
	private int maxSize;// �������
	private int front;// ���ж���
	private int rear;// ��β
	private int[] arr;// ������ݵ�����

	// �������еĹ�����
	public circlequeue(int arrMaxSize) {
		maxSize = arrMaxSize;
		arr = new int[maxSize];
		front = 0;// ָ����е�ͷ��
		rear = 0;// ָ����е�β��
	}

	// �ж϶����Ƿ�����
	public boolean isFull() {
		return (rear + 1) % maxSize == front;
	}

	// �ж϶����Ƿ�Ϊ��
	public boolean isEmpty() {
		return rear == front;
	}

	// ��ӣ��������
	public void addQueue(int n) {
		if (isFull()) {
			System.out.println("��������");
			return;
		}
		// ��rear���ƣ���Ϊ�ǻ��ζ��У�����������Ҫȡģ����֤��Խ�����ǻ���
		arr[rear] = n;
		rear = (rear + 1) % maxSize;
	}

	// ���ӣ���ȡ����
	public int getQueue() {
		if (isEmpty()) {
			throw new RuntimeException("����Ϊ��");
		}
		int flag = arr[front];
		front = (front + 1) % maxSize;
		return flag;
	}

	// ��ʾ��������
	public void showQueue() {
		if (isEmpty()) {
			System.out.println("����Ϊ��");
			return;
		} else {
			for (int i = front; i <front + size(); i++) {
				System.out
						.printf("arr[%d]=%d\t", i % maxSize, arr[i % maxSize]);
			}
			System.out.println();
		}
	}

	// ������Ч���ݸ���
	public int size() {
		return (rear - front + maxSize) % maxSize;
	}

	// ��ʾ����ͷ����
	public int headQueue() {
		if (isEmpty()) {
			throw new RuntimeException("����Ϊ��");
		}
		return arr[front];
	}
}
